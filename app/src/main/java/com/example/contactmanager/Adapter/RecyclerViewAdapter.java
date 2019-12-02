package com.example.contactmanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanager.DetailsActivity;
import com.example.contactmanager.R;
import com.example.contactmanager.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_row,viewGroup,false);

        return new ViewHolder(view);  //(ViewHolder)view;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {//position will be the index of the object in the list we are looping through

        //get one particular object (at position i) in the list and set it up
        //i will serve as the index of the object we're looping through

        Contact contact = contactList.get(i); //each contact object inside of our list

        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() { //returns count of data

        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView contactName;
        public TextView phoneNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
        }

        @Override
        public void onClick(View view)
        {

            int i = getAdapterPosition();
            Contact contact = contactList.get(i);

            Intent intent = new Intent(context, DetailsActivity.class);

            intent.putExtra("name",contact.getName());
            intent.putExtra("phone",contact.getPhoneNumber());

            context.startActivity(intent);
            //Log.d("checker", "onClick: "+i);
        }
    }

}
