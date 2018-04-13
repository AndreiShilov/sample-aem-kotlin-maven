package com.asd.aem.ktln.core.injectors;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

import javax.servlet.http.Cookie;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.jetbrains.annotations.NotNull;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.asd.aem.ktln.core.injectors.annotations.CookieValue;

@Component(service = {Injector.class},
        property = {Constants.SERVICE_RANKING + "=Integer:5000"}
)
public class CookieInjector implements Injector {
    @Override
    public String getName() {
        return "cookie";
    }

    @Override
    public Object getValue(@NotNull Object adaptable, String name, @NotNull Type type,
                           @NotNull AnnotatedElement annotatedElement, @NotNull DisposalCallbackRegistry disposalCallbackRegistry) {

        CookieValue cookieValueAnnotation = annotatedElement.getAnnotation(CookieValue.class);

        if (cookieValueAnnotation == null) {
            return null;
        }

        if (!(adaptable instanceof SlingHttpServletRequest)) {
            return null;
        }

        SlingHttpServletRequest request = (SlingHttpServletRequest) adaptable;

        Cookie cookie = request.getCookie(name);

        if (cookie == null) {
            return null;
        }


        return cookie.getValue();
    }

}
