package com.example.kushal.leandigit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addMaterial extends AppCompatActivity {

    EditText Materialid, MaterialName,UOM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_material);

        Materialid=(EditText)findViewById(R.id.etmid);
        MaterialName=(EditText)findViewById(R.id.etmname);
        UOM=(EditText)findViewById(R.id.etuom);
    }

    public void addMaterial(View view){
        String material_id = Materialid.getText().toString();
        String materail_name = MaterialName.getText().toString();
        String uom = UOM.getText().toString();
        String type= "addMaterial";

        Add add = new Add(this);
        add.execute(type, material_id, materail_name, uom);
    }
}
