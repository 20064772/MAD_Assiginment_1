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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(CheckoutViewModel.class);
        viewModel.setBasket(basket);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        EditText email = (EditText) v.findViewById(R.id.email);
        EditText password = (EditText) v.findViewById(R.id.password);
        Button login = (Button) v.findViewById(R.id.login);
        Button register = (Button) v.findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String userEmail = email.getText().toString();
               //String userPass = password.getText().toString();
                Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK); //Kills previous activity after login. dont know how it will effect the DB.
                startActivity(intent);


               // getActivity().finish();
               /**
               if(? DB with userEmail and password == true){
                    Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                    startActivity(intent);
                }
                else (? db with userEmail != null || ? db with userPass != null){
                    Toast.makeText(getActivity(),"Incorrect UserName or Password",Toast.LENGTH_SHORT).show();
                    email.setText(null);
                    password.setText(null);//this
                }
                **/
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
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