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

public class InflowRequirements extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public InflowRequirements(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_inflow_requirements, parent, false);
        InflowRequirements.MyHolder holder = new InflowRequirements.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        InflowRequirements.MyHolder myHolder = (InflowRequirements.MyHolder) holder;
        Data current = data.get(position);
        myHolder.Inflow_plan_no.setText(current.inflow_plan_no);
        myHolder.Table_discreption.setText(current.table_discreption.toUpperCase());
        myHolder.Material_id.setText("M.Id: "+current.material_id);
        myHolder.Required_quantity.setText("Rq Qty: "+current.required_quantity);
        myHolder.Po_no.setText("Po no.: "+current.po_no);
        myHolder.Inwarded_quantity.setText("In Qty: "+current.inwarded_quantity);
        myHolder.Balanced_quantity.setText("Bln Qty: "+current.balanced_quantity);
        myHolder.Inflow_condition.setText("Inflow condition : "+current.inflow_condition);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView Inflow_plan_no,Table_discreption,Material_id,Required_quantity,Po_no,Inwarded_quantity,Balanced_quantity,Inflow_condition;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Inflow_plan_no = (TextView) itemView.findViewById(R.id.textinflow_plan_no1);
            Table_discreption = (TextView) itemView.findViewById(R.id.texttb1);
            Material_id = (TextView) itemView.findViewById(R.id.textMid1);
            Required_quantity = (TextView) itemView.findViewById(R.id.textrq1);
            Po_no = (TextView) itemView.findViewById(R.id.textpono1);
            Inwarded_quantity = (TextView) itemView.findViewById(R.id.textinqn1);
            Balanced_quantity = (TextView) itemView.findViewById(R.id.textbqn1);
            Inflow_condition = (TextView) itemView.findViewById(R.id.textincondn);

        }

    }

}
