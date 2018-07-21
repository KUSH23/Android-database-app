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

public class CustomerOrder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public CustomerOrder(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_customer_order, parent, false);
        CustomerOrder.MyHolder holder = new CustomerOrder.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        CustomerOrder.MyHolder myHolder = (CustomerOrder.MyHolder) holder;
        Data current = data.get(position);
        myHolder.order_id.setText(current.order_id);
        myHolder.customer_id.setText("C.Id: "+current.customer_id);
        myHolder.order_date.setText("Order_dd: "+current.order_date);
        myHolder.expected_dd.setText("Expected_dd: "+current.expected_dd);
        myHolder.commited_dd.setText("Commited_dd: "+current.commited_dd);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView order_id,customer_id,order_date,expected_dd,commited_dd;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            order_id = (TextView) itemView.findViewById(R.id.textorder_id);
            customer_id = (TextView) itemView.findViewById(R.id.textcustomer_id);
            order_date = (TextView) itemView.findViewById(R.id.textorder_date);
            expected_dd = (TextView) itemView.findViewById(R.id.textexpected_dd);
            commited_dd = (TextView) itemView.findViewById(R.id.textcommited_dd);

        }

    }

}
