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

public class PmgExecution extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public PmgExecution(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_pmg_execution, parent, false);
        PmgExecution.MyHolder holder = new PmgExecution.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        PmgExecution.MyHolder myHolder = (PmgExecution.MyHolder) holder;
        Data current = data.get(position);
        myHolder.execution_plan_no.setText(current.execution_plan_no);
        myHolder.req_no.setText("Req No.: "+current.req_no);
        myHolder.execution_discreption.setText("Description: "+current.execution_discreption);
        myHolder.pmg_id.setText("PMG ID: "+current.pmg_id);
        myHolder.po_no.setText("Po_no: "+current.po_no);
        myHolder.units.setText("Units: "+current.units);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView execution_plan_no,req_no,execution_discreption,pmg_id,po_no,units;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            execution_plan_no = (TextView) itemView.findViewById(R.id.textexecution_plan_no9);
            req_no = (TextView) itemView.findViewById(R.id.textreq_no9);
            execution_discreption = (TextView) itemView.findViewById(R.id.textexecution_discreption9);
            pmg_id = (TextView) itemView.findViewById(R.id.textpmg_id9);
            po_no = (TextView) itemView.findViewById(R.id.textpo_no9);
            units = (TextView) itemView.findViewById(R.id.textunits9);

        }

    }

}
