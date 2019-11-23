package com.example.androidclient3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {


    private List<UserDto> users;

    public static class UserHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView userName,roleName;

        public UserHolder(View v) {
            super(v);
            userName = v.findViewById(R.id.UserName);
            roleName = v.findViewById(R.id.RoleName);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public UserAdapter(List<UserDto> users) {
        this.users = users;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UserAdapter.UserHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_users_page,parent,false);
        UserHolder  vh = new UserHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        UserDto current = users.get(position);
        holder.roleName.setText(current.getRole().getRole());
        holder.userName.setText(current.getLogin());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        try {
            return users.size();
        }catch (Exception e){e.printStackTrace();return 0;}

    }
}
