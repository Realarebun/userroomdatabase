package com.android.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.userroomdatabase.entities.UserEntity;


public class AddUserFragment extends Fragment {
    //create reference to all the views in this fragment
    Button button;
    EditText user_id, user_name, user_email;



    public AddUserFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        // get id for all the view in the layout
        button = view.findViewById(R.id.update_btn);
        user_id = view.findViewById(R.id.user_updateid);
        user_name = view.findViewById(R.id.user_updateName);
        user_email = view.findViewById(R.id.user_updateEmail);
        //create an oncreate event listener on the buttomn object
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // collect data from the edit text field
                int id = Integer.parseInt(user_id.getText().toString());
                String userName = user_name.getText().toString();
                String email = user_email.getText().toString();
                //create an object of the user entrity class
                UserEntity user = new UserEntity(id,userName,email);
                //insert the user object into the Room

                MainActivity.userDatabase.userDao().addUser(user);
                //creatr a toaste that inform us  that user has been inserted
                // then clear all the fields
                Toast.makeText(getContext(), "user added sucessfully",Toast.LENGTH_LONG).show();
                user_id.setText("");
                user_name.setText("");
                user_email.setText("");

            }
        });
        return  view;
    }
}