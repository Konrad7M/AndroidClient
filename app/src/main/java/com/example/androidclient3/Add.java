package com.example.androidclient3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
    RequestController requestController;
    EditText inp_role,inp_login;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        requestController = new RequestController();
        inp_login = findViewById(R.id.login);
        inp_role = findViewById(R.id.role);
        message = findViewById(R.id.add_message);
        Button addrole = findViewById(R.id.addrole);
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<RoleDto> roles = (ArrayList<RoleDto>) requestController.getRoles();
                ArrayList<UserDto> users = (ArrayList<UserDto>) requestController.getAllUsers();
                boolean one = false, two = true;

                String rolename = inp_role.getText().toString();
                String nameusr = inp_login.getText().toString();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                String msg = "";

                if(!rolename.equals("")&&!nameusr.equals("")){



                for (int i = 0; i < roles.size(); i++) {

                    if (rolename.equals(roles.get(i).getRole()))
                        one = true;
                }
                for (int i = 0; i < users.size(); i++) {

                    if (nameusr.equals(users.get(i).getLogin()))
                        two = false;
                }
                if (one && two) {
                    requestController.addUser(nameusr, rolename);
                    msg += "request send ";
                } else {
                    if (!one) {
                        msg += "this role doesn't exist \n\n";
                    }
                    if (!two) {

                        msg += "this user already exist ";
                    }


                }
            }else{msg+="forms incomplate";}

                Toast toast = Toast.makeText(context,msg, duration);
                toast.show();

            }

        });

        addrole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                ArrayList<RoleDto> roles = (ArrayList<RoleDto>) requestController.getRoles();
                boolean one = false;
                String rolename = inp_role.getText().toString();
                if(!rolename.equals("")){
                for (int i = 0 ; i< roles.size(); i++) {
                    if (rolename.equals(roles.get(i).getRole()))
                        one = true;
                }

                if(!one){
                    requestController.addRole(rolename);
                    Toast toast = Toast.makeText(context,"request send", duration);
                    toast.show();

                }
                else   {
                    Toast toast = Toast.makeText(context,"this role already exists ", duration);
                    toast.show();}

            }else{
                    Toast toast = Toast.makeText(context,"Role name required ", duration);
                    toast.show();

                }
            }
        });


    }
}
