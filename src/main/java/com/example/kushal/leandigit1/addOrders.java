package com.example.kushal.leandigit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addOrders extends AppCompatActivity {

    EditText ItemId, Qty, Uom, Remarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orders);

        ItemId = (EditText)findViewById(R.id.etitem);
        Qty = (EditText)findViewById(R.id.etqty);
        Uom = (EditText)findViewById(R.id.etuom2);
        Remarks = (EditText)findViewById(R.id.etremark);
    }

    public void addorders(View view){
        String item_id =ItemId.getText().toString();
        String quantity=Qty.getText().toString();
        String uom=Uom.getText().toString();
        String remarks=Remarks.getText().toString();
        String type= "addOrders";

        Add add = new Add(this);
        add.execute(type, item_id, quantity, uom, remarks);
    }
}
