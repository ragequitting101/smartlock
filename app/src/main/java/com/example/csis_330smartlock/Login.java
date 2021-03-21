package com.example.csis_330smartlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    MaterialButton btnLogin;
    TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        txtSignUp = findViewById(R.id.txtSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkDataEntered())
                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

//                if (checkDataEntered()) {
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Starting Write and Read data with URL
//                            //Creating array for parameters
//                            String[] field = new String[2];
//                            field[0] = "Email";
//                            field[1] = "Password";
//                            //Creating array for data
//                            String[] data = new String[2];
//                            data[0] = email.getText().toString();
//                            data[1] = password.getText().toString();
//                            PutData putData = new PutData("http://192.168.8.163/login/login.php", "POST", field, data);
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    //progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//                                    if (result.equals("Login Success")) {
//                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
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