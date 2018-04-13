package com.asd.aem.ktln.core.injectors.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.spi.injectorspecific.InjectAnnotation;

@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@InjectAnnotation
@Source("cookie")
public @interface CookieValue {
}
