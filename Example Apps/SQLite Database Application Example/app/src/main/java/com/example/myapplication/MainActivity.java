package com.example.myapplication;

/*
 * Created by Samet ERASLAN - 04.02.2019
 * Contact: abdulsamet.eraslan@stu.fsm.edu.tr
 * Whatsapp: +905467943767
 */
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<Customer> customers = new ArrayList<>();
    RecyclerView recyclerView;
    Context context = this;
    Spinner spinner;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(context, AddCustomer.class));
            }
        });
        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> month_adapter = ArrayAdapter.createFromResource(this, R.array.months, R.layout.support_simple_spinner_dropdown_item);
        month_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(month_adapter);
        spinner.setOnItemSelectedListener(this);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        customers.clear();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                customers.clear();
                Cursor result = db.getAllData(spinner.getSelectedItem().toString());
                if (result.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "You have no data in " + spinner.getSelectedItem().toString() + ".", Toast.LENGTH_SHORT).show();
                }
                while (result.moveToNext()) {
                    Customer c = new Customer(  result.getString(3),    //customer_name +
                            result.getString(18),   //company_name
                            result.getString(5),    //country
                            result.getString(6),    //city
                            result.getString(8),    //travel_dates
                            result.getString(2),    //record_date
                            result.getString(10),   //kind_of_room
                            result.getString(11),   //guests
                            result.getString(4),    //customer_phone
                            result.getString(17),   //notes
                            result.getString(1),    //month
                            result.getString(9),    //hotel_name
                            result.getInt(12),      //exchange_rate
                            result.getInt(13),      //brutto
                            result.getInt(14),      //netto
                            result.getInt(15),      //company comm
                            result.getInt(16),      //your comm
                            result.getString(7));      //booking num
                    c.id = result.getInt(0);
                    customers.add(c);

                }
                CustomAdapter adapter = new CustomAdapter(customers, context);

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
