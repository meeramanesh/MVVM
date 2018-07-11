package com.s4m.mvvmtest.service;

import com.s4m.mvvmtest.model.User.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * File Description
 * ------------------
 * Author : meera
 * Email : meera@farabi.ae
 * Date : 7/5/2018
 * Project : AndroidUpdates
 * Company : Farabi Technology
 */
public interface WebService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") int userId);


}
