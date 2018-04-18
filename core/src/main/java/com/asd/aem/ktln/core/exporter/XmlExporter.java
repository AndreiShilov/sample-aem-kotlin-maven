package com.asd.aem.ktln.core.exporter;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.sling.models.export.spi.ModelExporter;
import org.apache.sling.models.factory.ExportException;

@org.osgi.service.component.annotations.Component(service = ModelExporter.class)
public class XmlExporter implements ModelExporter {

    @Override
    public boolean isSupported(Class<?> clazz) {
        return clazz.equals(String.class);
    }

    @Override
    public <T> T export(Object model, Class<T> clazz, Map<String, String> options) throws ExportException {

        try {
            JAXBContext jaxbContext =
                    JAXBContext.newInstance(model.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(model, sw);
            return (T) sw.toString();
        } catch (JAXBException e) {
            throw new ExportException(e);
        }
    }

    @Override
    public String getName() {
        return "custom-xml";
    }
}
