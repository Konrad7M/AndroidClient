package com.example.androidclient3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText  input;
    TextView message;
    RequestController requester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input = findViewById(R.id.txtinput);
         message=findViewById(R.id.message);
        requester = new RequestController();

        Button allUsers = (Button) findViewById(R.id.AllUsers);
        allUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),UsersPage.class);
                startIntent.putExtra("com.example.AndroidClient.mode","all");
                startActivity(startIntent);
            }

        });

        Button searchUser = (Button) findViewById(R.id.SearchUsers);
        searchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                String x = input.getText().toString();



                if(!x.equals("")) {
                    UserDto user = requester.getUser(x);

                if(user!=null){

                    Toast toast = Toast.makeText(context, user.getLogin()+" exists, role: " + user.getRole().getRole(), duration);
                    toast.show();
                }else  {

                    Toast toast = Toast.makeText(context, "user doesn't exist", duration);
                    toast.show();
                }
            }else{
                    Toast toast = Toast.makeText(context, "form is empty", duration);
                    toast.show();
                }

            }

        });

        Button usersByRole = (Button) findViewById(R.id.UsersByRole);
        usersByRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!input.getText().toString().equals("")){
                Intent startIntent = new Intent(getApplicationContext(),UsersPage.class);
                startIntent.putExtra("com.example.AndroidClient.mode","by_role");
                startIntent.putExtra("com.example.AndroidClient.input",input.getText().toString());
                startActivity(startIntent);
                }else{
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "form is empty", duration);
                    toast.show();

                }
            }

        });

        Button allroles = (Button) findViewById(R.id.AllRoles);
        allroles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),RolePage.class);
                startIntent.putExtra("com.example.AndroidClient.etwas",input.getText().toString());
                startActivity(startIntent);
            }

        });

        Button adbutton = (Button) findViewById(R.id.addbutton);
        adbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Add.class);
                startActivity(startIntent);
            }

        });

    }
}
