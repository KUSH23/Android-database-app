package com.example.kushal.leandigit1.tableAdapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kushal.leandigit1.Data;
import com.example.kushal.leandigit1.R;

import java.util.Collections;
import java.util.List;

public class Customers extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public Customers(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_customers, parent, false);
        Customers.MyHolder holder = new Customers.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        Customers.MyHolder myHolder = (Customers.MyHolder) holder;
        Data current = data.get(position);
        myHolder.Customer_id.setText("ID: "+current.customer_id);
        myHolder.Name.setText(current.name);
        myHolder.Address.setText("Address: "+current.address);
        myHolder.Email.setText("Email: "+current.email);
        myHolder.Phone_no.setText("Phone No: "+current.phone_no);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView Customer_id, Name,Address, Email, Phone_no;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Customer_id = (TextView) itemView.findViewById(R.id.textCustomer_id);
            Name = (TextView) itemView.findViewById(R.id.textName);
            Address = (TextView) itemView.findViewById(R.id.textAddress);
            Email = (TextView) itemView.findViewById(R.id.textEmail);
            Phone_no = (TextView) itemView.findViewById(R.id.textPhone);

        }

    }
}