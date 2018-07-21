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

public class MaterialFlowBalance extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public MaterialFlowBalance(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_material_flow_balance, parent, false);
        MaterialFlowBalance.MyHolder holder = new MaterialFlowBalance.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MaterialFlowBalance.MyHolder myHolder = (MaterialFlowBalance.MyHolder) holder;
        Data current = data.get(position);
        myHolder.Material_id.setText(current.material_id);
        myHolder.Creation_pending.setText("Creation Pending: "+current.creation_pending);
        myHolder.Current_inventory.setText("Inventory: "+current.current_inventory);
        myHolder.Consumption_pending.setText("Consumption pending: "+current.consumption_pending);
        myHolder.Creation_required.setText("Required: "+current.creation_required);

        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView Material_id,Creation_pending,Current_inventory,Consumption_pending,Creation_required;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Material_id = (TextView) itemView.findViewById(R.id.textMid3);
            Creation_pending = (TextView) itemView.findViewById(R.id.textCrPn3);
            Current_inventory = (TextView) itemView.findViewById(R.id.textCrnInv3);
            Consumption_pending = (TextView) itemView.findViewById(R.id.textCsmPn3);
            Creation_required = (TextView) itemView.findViewById(R.id.textCrRq3);

        }

    }

}
