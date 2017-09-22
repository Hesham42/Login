package com.example.heshammostafa.login;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.heshammostafa.login.DataBase.Database;

public class student extends AppCompatActivity {
    Typeface fonts1;
    CheckBox remember;
    int coutn=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Database db= new Database(this);


        remember = (CheckBox)findViewById(R.id.remember);

        fonts1 =  Typeface.createFromAsset(student.this.getAssets(),
                "font/Lato-Light.ttf");

        TextView t4 =(TextView)findViewById(R.id.remember);
        t4.setTypeface(fonts1);

    }
}
