package com.example.csis_330smartlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText password;
    EditText email;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SignUp s = new SignUp(MainActivity.this);
//        s.runSignUp();
//        firstName = findViewById(R.id.firstName);
//        lastName = findViewById(R.id.lastName);
//        email = findViewById(R.id.email);
//        btnSignUp = findViewById(R.id.btnSignUp);
//        password = findViewById(R.id.password);

//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SignUp s = new SignUp(MainActivity.this);
////                s.checkDataEntered(firstName, lastName, email);
//                s.runSignUp();
//            }
//        });
    }
}