package com.example.kushal.leandigit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addProcess extends AppCompatActivity {

    EditText Process_id, Process_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_process);

        Process_id = (EditText) findViewById(R.id.etProcessId);
        Process_description = (EditText) findViewById(R.id.etProcessdescription);

    }

    public void addprocess(View view) {
        String process_id = Process_id.getText().toString();
        String process_description = Process_description.getText().toString();
        String type = "addProcess";

        Add add = new Add(this);
        add.execute(type, process_id, process_description);

    }

}


