package com.example.androidclient3;

public class UserDto {
    private String login;
    private RoleDto role;

    public UserDto (String login, String rolr){

        this.login = login;
        role = new RoleDto(rolr);


    }

    public String getLogin() {
        return login;
    }

    public RoleDto getRole(){ return role;}

    public void setLogin(String login) {
        this.login = login;
    }
}

