package com.android.userroomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.userroomdatabase.R;
import com.android.userroomdatabase.entities.UserEntity;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {
    //create a list of user entity
    List<UserEntity> userEntityList;
    public  UserRecyclerAdapter(List<UserEntity>userList){this.userEntityList = userList;}
    @NonNull
    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the row item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item,parent, false);
        return  new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.UserViewHolder holder, int position) {
        //on bind view holder helps to loop through all the element on list
        //UserEntity userEntity = userEntityList.get(position).getid());
        holder.user_id.setText(""+userEntityList.get(position).getId());
        holder.user_name.setText(userEntityList.get(position).getName());
        holder.user_email.setText(userEntityList.get(position).getEmail());

    }


    @Override
    public int getItemCount() {
        return  userEntityList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView user_id,user_name,user_email;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.id);
            user_name = itemView.findViewById(R.id.name);
            user_email = itemView.findViewById(R.id.email);
        }
    }
}
