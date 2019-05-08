package com.iranpl.monsef.mytest;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class show_form_activity extends AppCompatActivity {

    TextView firstName, lastName, emailAddr, ageparam;
    Button btnOk, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_form);

        TextView firstName,lastName, emailAddr, age;
        Intent intent = getIntent();
        final String fName = "YOUR FIRSTNAME: " + intent.getStringExtra("fname");
        final String lname = "YOUR LASTNAME: " + intent.getStringExtra("lname");
        final String num = "YOUR AGE: " + intent.getStringExtra("age");
        final String email = "YOUR EMAIL: " + intent.getStringExtra("email");
        firstName = findViewById(R.id.firName);
        firstName.setText(fName);
        lastName = findViewById(R.id.lastName);
        lastName.setText(lname);
        ageparam = findViewById(R.id.age);
        ageparam.setText(num);
        emailAddr = findViewById(R.id.email);
        emailAddr.setText(email);

        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(show_form_activity.this).edit().putString("firstname", fName).apply();
                PreferenceManager.getDefaultSharedPreferences(show_form_activity.this).edit().putString("lastname", lname).apply();
                PreferenceManager.getDefaultSharedPreferences(show_form_activity.this).edit().putString("age", num).apply();
                PreferenceManager.getDefaultSharedPreferences(show_form_activity.this).edit().putString("email", email).apply();
                Intent i = new Intent();
                setResult(Activity.RESULT_OK, i);
                finish();

                Toast.makeText(show_form_activity.this, "ثبت اطلاعات با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                setResult(Activity.RESULT_CANCELED, i);
                finish();

                Toast.makeText(show_form_activity.this, "ثبت اطلاعات لغو شد!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
