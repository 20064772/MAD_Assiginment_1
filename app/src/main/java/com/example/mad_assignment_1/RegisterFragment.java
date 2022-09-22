package com.example.mad_assignment_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private CheckoutViewModel viewModel;
    private Basket basket;
    public RegisterFragment() {
        // Required empty public constructor
    }


    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.NewInstanceFactory()).get(CheckoutViewModel.class);
        viewModel.getBasket();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        EditText email = (EditText) v.findViewById(R.id.email);
        EditText password = (EditText) v.findViewById(R.id.password);
        Button register = (Button) v.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String userEmail = email.getText().toString();
               // String userPass = password.getText().toString();
                Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                startActivity(intent);
                /**
                need to get access to and Query the DB to check user email exists already.
                If it doesnt the user needs to be added to the database and the basket needs to be added to the orderHistory table
                if (userEmail.isEmpty() || userPass.isEmpty()){
                    email.setText(null);
                    password.setText(null);
                    Toast.makeText(getActivity(),"Please enter into both fields",Toast.LENGTH_SHORT).show();
                }
                else if (? db with email != null){
                    email.setText(null);
                    password.setText(null);
                    Toast.makeText(getActivity(),"The email is already attached to an account",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getActivity(), OrderHistoryActivity.class);
                    startActivity(intent);
                }
                 */
            }
        });
        return v;
    }
}