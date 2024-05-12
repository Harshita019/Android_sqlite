package com.example.wproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userHolder> {

    ViewData mainActivity;
    List<Modal> allUserList;


    public UserAdapter(ViewData mainActivity, List<Modal> allUserList) {
        this.mainActivity = mainActivity;
        this.allUserList = allUserList;

    }


    @NonNull
    @Override
    public UserAdapter.userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.userHolder holder, int position)
    {
        Modal modal = allUserList.get(position);
        Log.d("MYTAG", "onBindViewHolder: "+modal.Name);
        holder.id.setText(modal.Id);
        holder.name.setText(modal.Name);
        holder.address.setText(modal.Address);
        holder.mobile.setText(modal.Mobile);
        Log.d("MSG", "onBindViewHolder: "+modal.Name);
    }

    @Override
    public int getItemCount() {
        return allUserList.size();
    }

    class userHolder extends RecyclerView.ViewHolder {

        TextView id, name, address, mobile;

        public userHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.r_id);
            name = (TextView) itemView.findViewById(R.id.r_name);
            address = (TextView) itemView.findViewById(R.id.r_address);
            mobile = (TextView) itemView.findViewById(R.id.r_mobile);

        }
    }
}
