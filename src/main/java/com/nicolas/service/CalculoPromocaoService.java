package com.nicolas.service;

import com.nicolas.model.entity.IngredienteLanche;
import com.nicolas.model.entity.Lanche;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class CalculoPromocaoService {

    public void setValorPromocao(Lanche lanche) {
        if (Objects.isNull(lanche.getIngredientes()) || lanche.getIngredientes().isEmpty()) {
            lanche.setPreco(0.0);
            return;
        }
        sanitazeNomesIngredientes(lanche);
        Double precoTotalIngredientes = lanche.getIngredientes().stream().mapToDouble((i) -> i.getIngrediente().getPreco() * i.getQtdIngrediente()).sum();
        lanche.setPreco(precoTotalIngredientes);
        setLight(lanche);
        setMuitaCarne(lanche);
        setPrecoFinalRounded(lanche);
    }

    private void setLight(Lanche lanche) {
        boolean temAlface = false;
        boolean naoTemBacon = true;
        for (IngredienteLanche ingredienteLanche : lanche.getIngredientes()) {
            if (ingredienteLanche.getIngrediente().getNome().equals("alface")) temAlface = true;
            else if (ingredienteLanche.getIngrediente().getNome().equals("bacon")) naoTemBacon = false;
            if (temAlface && naoTemBacon) {
                lanche.setPreco(lanche.getPreco() * 0.9);
                break;
            }
        }
    }

    private void setMuitaCarne(Lanche lanche) {
        setPromocaoMuito(lanche,"hambúrguer");
    }

    private void setMuitoQueijo(Lanche lanche) {
        setPromocaoMuito(lanche, "queijo");
    }

    private void setPromocaoMuito(Lanche lanche, String idIngrediente) {
        double qtdIngrediente = 0.0;
        double precoIngrediente = 0.0;
        for (IngredienteLanche ingredienteLanche : lanche.getIngredientes()) {
            if (ingredienteLanche.getIngrediente().getNome().equals(idIngrediente)) {
                qtdIngrediente = ingredienteLanche.getQtdIngrediente();
                precoIngrediente = ingredienteLanche.getIngrediente().getPreco();
                break;
            }
        }
        if (qtdIngrediente < 3) return;

        double precoSemIngrediente = lanche.getPreco() - qtdIngrediente * precoIngrediente;

        double qtdPorcoes = 3.0;
        double valorPromocaoPorcao = 2.0;
        while (qtdPorcoes < qtdIngrediente) {
            qtdPorcoes *= 2;
            valorPromocaoPorcao *= 2;
        }

        if (qtdPorcoes > qtdIngrediente) {
            qtdPorcoes /= 2;
            valorPromocaoPorcao /= 2;
        }

        double precoComoAvulso = (qtdIngrediente - qtdPorcoes) * precoIngrediente;
        double precoComoPorcao = valorPromocaoPorcao * precoIngrediente;

        lanche.setPreco(precoSemIngrediente + precoComoAvulso + precoComoPorcao);
    }

    private void sanitazeNomesIngredientes(Lanche lanche) {
        lanche.getIngredientes().forEach((i) -> i.getIngrediente().setNome(i.getIngrediente().getNome().toLowerCase().replace("\\s+","_")));
    }

    private void setPrecoFinalRounded(Lanche lanche) {
        lanche.setPreco(BigDecimal.valueOf(lanche.getPreco()).setScale(2, RoundingMode.DOWN).stripTrailingZeros().doubleValue());
    }
}
