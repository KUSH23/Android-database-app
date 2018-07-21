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

public class Orders extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public Orders(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_orders, parent, false);
        Orders.MyHolder holder = new Orders.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        Orders.MyHolder myHolder = (Orders.MyHolder) holder;
        Data current = data.get(position);
        myHolder.item_id.setText(current.item_id);
        myHolder.quantity.setText("Quantity: "+current.quantity);
        myHolder.uom.setText("UOM: "+current.uom);
        myHolder.remark.setText("Remarks: "+current.remark);

        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView item_id,quantity,uom,remark;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            item_id = (TextView) itemView.findViewById(R.id.textitem_id7);
            quantity = (TextView) itemView.findViewById(R.id.textquantity7);
            uom = (TextView) itemView.findViewById(R.id.textuom7);
            remark = (TextView) itemView.findViewById(R.id.textremark7);

        }

    }

}
