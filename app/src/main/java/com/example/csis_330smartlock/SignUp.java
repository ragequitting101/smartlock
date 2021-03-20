package com.example.csis_330smartlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText password;
    EditText email;
    MaterialButton btnSignUp;
    TextView txtLogin;
    //ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtLogin = findViewById(R.id.txtLogin);
        //progressBar = findViewById(R.id.progress);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkDataEntered();

//                if (checkDataEntered()) {
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Starting Write and Read data with URL
//                            //Creating array for parameters
//                            String[] field = new String[4];
//                            field[0] = "FirstName";
//                            field[1] = "LastName";
//                            field[2] = "Email";
//                            field[3] = "Password";
//                            //Creating array for data
//                            String[] data = new String[4];
//                            data[0] = firstName.getText().toString();
//                            data[1] = lastName.getText().toString();
//                            data[2] = email.getText().toString();
//                            data[3] = password.getText().toString();
//                            PutData putData = new PutData("http://192.168.8.163/login/signup.php", "POST", field, data);
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    //progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//                                    if (result.equals("Sign Up Success")) {
//                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                                        startActivity(intent);
//                                        finish();
//                                    } else {
//                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                                    }
//                                    Log.i("PutData", result);
//                                }
//                            }
//                        }
//                    });
//                } else {
//
//                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean checkDataEntered() {
        //progressBar.setVisibility(View.VISIBLE);
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
            firstName.setError("First name is required!");
            return false;
        }

        if (isEmpty(lastName)) {
            Toast.makeText(this, "Enter a last name to register", Toast.LENGTH_SHORT).show();
            lastName.setError("Last name is required!");
            return false;
        }

        if (!isEmail(email)) {
            Toast.makeText(this, "Enter an e-mail address to register", Toast.LENGTH_SHORT).show();
            email.setError("Enter valid email!");
            return false;
        }

        if (isEmpty(password))
        {
            Toast.makeText(this, "Enter a password to register", Toast.LENGTH_SHORT).show();
            password.setError("Enter a password!");
            return false;
        }
        return true;
    }
}