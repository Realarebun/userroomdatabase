package com.android.userroomdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.userroomdatabase.entities.UserEntity;


public class UpdateUserFragment extends Fragment {
    //create reference to all the views in this fragment
    Button button;
    EditText userid, username, useremail;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        // get id for all the view in the layout
        button = view.findViewById(R.id.update_btn);
        userid = view.findViewById(R.id.user_updateid);
        username = view.findViewById(R.id.user_updateName);
        useremail = view.findViewById(R.id.user_updateEmail);
        //create an oncreate event listener on the buttomn object
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // collect data from the edit text field  //check if the user typed anything on the text field
                int id = Integer.parseInt(userid.getText().toString());
                String userName = username.getText().toString();
                String email = useremail.getText().toString();
                //create an object of the user entrity class
                UserEntity user = new UserEntity(id,userName,email);
                //insert the user object into the Room

                MainActivity.userDatabase.userDao().UpdateUser(user);
                //creatr a toaste that inform us  that user has been updated
                Toast.makeText(getContext(), "user updated sucessfully",Toast.LENGTH_LONG).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");

            }
        });
        return  view;
    }
    }

