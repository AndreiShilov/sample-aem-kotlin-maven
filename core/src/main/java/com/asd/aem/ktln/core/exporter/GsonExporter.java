package com.asd.aem.ktln.core.exporter;

import java.util.Map;

import org.apache.sling.models.export.spi.ModelExporter;
import org.apache.sling.models.factory.ExportException;

import com.google.gson.Gson;

// Generally not applicable for models because gson uses fields serialization
@org.osgi.service.component.annotations.Component(service = ModelExporter.class)
public class GsonExporter implements ModelExporter {


    @Override
    public boolean isSupported(Class<?> clazz) {
        return clazz.equals(String.class);
    }

    @Override
    public <T> T export(Object model, Class<T> clazz, Map<String, String> options) throws ExportException {
        return (T) new Gson().toJson(model);
    }

    @Override
    public String getName() {
        return "gson";
    }
}

