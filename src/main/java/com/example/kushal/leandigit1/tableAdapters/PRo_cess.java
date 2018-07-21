package com.example.kushal.leandigit1.tableAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.kushal.leandigit1.Data;
import com.example.kushal.leandigit1.FeedActivity;
import com.example.kushal.leandigit1.ItemClickListener;
import com.example.kushal.leandigit1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by Kushal on 03-06-2018.
 */

public class PRo_cess extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable{

    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();
    List<Data> datafiltered;
    private RecyclerView.RecyclerListener listener;
    Data current;
    int currentPos = 0;
    ItemClickListener itemClickListener;
    CustomFilter filter;

    // create constructor to innitilize context and data sent from MainActivity
    public PRo_cess(Context context, List<Data> data) {
        this.context = context;
        this.listener=listener;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.datafiltered=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_process, parent, false);
        final PRo_cess.MyHolder holder = new PRo_cess.MyHolder(view);


        return holder;

    }

    // Bind data
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder myHolder = (MyHolder) holder;
        final Data current = data.get(position);
        myHolder.Process_id.setText(current.getProcess_id());
        myHolder.Process_description.setText(current.getProcess_description());
        //myHolder.textType.setText("Category: ");
        // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,data.get(pos).getProcess_id(),Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Process_id;
        TextView Process_description;
        ItemClickListener itemClickListener;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Process_id = (TextView) itemView.findViewById(R.id.textProcess_id);
            Process_description = (TextView) itemView.findViewById(R.id.textProcess_description);

        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener=ic;
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view,getLayoutPosition());
        }
    }



    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter( datafiltered,this);
        }

        return filter;
    }


    class CustomFilter extends Filter{

        PRo_cess adapter;
        List<Data> filterList;


        public CustomFilter(List<Data> filterList,PRo_cess adapter)
        {
            this.adapter=adapter;
            this.filterList=filterList;

        }

        //FILTERING OCURS
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();

            //CHECK CONSTRAINT VALIDITY
            if(constraint != null && constraint.length() > 0)
            {
                //CHANGE TO UPPER
                constraint=constraint.toString().toUpperCase();
                //STORE OUR FILTERED PLAYERS
                List<Data> filteredPlayers=Collections.EMPTY_LIST;

                for (int i=0;i<filterList.size();i++)
                {
                    //CHECK
                    if(filterList.get(i).getProcess_id().toUpperCase().contains(constraint))
                    {
                        //ADD PLAYER TO FILTERED PLAYERS
                        filteredPlayers.add(filterList.get(i));
                    }
                }

                results.count=filteredPlayers.size();
                results.values=filteredPlayers;
            }else
            {
                results.count=filterList.size();
                results.values=filterList;

            }


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            adapter.data= (List<Data>)results.values;

            //REFRESH
            adapter.notifyDataSetChanged();
        }
    }


}







