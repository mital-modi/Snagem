package com.mital.snagem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.app.Activity;
import android.widget.Toast;


public class Terms extends Activity {

    CheckBox terms;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        terms = (CheckBox) findViewById(R.id.terms);
        submit = (Button) findViewById(R.id.to_register);


        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(terms.isChecked()==true){
                    Intent myIntent = new Intent(view.getContext(), Profile.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(Terms.this, "Please agree to the terms", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}
