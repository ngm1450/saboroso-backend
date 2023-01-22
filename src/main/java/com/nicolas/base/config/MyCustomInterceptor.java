package com.nicolas.base.config;

import com.nicolas.model.entity.Ingrediente;
import com.nicolas.model.entity.IngredienteLanche;
import com.nicolas.model.entity.Lanche;
import com.nicolas.service.CalculoPromocaoService;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class MyCustomInterceptor extends EmptyInterceptor implements HibernatePropertiesCustomizer {

    private final CalculoPromocaoService calculoPromocaoService;

    @Autowired
    public MyCustomInterceptor(CalculoPromocaoService calculoPromocaoService) {
        this.calculoPromocaoService = calculoPromocaoService;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", this);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, org.hibernate.type.Type[] types) {
//        if (entity instanceof Lanche) {
//            ((Lanche) entity).setIngredientes((List<IngredienteLanche>) Arrays.stream(state).findFirst().get());
//            calculoPromocaoService.setValorPromocao((Lanche) entity);
//        }
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public void afterTransactionCompletion(Transaction tx) {
        super.afterTransactionCompletion(tx);
    }
}