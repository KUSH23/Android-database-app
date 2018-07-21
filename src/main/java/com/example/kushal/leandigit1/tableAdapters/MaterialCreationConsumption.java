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

public class MaterialCreationConsumption extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    Data current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public MaterialCreationConsumption(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_material_creation_consumption, parent, false);
        MaterialCreationConsumption.MyHolder holder = new MaterialCreationConsumption.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MaterialCreationConsumption.MyHolder myHolder = (MaterialCreationConsumption.MyHolder) holder;
        Data current = data.get(position);
        myHolder.Mcp_no.setText(current.mcp_no);
        myHolder.Mcp_source.setText(current.mcp_source);
        myHolder.Material_id.setText("M.Id: "+current.material_id);
        myHolder.Plan_no.setText("Rq Qty: "+current.plan_no);
        myHolder.Po_no.setText("Po no.: "+current.po_no);
        myHolder.Qpmg.setText("In Qty: "+current.qpmg);
        myHolder.Quantity.setText("Bln Qty: "+current.quantity);
        myHolder.Change_type.setText("Bln Qty: "+current.change_type);
        myHolder.Propagated.setText("Bln Qty: "+current.propagated);
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView Mcp_no,Mcp_source,Plan_no,Po_no,Material_id,Qpmg,Quantity,Change_type,Propagated;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Mcp_no = (TextView) itemView.findViewById(R.id.textmcp_no1);
            Mcp_source = (TextView) itemView.findViewById(R.id.textmcp_source1);
            Plan_no = (TextView) itemView.findViewById(R.id.textplan_no1);
            Po_no = (TextView) itemView.findViewById(R.id.textpo_no2);
            Material_id = (TextView) itemView.findViewById(R.id.textmaterial_id2);
            Qpmg = (TextView) itemView.findViewById(R.id.textqpmg2);
            Quantity = (TextView) itemView.findViewById(R.id.textquantity2);
            Change_type = (TextView) itemView.findViewById(R.id.textchange_type2);
            Propagated = (TextView) itemView.findViewById(R.id.textpropagated2);

        }

    }

}
