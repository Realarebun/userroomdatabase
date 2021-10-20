package com.android.userroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.android.userroomdatabase.database.UserDatabase;

public class MainActivity extends AppCompatActivity {
    //get a reference to the Fragment manager
public static FragmentManager fragmentManager;
//create a static reference to the data base class created
    public  static UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create an object of the data base in the memmory using Room.databaseBuilder(getApplicationContext(),UserDatabase.class,
        // ).allowMainThreadQueries().build();
        fragmentManager = getSupportFragmentManager();
        userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"userdb").allowMainThreadQueries().build();
        // if we have an app runing in memory then do not execute do anything.
        if ((savedInstanceState != null)){
            return;
        }
        //set the default view for the main activity to the home fragment

        fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
    }
}