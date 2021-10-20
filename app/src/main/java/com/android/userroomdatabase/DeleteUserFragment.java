package com.android.userroomdatabase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.userroomdatabase.entities.UserEntity;


public class DeleteUserFragment extends Fragment {
    Button button;
    EditText deleteId;



    public DeleteUserFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_fragment_delete_user, container, false);
        button = view.findViewById(R.id.delete_btn);
        deleteId =view.findViewById(R.id.delete_id);

        //create the button click event listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_id =deleteId.getText().toString();
                //check if the user typed anything on the text field
                if (!TextUtils.isEmpty(string_id)){
                    int id = Integer.parseInt(string_id);
                   int findId = MainActivity.userDatabase.userDao().getUserId(id);
                   if (findId>0){

                    //create an object of user entity and set the id to the one enterd in the field
                    UserEntity user =new UserEntity();
                    user.setId(id);
                    // delete the user using the data base object from the main activity class
                    MainActivity.userDatabase.userDao().deleteUser(user);
                    Toast.makeText(getContext(),"User deleted succesfully",Toast.LENGTH_LONG).show();
                    deleteId.setText("");

                }else {
                       Toast.makeText(getContext(),"User Not Found",Toast.LENGTH_LONG).show();
                   }

                } else {
                    Toast.makeText(getContext(),"Empty ID not allowed",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}