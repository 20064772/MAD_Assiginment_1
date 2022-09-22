package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        FragmentManager fm = getSupportFragmentManager();
        LoginFragment loginFragment = (LoginFragment) fm.findFragmentById(R.id.frgmentlogin);

        if (loginFragment == null){
            loginFragment = new LoginFragment();
            fm.beginTransaction().add(R.id.checkoutfrag,loginFragment).commit();
        }

    }
}
