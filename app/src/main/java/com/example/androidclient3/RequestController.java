package com.example.androidclient3;

import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RequestController {
    private List<UserDto> userList;
    private List<RoleDto> roleList;
    private UserDto user;
    private Retrofit retrofit ;
    private TestService testService;

    public RequestController(){

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.101:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        testService = retrofit.create(TestService.class);
    }

    private void loadUser(String login){

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            UserDto tuser = testService.getUser(login).execute().body();
            RequestController.this.user =  tuser;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public UserDto getUser(String login){
        loadUser(login);
        UserDto temp = user;
        user = null;
        return temp;
    }

    private void loadGetAllUsers(){
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            List<UserDto> usrlist = testService.getAllUsers().execute().body();
            RequestController.this.userList =  usrlist;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<UserDto> getAllUsers(){

        loadGetAllUsers();
        List<UserDto> temporary = this.userList;
        userList = null;
        return temporary;
    }

    private void loadUserswRole(String role){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            List<UserDto> usrlist = testService.getUserswRole(role).execute().body();
            RequestController.this.userList =  (ArrayList<UserDto>) usrlist;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<UserDto> getUserswRole(String role){

        loadUserswRole(role);
        List<UserDto> temp = this.userList;
        userList=null;
        return temp;


    }

    private void loadRoles(){

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            List<RoleDto> roletemp = testService.getRoles().execute().body();
            RequestController.this.roleList =  roletemp;

        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    public List<RoleDto> getRoles(){

        loadRoles();
        List<RoleDto> temp = this.roleList;
        this.roleList = null;
        return temp;

    }

    public void addUser(String login,String role){

        try {
            testService.addUser(new UserDto(login, role)).execute().body();
        }catch (Exception e){e.printStackTrace();}



    }

    public void addRole(String role){

        try {
            testService.addRole(new RoleDto(role)).execute().body();
        }catch (Exception e)
        {e.printStackTrace();}



    }
}
