package com.example.mad_assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.io.Serializable;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Basket basket = (Basket) getIntent().getSerializableExtra("basket");
        setContentView(R.layout.activity_check_out);
        FragmentManager fm = getSupportFragmentManager();
        LoginFragment loginFragment = (LoginFragment) fm.findFragmentById(R.id.frgmentlogin);

        if (loginFragment == null){
            Bundle b = new Bundle();
            b.putSerializable("basket", (Serializable) basket);
            loginFragment = new LoginFragment();
            loginFragment.setArguments(b);
            fm.beginTransaction().add(R.id.checkoutfrag,loginFragment).commit();
        }

    }
}
