package com.suranku.users.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.suranku.users.dao.StandardResponse;
import com.suranku.users.service.UsersService;
import com.suranku.util.AsyncThreadUtil;
import com.suranku.util.HttpServletRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;

@Api(tags = "Users-Service")
@Path("/")
@Component
public class UsersServiceImpl implements UsersService{

    @Context
    HttpServletRequest request;

    String pingReceived = "Ping Received";

    /**
     * Registers ping if service is running.
     *
     * @param asyncResponse - Asynchronous response object to hold service response
     */
    @GET
    @ApiOperation(value = "Ping to test the API")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ping received successfully",
            response = StandardResponse.class)})
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void ping(@Suspended AsyncResponse asyncResponse) {
        final String requestUri = HttpServletRequestUtil.getFullRequestUri(request);
        final String requestMethod = request.getMethod();

        AsyncThreadUtil.createThread(asyncResponse, () -> {
            StandardResponse responseEntity = new StandardResponse.Builder<>()
                    .code(Response.Status.OK.getStatusCode())
                    .message(pingReceived)
                    .uri(requestUri).method(requestMethod).build();
            asyncResponse.resume(Response.status(Response.Status.OK).entity(responseEntity).build());
        }).start();
    }
}


