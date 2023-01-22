package com.nicolas.model.entity.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nicolas.model.entity.Lanche;

import java.io.IOException;

public class LancheSerializer extends StdSerializer<Lanche> {

    public LancheSerializer() {
        this(null);
    }

    public LancheSerializer(Class<Lanche> t) {
        super(t);
    }

    @Override
    public void serialize(Lanche lanche, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        System.out.println(lanche);
    }
}
