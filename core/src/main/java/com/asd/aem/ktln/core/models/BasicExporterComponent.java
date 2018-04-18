package com.asd.aem.ktln.core.models;

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.adobe.cq.export.json.SlingModelFilter;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, adapters = {Component.class})
public class BasicExporterComponent implements Component {

    @ScriptVariable
    private com.day.cq.wcm.api.components.Component component;

    @ScriptVariable
    private ValueMap properties;

    @OSGiService
    private SlingModelFilter slingModelFilter;


    @Override
    public String getName() {
        return component.getName();
    }

    @Override
    public Map<String, Object> getConfig() {
        return slingModelFilter.filterProperties(properties);
    }
}
