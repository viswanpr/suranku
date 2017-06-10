package com.suranku.config;

import javax.ws.rs.ApplicationPath;

import com.suranku.users.service.impl.UsersServiceImpl;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


/**
 * Configurations for jersey services.
 *
 * @author Pragadeeswar
 */
@Component
@ApplicationPath("api")
@ComponentScan
public class JerseyConfig extends ResourceConfig {

    private String swaggerTitle = "Suranku Test";
    private String swaggerDescription = "Testing swagger";

    public JerseyConfig() {
        register(UsersServiceImpl.class);
        this.configureSwagger();
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle(swaggerTitle);
        config.setBasePath("/api");
        config.setResourcePackage("com.suranku.users.service.impl");
        config.setPrettyPrint(true);
        config.setDescription(swaggerDescription);
        config.setScan(true);
    }
}
