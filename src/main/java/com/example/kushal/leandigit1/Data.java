package com.example.kushal.leandigit1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Kushal on 02-06-2018.
 */

public class Data {

    //URLs
    String ROOT="http://35.227.79.163/";

    String login_url= ROOT+"login.php";

    String getActivitylist="http://35.227.79.163/getActivitylist.php";

    String getprocesslist= ROOT+"getprocesslist.php";
    String getCustomer_order= ROOT+"getCustomer_order.php";
    String getcustomer= ROOT+"getcustomer.php";;
    String getinflow_requirements= ROOT+"getinflow_requirements.php";
    String getmaterial= ROOT+"getmaterial.php";
    String getmaterial_creation_consumption= ROOT+"getmaterial_creation_consumption.php";
    String getmaterial_flow_balance= ROOT+"getmaterial_flow_balance.php";
    String getmaterial_group= ROOT+"getmaterial_group.php";
    String getorders= ROOT+"getorders.php";
    String getorder_propogation= ROOT+"getorder_propogation.php";
    String getorder_record= ROOT+"getorder_record.php";
    String getoutflow_requirements= ROOT+"getoutflow_requirements.php";
    String getpmglist= ROOT+"getpmglist.php";
    String getpmg_executionlist= ROOT+"getpmg_executionlist.php";
    String getUserslist= ROOT+"getUserslist.php";

    String addProcess_url= ROOT+"addprocess.php";
    String addCustomer_url= ROOT+"addCustomer.php";
    String addCustomerOrder_url= ROOT+"addCustomerOrder.php";
    String addMaterial_url= ROOT+"addmaterial.php";
    String register_url= ROOT+"register.php";
    String addpmg_url= ROOT+"addpmg.php";
    String addOrders_url= ROOT+"addOrders.php";



    //processing data
    public String process_id;
    public String process_description;
    public String order_id;
    public String customer_id;
    public String order_date;
    public String expected_dd;
    public String commited_dd;
    public String name;
    public String address;
    public String email;
    public String phone_no;
    public String inflow_plan_no;
    public String material_id;
    public String po_no;
    public String inwarded_quantity;
    public String materail_name;
    public String uom;
    public String mcp_no;
    public String mcp_source;
    public String plan_no;
    public String qpmg;
    public String quantity;
    public String change_type;
    public String propagated;
    public String creation_pending;
    public String current_inventory;
    public String consumption_pending;
    public String creation_required;
    public String pmg_id;
    public String process_rel;
    public String item_id;
    public String remark;
    public String item_quantity;
    public String propogated;
    public String outflow_plan_no;
    public String table_discreption;
    public String required_quantity;
    public String delivered_quantity;
    public String balanced_quantity;
    public String outflow_condition;
    public String pmg_description;
    public String execution_plan_no;
    public String req_no;
    public String execution_discreption;
    public String units;
    public String username;
    public String password;
    public String inflow_condition;


    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }

    public String getProcess_description() {
        return process_description;
    }

    public void setProcess_description(String process_description) {
        this.process_description = process_description;
    }


}
