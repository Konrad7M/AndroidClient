package com.example.androidclient3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//<RoleAdapter.MyViewHolder>

public class RoleAdapter extends RecyclerView.Adapter<RoleAdapter.MyViewHolder>  {


    private List<RoleDto> roles;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.roleName);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RoleAdapter(List<RoleDto> roles) {
        this.roles = roles;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RoleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_role_page,parent,false);
        MyViewHolder  vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RoleDto current = roles.get(position);
        holder.textView.setText(current.getRole());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return roles.size();


    }
}