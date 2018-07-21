package com.example.kushal.leandigit1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.kushal.leandigit1.tableAdapters.CustomerOrder;
import com.example.kushal.leandigit1.tableAdapters.Customers;
import com.example.kushal.leandigit1.tableAdapters.InflowRequirements;
import com.example.kushal.leandigit1.tableAdapters.MaterialCreationConsumption;
import com.example.kushal.leandigit1.tableAdapters.MaterialFlowBalance;
import com.example.kushal.leandigit1.tableAdapters.MaterialGroup;
import com.example.kushal.leandigit1.tableAdapters.Materials;
import com.example.kushal.leandigit1.tableAdapters.OrderPropagation;
import com.example.kushal.leandigit1.tableAdapters.OrderRecord;
import com.example.kushal.leandigit1.tableAdapters.Orders;
import com.example.kushal.leandigit1.tableAdapters.OutflowRequirements;
import com.example.kushal.leandigit1.tableAdapters.PMG;
import com.example.kushal.leandigit1.tableAdapters.PRo_cess;
import com.example.kushal.leandigit1.tableAdapters.PmgExecution;
import com.example.kushal.leandigit1.tableAdapters.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    String activity,urlWeb;
    Data data;
    //ListView listView;
    private RecyclerView list;
    private Users mAdapter;
    private PRo_cess pAdapter;
    private Customers cAdapter;
    private CustomerOrder coAdapter;
    private InflowRequirements inAdapter;
    private Materials mtAdapter;
    private MaterialCreationConsumption mccAdapter;
    private MaterialFlowBalance mfbAdapter;
    private MaterialGroup mgAdapter;
    private OrderPropagation opAdapter;
    private OrderRecord orAdapter;
    private Orders oAdapter;
    private OutflowRequirements ofrAdapter;
    private PmgExecution peAdapter;
    private PMG pmgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        data= new Data();
        Intent intent = getIntent();

        activity = intent.getStringExtra("activities");

       // listView = (ListView) findViewById(R.id.listview);
        setTitle(activity);

        if (activity.equals("process")){
            urlWeb= data.getprocesslist;
        }else if (activity.equals("customer_order")){
            urlWeb= data.getCustomer_order;
        }else if (activity.equals("customer")){
            urlWeb= data.getcustomer;
        }else if (activity.equals("inflow_requirements")){
            urlWeb= data.getinflow_requirements;
        }else if (activity.equals("material")){
            urlWeb= data.getmaterial;
        }else if (activity.equals("material_creation_consumption")){
            urlWeb= data.getmaterial_creation_consumption;
        }else if (activity.equals("material_flow_balance")){
            urlWeb= data.getmaterial_flow_balance;
        }else if (activity.equals("material_group")){
            urlWeb= data.getmaterial_group;
        }else if (activity.equals("orders")){
            urlWeb= data.getorders;
        }else if (activity.equals("order_propogation")){
            urlWeb= data.getorder_propogation;
        }else if (activity.equals("order_record")){
            urlWeb= data.getorder_record;
        }else if (activity.equals("outflow_requirements")){
            urlWeb= data.getoutflow_requirements;
        }else if (activity.equals("pmg")){
            urlWeb= data.getpmglist;
        }else if (activity.equals("pmg_execution")){
            urlWeb= data.getpmg_executionlist;
        }else if (activity.equals("Users")){
            urlWeb= data.getUserslist;
        }

        getJSON(urlWeb);
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {

            if (activity.equals("process")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("process_id") + "    " + obj.getString("process_description");
                    Data myData = new Data();
                    myData.process_id = obj.getString("process_id");
                    myData.process_description = obj.getString("process_description");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                pAdapter = new PRo_cess(this,data);

                list.setAdapter(pAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));

                //SET ITS PROPETRIES
                list.setItemAnimator(new DefaultItemAnimator());



            }else if (activity.equals("customer_order")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("order_id") + "    " + obj.getString("customer_id")
                            + "    " + obj.getString("order_date") + "    " + obj.getString("expected_dd")
                            + "    " + obj.getString("commited_dd");
                    Data myData = new Data();
                    myData.order_id = obj.getString("order_id");
                    myData.customer_id = obj.getString("customer_id");
                    myData.order_date = obj.getString("order_date");
                    myData.expected_dd = obj.getString("expected_dd");
                    myData.commited_dd = obj.getString("commited_dd");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                coAdapter = new CustomerOrder(this,data);

                list.setAdapter(coAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("customer")) {
                    JSONArray jsonArray = new JSONArray(json);
                    String[] pass = new String[jsonArray.length()];
                    List<Data> data=new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        pass[i] = obj.getString("customer_id") + "    " + obj.getString("name")
                                + "    " + obj.getString("address") + "    " + obj.getString("email")
                                + "    " + obj.getString("phone_no");
                        Data myData = new Data();
                        myData.customer_id = obj.getString("customer_id");
                        myData.name = obj.getString("name");
                        myData.address = obj.getString("address");
                        myData.email = obj.getString("email");
                        myData.phone_no = obj.getString("phone_no");
                        data.add(myData);
                    }
                list = (RecyclerView)findViewById(R.id.List);
                cAdapter = new Customers(this,data);

                list.setAdapter(cAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("inflow_requirements")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("inflow_plan_no") + "    " + obj.getString("table_discreption")
                            + "    " + obj.getString("material_id") + "    " + obj.getString("required_quantity")
                            + "    " + obj.getString("po_no") + "    " + obj.getString("inwarded_quantity")
                            + "    " + obj.getString("balanced_quantity");
                    Data myData = new Data();
                    myData.inflow_plan_no = obj.getString("inflow_plan_no");
                    myData.table_discreption = obj.getString("table_discreption");
                    myData.material_id = obj.getString("material_id");
                    myData.required_quantity = obj.getString("required_quantity");
                    myData.po_no = obj.getString("po_no");
                    myData.inwarded_quantity = obj.getString("inwarded_quantity");
                    myData.balanced_quantity = obj.getString("balanced_quantity");
                    myData.inflow_condition = obj.getString("inflow_condition");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                inAdapter = new InflowRequirements(this,data);

                list.setAdapter(inAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("material_creation_consumption")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("mcp_no") + "    " + obj.getString("mcp_source")
                            + "    " + obj.getString("plan_no") + "    " + obj.getString("po_no")
                            + "    " + obj.getString("material_id") + "    " + obj.getString("qpmg")
                            + "    " + obj.getString("quantity") + "    " + obj.getString("change_type")
                            + "    " + obj.getString("propagated");
                    Data myData = new Data();
                    myData.mcp_no = obj.getString("mcp_no");
                    myData.mcp_source = obj.getString("mcp_source");
                    myData.plan_no = obj.getString("plan_no");
                    myData.po_no = obj.getString("po_no");
                    myData.material_id = obj.getString("material_id");
                    myData.qpmg = obj.getString("qpmg");
                    myData.quantity = obj.getString("quantity");
                    myData.change_type = obj.getString("change_type");
                    myData.propagated = obj.getString("propagated");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                mccAdapter = new MaterialCreationConsumption(this,data);

                list.setAdapter(mccAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("material_flow_balance")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("material_id") + "    " + obj.getString("creation_pending")
                            + "    " + obj.getString("current_invenory") + "    " + obj.getString("consumption_pending")
                            + "    " + obj.getString("creation_required");
                    Data myData = new Data();
                    myData.material_id = obj.getString("material_id");
                    myData.creation_pending = obj.getString("creation_pending");
                    myData.current_inventory = obj.getString("current_inventory");
                    myData.consumption_pending = obj.getString("consumption_pending");
                    myData.creation_required = obj.getString("creation_required");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                mfbAdapter = new MaterialFlowBalance(this,data);

                list.setAdapter(mfbAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("material_group")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("material_id") + "    " + obj.getString("pmg_id")
                            + "    " + obj.getString("process_rel") + "    " + obj.getString("qpmg");
                    Data myData = new Data();
                    myData.material_id = obj.getString("material_id");
                    myData.pmg_id = obj.getString("pmg_id");
                    myData.process_rel = obj.getString("process_rel");
                    myData.qpmg = obj.getString("qpmg");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                mgAdapter = new MaterialGroup(this,data);

                list.setAdapter(mgAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("material")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("material_id") + "    " + obj.getString("materail_name")
                            + "    " + obj.getString("uom");
                    Data myData = new Data();
                    myData.material_id = obj.getString("material_id");
                    myData.materail_name = obj.getString("materail_name");
                    myData.uom = obj.getString("uom");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                mtAdapter = new Materials(this,data);

                list.setAdapter(mtAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("order_propogation")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("item_id") + "    " + obj.getString("material_id")
                            + "    " + obj.getString("item_quantity") + "    " + obj.getString("propogated");
                    Data myData = new Data();
                    myData.item_id = obj.getString("item_id");
                    myData.material_id = obj.getString("material_id");
                    myData.item_quantity = obj.getString("item_quantity");
                    myData.propogated = obj.getString("propogated");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                opAdapter = new OrderPropagation(this,data);

                list.setAdapter(opAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("order_record")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("item_id") + "    " + obj.getString("order_id");
                    Data myData = new Data();
                    myData.item_id = obj.getString("item_id");
                    myData.order_id = obj.getString("order_id");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                orAdapter = new OrderRecord(this,data);

                list.setAdapter(orAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("orders")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("item_id") + "    " + obj.getString("quantity")
                            + "    " + obj.getString("uom") + "    " + obj.getString("remark");
                    Data myData = new Data();
                    myData.item_id = obj.getString("item_id");
                    myData.quantity = obj.getString("quantity");
                    myData.uom = obj.getString("uom");
                    myData.remark = obj.getString("remark");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                oAdapter = new Orders(this,data);

                list.setAdapter(oAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("outflow_requirements")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("outflow_plan_no") + "    " + obj.getString("table_discreption")
                            + "    " + obj.getString("material_id") + "    " + obj.getString("required_quantity")
                            + "    " + obj.getString("po_no") + "    " + obj.getString("delivered_quantity")
                            + "    " + obj.getString("balanced_quantity") + "    " + obj.getString("outflow_condition");
                    Data myData = new Data();
                    myData.outflow_plan_no = obj.getString("outflow_plan_no");
                    myData.table_discreption = obj.getString("table_discreption");
                    myData.material_id = obj.getString("material_id");
                    myData.required_quantity = obj.getString("required_quantity");
                    myData.po_no = obj.getString("po_no");
                    myData.delivered_quantity = obj.getString("delivered_quantity");
                    myData.balanced_quantity = obj.getString("balanced_quantity");
                    myData.outflow_condition = obj.getString("outflow_condition");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                ofrAdapter = new OutflowRequirements(this,data);

                list.setAdapter(ofrAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("pmg_execution")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("execution_plan_no") + "    " + obj.getString("req_no")
                            + "    " + obj.getString("execution_discreption") + "    " + obj.getString("pmg_id")
                            + "    " + obj.getString("po_no") + "    " + obj.getString("units");
                    Data myData = new Data();
                    myData.execution_plan_no = obj.getString("execution_plan_no");
                    myData.req_no = obj.getString("req_no");
                    myData.execution_discreption = obj.getString("execution_discreption");
                    myData.pmg_id = obj.getString("pmg_id");
                    myData.po_no = obj.getString("po_no");
                    myData.units = obj.getString("units");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                peAdapter = new PmgExecution(this,data);

                list.setAdapter(peAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("pmg")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    pass[i] = obj.getString("pmg_id") + "    " + obj.getString("pmg_description")
                            + "    " + obj.getString("process_id");
                    Data myData = new Data();
                    myData.pmg_id = obj.getString("pmg_id");
                    myData.pmg_description = obj.getString("pmg_description");
                    myData.process_id = obj.getString("process_id");
                    data.add(myData);
                }
                list = (RecyclerView)findViewById(R.id.List);
                pmgAdapter = new PMG(this,data);

                list.setAdapter(pmgAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
            }else if (activity.equals("Users")) {
                JSONArray jsonArray = new JSONArray(json);
                String[] pass = new String[jsonArray.length()];
                List<Data> data=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                pass[i] = obj.getString("username") + "    " + obj.getString("password");
                Data myData = new Data();
                myData.username= obj.getString("username");
                myData.password= obj.getString("password");
                data.add(myData);
            }
                list = (RecyclerView)findViewById(R.id.List);
                mAdapter = new Users(this,data);

                list.setAdapter(mAdapter);
                list.setLayoutManager(new LinearLayoutManager(this));
        }
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pass);
       // listView.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.refresh:
                finish();
                startActivity(new Intent(this,ListActivities.class));
                break;
        }
        return true;
    }

    public void add(View view){

        if (activity.equals("process")) {
            startActivity(new Intent(this, addProcess.class));

        }else if (activity.equals("customer")){
            startActivity(new Intent(this, addCustomer.class));

        }else if (activity.equals("customer_order")){
            startActivity(new Intent(this, addCustomerOrder.class));
        }else if (activity.equals("material")){
            startActivity(new Intent(this, addMaterial.class));
        }else if (activity.equals("Users")){
            startActivity(new Intent(this, Register.class));
        }else if (activity.equals("pmg")){
            startActivity(new Intent(this, addPMG.class));
        }else if (activity.equals("orders")){
            startActivity(new Intent(this, addOrders.class));
        }

    }
}
