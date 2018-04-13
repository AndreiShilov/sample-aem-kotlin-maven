package com.asd.aem.ktln.core.models;

import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.adobe.cq.export.json.SlingModelFilter;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, adapters = {Component.class})
@XmlRootElement
public class BasicExporterComponent implements Component {

    @ScriptVariable
    private com.day.cq.wcm.api.components.Component component;

    @ScriptVariable
    private ValueMap properties;

    @OSGiService
    private SlingModelFilter slingModelFilter;


    @Override
    @XmlElement
    public String getName() {
        return component.getName();
    }

    @Override
    @XmlElement
    public Map<String, Object> getConfig() {
        return slingModelFilter.filterProperties(properties);
    }
}
