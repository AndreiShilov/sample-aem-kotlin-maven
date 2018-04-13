package com.asd.aem.ktln.core;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = CredentialsService.class, immediate = true)
@Designate(ocd = CredentialsService.Config.class)
public class CredentialsService {


    @ObjectClassDefinition(name = "Credentials Service",
            description = "Secret Service holds credentials for some secret third party service")
    public static @interface Config {

        @AttributeDefinition(
                name = "Password Property",
                description = "Password String property",
                type = AttributeType.STRING
        )
        String password() default "password";


        @AttributeDefinition(
                name = "Login Property",
                description = "Login String property",
                type = AttributeType.STRING
        )
        String login() default "login";

        @AttributeDefinition(
                name = "User Secret Property",
                description = "Use Secret boolean value",
                type = AttributeType.BOOLEAN
        )
        boolean useSecret() default true;
    }


    private String password;
    private String login;
    private boolean useSecret;


    @Activate
    public void activate(Config config) {
        password = config.password();
        login = config.login();
        useSecret = config.useSecret();
    }


    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public boolean isUseSecret() {
        return useSecret;
    }
}
