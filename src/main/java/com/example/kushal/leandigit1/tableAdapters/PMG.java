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

public class PMG extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public PMG(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_pmg, parent, false);
        PMG.MyHolder holder = new PMG.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        PMG.MyHolder myHolder = (PMG.MyHolder) holder;
        Data current = data.get(position);
        myHolder.pmg_id.setText(current.pmg_id);
        myHolder.pmg_description.setText("Description: "+current.pmg_description);
        myHolder.process_id.setText("Process ID: "+current.process_id);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView pmg_id,pmg_description,process_id;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            pmg_id = (TextView) itemView.findViewById(R.id.textpmg_id0);
            pmg_description = (TextView) itemView.findViewById(R.id.textpmg_description0);
            process_id = (TextView) itemView.findViewById(R.id.textprocess_id0);

        }

    }

}
