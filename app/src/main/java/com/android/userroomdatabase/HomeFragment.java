package com.android.userroomdatabase;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {

Button add_user,view_user,edit_user,delete_user;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //get the reference to the add_buttons
        add_user = view.findViewById(R.id.add_button);
        view_user = view.findViewById(R.id.view_button);
        edit_user = view.findViewById(R.id.edit_button);
        delete_user = view.findViewById(R.id.delete_button);

        // register each button t
        add_user.setOnClickListener(this);
        view_user.setOnClickListener(this);
        edit_user.setOnClickListener(this);
        delete_user.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View view) {
        // check which button was clicked by getting the id
        switch (view.getId()){
            // if button clicked is the add button
            case R.id.add_button:
                //start the fragment manager that is in the vmain activity in order to replace the fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.view_button:
                //start the fragment manager that is in the vmain activity in order to replace the fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new ReadUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.edit_button:
                //start the fragment manager that is in the vmain activity in order to replace the fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new UpdateUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.delete_button:
                //start the fragment manager that is in the vmain activity in order to replace the fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,
                        new DeleteUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}