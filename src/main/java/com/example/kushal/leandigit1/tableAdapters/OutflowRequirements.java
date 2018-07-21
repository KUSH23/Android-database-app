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

public class OutflowRequirements extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public OutflowRequirements(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_outflow_requirements, parent, false);
        OutflowRequirements.MyHolder holder = new OutflowRequirements.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        OutflowRequirements.MyHolder myHolder = (OutflowRequirements.MyHolder) holder;
        Data current = data.get(position);
        myHolder.outflow_plan_no.setText(current.item_id);
        myHolder.table_discreption.setText("Description: "+current.table_discreption);
        myHolder.material_id.setText("Material ID: "+current.material_id);
        myHolder.required_quantity.setText("Required: "+current.required_quantity);
        myHolder.po_no.setText("Po_no: "+current.po_no);
        myHolder.delivered_quantity.setText("Delivered: "+current.delivered_quantity);
        myHolder.balanced_quantity.setText("Balance Qty: "+current.balanced_quantity);
        myHolder.outflow_condition.setText("Condition: "+current.outflow_condition);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView outflow_plan_no,table_discreption,material_id,required_quantity,po_no,delivered_quantity,balanced_quantity,outflow_condition;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            outflow_plan_no = (TextView) itemView.findViewById(R.id.textoutflow_plan_no8);
            table_discreption = (TextView) itemView.findViewById(R.id.texttable_discreption8);
            material_id = (TextView) itemView.findViewById(R.id.textmaterial_id8);
            required_quantity = (TextView) itemView.findViewById(R.id.textrequired_quantity8);
            po_no = (TextView) itemView.findViewById(R.id.textpo_no8);
            delivered_quantity = (TextView) itemView.findViewById(R.id.textdelivered_quantity8);
            balanced_quantity = (TextView) itemView.findViewById(R.id.textbalanced_quantity8);
            outflow_condition = (TextView) itemView.findViewById(R.id.textoutflow_condition8);

        }

    }

}
