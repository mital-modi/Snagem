package com.mital.snagem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Home extends Activity {
    Button login, register, htp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get The Reference Of Buttons
        login=(Button) findViewById(R.id.btn_login);
        register=(Button) findViewById(R.id.btn_rgstr);
        htp=(Button) findViewById(R.id.btn_htp);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Create Intent for register activity and Start The Activity
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

        htp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Create Intent for register activity and Start The Activity
                Intent intent=new Intent(getApplicationContext(),Userhome.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Create Intent for register activity and Start The Activity
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }

}