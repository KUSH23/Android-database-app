package com.example.kushal.leandigit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addCustomer extends AppCompatActivity {

    EditText Customer_id,Name,Address,Email,Phone_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        Customer_id=(EditText)findViewById(R.id.etcid);
        Name=(EditText)findViewById(R.id.etname);
        Address=(EditText)findViewById(R.id.etadr);
        Email=(EditText)findViewById(R.id.eteml);
        Phone_no=(EditText)findViewById(R.id.etphn);
    }

    public void addcustomer(View view){
        String customer_id=Customer_id.getText().toString();
        String name=Name.getText().toString();
        String address=Address.getText().toString();
        String email=Email.getText().toString();
        String phone_no=Phone_no.getText().toString();
        String type= "addCustomer";

        Add add = new Add(this);
        add.execute(type, customer_id, name, address, email, phone_no);
    }
}
