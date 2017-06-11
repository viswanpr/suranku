package com.suranku.users.service;

import javax.ws.rs.container.AsyncResponse;

public interface UsersService {

    /**
     * Registers ping if service is running.
     *
     * @param asyncResponse - Asynchronous response object to hold service response
     */
    void ping(AsyncResponse asyncResponse);

    /**
     * Retrieves list of all users.
     *
     * @param asyncResponse - Asynchronous response object to hold service response
     */
    void getUsers(AsyncResponse asyncResponse);
}
