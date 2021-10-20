package com.android.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.userroomdatabase.adapter.UserRecyclerAdapter;
import com.android.userroomdatabase.entities.UserEntity;

import java.util.List;

public class ReadUserFragment extends Fragment {
    RecyclerView recyclerView;
    UserRecyclerAdapter userRecyclerAdapter;
    List<UserEntity> userEntityList;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_user, container, false);
        //
        //populate the userEntityList to the user recycler adapter as an argument  for it construtor
        userEntityList = MainActivity.userDatabase.userDao().getUsers();
        //
        //
        userRecyclerAdapter = new UserRecyclerAdapter(userEntityList);
        //inflate the layout for this fragment
         //View view = inflater.inflate(R.layout.fragment_read_user,container,false);
        //cyclerView = view.findViewById(R.id.recyclerview);
        // get the ids for the recycler view
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        //set up divider for the recycler view
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(userRecyclerAdapter);
        return  view;

    }
}