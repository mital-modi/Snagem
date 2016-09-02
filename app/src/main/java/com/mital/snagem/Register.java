package com.mital.snagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity {

    EditText input_name;
    EditText input_email;
    EditText input_password;
    RadioGroup input_gender;
    RadioButton input_sex;
    Spinner input_school;
    Spinner input_class;
    Button btnRegister;
    DataBaseHelper db = new DataBaseHelper(this);

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /**
         * Defining all layout items
         **/
        input_name = (EditText) findViewById(R.id.input_name);
        input_gender = (RadioGroup) findViewById(R.id.input_gender);
        input_school = (Spinner) findViewById(R.id.input_school);
        input_class = (Spinner) findViewById(R.id.input_class);
        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        btnRegister = (Button) findViewById(R.id.register);
        int id_checked = input_gender.getCheckedRadioButtonId();
        input_sex = (RadioButton) findViewById(id_checked);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String sex="";
                String name = input_name.getText().toString();
                String email = input_email.getText().toString();
                String password = input_password.getText().toString();
                String school = input_school.getSelectedItem().toString();
                String classification = input_class.getSelectedItem().toString();
                if(input_sex!=null){
                   sex = input_sex.getText().toString();
                }


                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || school.isEmpty() || classification.isEmpty() || sex.isEmpty()) {
                    Toast.makeText(Register.this, "One of the field is empty", Toast.LENGTH_LONG).show();
                } else {
                    User user = new User();
                    user.setName(name);
                    user.setGender(sex);
                    user.setSchool(school);
                    user.setClassification(classification);
                    user.setEmail(email);
                    user.setPassword(password);
                    db.insertUser(user);
                    Intent myIntent = new Intent(view.getContext(), Terms.class);
                    startActivity(myIntent);
                }


            }
        });

    }
}