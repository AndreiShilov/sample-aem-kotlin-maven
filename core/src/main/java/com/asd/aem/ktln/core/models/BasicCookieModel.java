package com.asd.aem.ktln.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.asd.aem.ktln.core.injectors.annotations.CookieValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BasicCookieModel {

    @CookieValue
    private String myCustomCookieName;

    @CookieValue
    private String wcmmode;

    public String getMyCustomCookieName() {
        return myCustomCookieName;
    }

    public String getWcmmode() {
        return wcmmode;
    }
}
