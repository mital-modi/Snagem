package com.mital.snagem;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class Home extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void activityLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void activityHowToPlay(View view){
        Intent intent = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }

    public void activityPreregister(View view){
        Intent intent = new Intent(this, Preregister.class);
        startActivity(intent);
    }

}