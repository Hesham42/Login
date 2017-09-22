package com.example.heshammostafa.login;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.heshammostafa.login.R.id.teacher;

public class techear extends AppCompatActivity {
    Typeface fonts1;
    CheckBox remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techear);
        remember = (CheckBox)findViewById(R.id.remember);

        fonts1 = Typeface.createFromAsset(techear.this.getAssets(),"font/Lato-Light.ttf");

        TextView t4 =(TextView)findViewById(R.id.remember);
        t4.setTypeface(fonts1);
    }
}
