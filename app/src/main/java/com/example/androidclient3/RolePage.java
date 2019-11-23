package com.example.androidclient3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RolePage extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_page2);

        RequestController requester = new RequestController();

        List<RoleDto> roles = requester.getRoles();

        RoleAdapter roleAdapter = new RoleAdapter(roles);




        recyclerView = findViewById(R.id.roleList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(roleAdapter);



        //roles = (ArrayList<RoleDto>) requester.getRoles();








    }
}
