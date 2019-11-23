package com.example.androidclient3;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<UserDto> users ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);
        RequestController requester = new RequestController();


        switch (getIntent().getExtras().getString("com.example.AndroidClient.mode"))
        {
            case "all" :{
                users = (ArrayList<UserDto>) requester.getAllUsers();
                break;
            }

            case "by_role" : {
                users = (ArrayList<UserDto>) requester.getUserswRole(getIntent().getExtras().getString("com.example.AndroidClient.input"));
                break;
            }
        }

        UserAdapter userAdapter = new UserAdapter(users);
        recyclerView = findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(userAdapter);

        Debug.startMethodTracing("sample");


    }
}

