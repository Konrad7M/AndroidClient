package com.example.androidclient3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView text = (TextView) findViewById(R.id.andtextView);
        String txt = getIntent().getExtras().getString("com.example.AndroidClient.etwas");
        text.setText(txt);

    }
}
