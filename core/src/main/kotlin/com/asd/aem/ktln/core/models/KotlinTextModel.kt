package com.asd.aem.ktln.core.models

import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.Default
import org.apache.sling.models.annotations.Model
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy
import org.apache.sling.models.annotations.injectorspecific.Self
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue
import javax.annotation.PostConstruct

@Model(adaptables = arrayOf(Resource::class))
class KotlinTextModel {

    @Self
    lateinit var resource: Resource;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Default(values = arrayOf("Default value"))
    lateinit var text: String

    @PostConstruct
    fun init() {
        text = text.toUpperCase();
    }


}