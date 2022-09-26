/**
 * Login Fragment. A fragment where a user can input login and password or change fragment to the register fragment.
 *
 * @class           Login fragment
 * @extends         Fragment
 * @author          Ryan Mckenney
 * @date_created    20/09/2022
 */

package com.example.mad_assignment_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {


    private CheckoutViewModel viewModel;
    private Basket basket;
    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basket = (Basket)getArguments().getSerializable("basket");

        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(CheckoutViewModel.class); // calls and constructs the view model so data my be stored
        viewModel.setBasket(basket);// enter the basket to the view model so it can be access by the register fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { //binds the elements so the user may enter details
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        EditText email = (EditText) v.findViewById(R.id.email);
        EditText password = (EditText) v.findViewById(R.id.password);
        Button login = (Button) v.findViewById(R.id.login);
        Button register = (Button) v.findViewById(R.id.register);

        DBModel db = new DBModel(getContext());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // query the Db to check login details. If correct add basket details to DB, else, error and notify user.
                String userEmail = email.getText().toString();
                String userPass = password.getText().toString();

                if(db.findUser(userEmail, userPass))
                {
                    db.addToOrderHistory(basket, userEmail);
                    db.close();
                    Intent intent = new Intent(getActivity(), OrderHistoryActivity.class).putExtra("Email", userEmail);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getActivity(), "Incorrect UserName or Password", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
               }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {// button that switches the fragment the the register fragment.
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                RegisterFragment registerFragment = new RegisterFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.checkoutfrag, registerFragment).addToBackStack(null).commit();
            }
        });


        return v;

    }
}