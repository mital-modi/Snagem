package com.mital.snagem;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    Button btnLogin;
    Button btnRegister;
    Button btnReset;
    DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText inputEmail = (EditText) findViewById(R.id.input_email);
        final EditText inputPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.login);
        btnReset = (Button) findViewById(R.id.reset_password);
        btnRegister = (Button) findViewById(R.id.register);

        // create a instance of SQLite Database
        db=new DataBaseHelper(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create Intent for register activity and Start The Activity
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create Intent for register activity and Start The Activity
                Intent intent=new Intent(getApplicationContext(),ResetPassword.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String storedPassword = db.searchPass(email);

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this, " Username or Password field empty", Toast.LENGTH_LONG).show();
                }

                else if(password.equals(storedPassword)){
                    Intent intent=new Intent(getApplicationContext(),Userhome.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Close The Database
        db.close();
    }

}


