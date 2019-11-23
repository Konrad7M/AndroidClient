package com.example.androidclient3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TestService {
    @GET("users/{login}")
    Call<UserDto> getUser(@Path("login") String login);

    @GET("users/")
    Call<List<UserDto>> getAllUsers();

    @GET("users/byRole/{role}")
    Call<List<UserDto>> getUserswRole(@Path("role") String role);

    @GET("roles")
   Call<List<RoleDto>> getRoles();



    @POST("users/")
    Call<UserDto>  addUser(@Body UserDto user);

    @POST("roles/")
    Call<RoleDto>  addRole(@Body RoleDto role);

}

