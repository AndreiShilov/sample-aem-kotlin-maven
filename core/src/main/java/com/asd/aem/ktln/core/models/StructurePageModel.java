package com.asd.aem.ktln.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;

import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.export.json.SlingModelFilter;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
        resourceType = {
                "aem-ktln/components/structure/page",
                "wcm/foundation/components/parsys"
        }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        adapters = {ContainerComponent.class, Component.class})
@Exporter(name =ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class StructurePageModel implements ContainerComponent {

    private List<? extends Component> childrenModels;

    @OSGiService
    private ModelFactory modelFactory;

    @OSGiService
    private SlingModelFilter slingModelFilter;

    @Self
    private SlingHttpServletRequest request;

    @ScriptVariable
    private com.day.cq.wcm.api.components.Component component;

    @ScriptVariable
    private ValueMap pageProperties;

    @Override
    @XmlElement
    public List<? extends Component> getItems() {
        if (childrenModels == null) {
            childrenModels = getChildrenModels(request, Component.class);
        }
        return childrenModels;
    }


    private <T> List<T> getChildrenModels(SlingHttpServletRequest request, Class<T>
            modelClass) {
        List<T> models = new ArrayList<>();
        for (Resource child : slingModelFilter.filterChildResources(request.getResource().getChildren())) {
            T model = modelFactory.getModelFromWrappedRequest(request, child, modelClass);
            if (model != null) {
                models.add(model);
            }
        }
        return models;
    }

    @Override
    public String getName() {
        return component.getName();
    }

    @Override
    public Map<String, Object> getConfig() {
        return slingModelFilter.filterProperties(pageProperties);
    }
}
