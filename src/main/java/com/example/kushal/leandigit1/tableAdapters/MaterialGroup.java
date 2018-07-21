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

public class MaterialGroup extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public MaterialGroup(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_material_group, parent, false);
        MaterialGroup.MyHolder holder = new MaterialGroup.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MaterialGroup.MyHolder myHolder = (MaterialGroup.MyHolder) holder;
        Data current = data.get(position);
        myHolder.material_id.setText(current.material_id);
        myHolder.pmg_id.setText("PMG ID: "+current.pmg_id);
        myHolder.process_rel.setText("Relation: "+current.process_rel);
        myHolder.qpmg.setText("QPMG: "+current.qpmg);

        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView material_id,pmg_id,process_rel,qpmg;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            material_id = (TextView) itemView.findViewById(R.id.textMid4);
            pmg_id = (TextView) itemView.findViewById(R.id.textpmg_id4);
            process_rel = (TextView) itemView.findViewById(R.id.textprocess_rel4);
            qpmg = (TextView) itemView.findViewById(R.id.textqpmg4);

        }

    }

}
