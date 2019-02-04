package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddCustomer extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    Context context = this;
    DatabaseHelper db;
    EditText date, customer_name, phone, country, city, hotel_name, company_commission, booking_number,company_name, travel_date, kind_of_room, guest, exchange_rate, brutto, netto, personel_commission, notes;
    Button record_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        db = new DatabaseHelper(this);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> month_adapter = ArrayAdapter.createFromResource(this, R.array.months, R.layout.support_simple_spinner_dropdown_item);
        month_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(month_adapter);
        spinner.setOnItemSelectedListener(this);
        date = findViewById(R.id.c_date);
        customer_name = findViewById(R.id.c_customer_name);
        phone = findViewById(R.id.c_phone);
        country = findViewById(R.id.c_country);
        city = findViewById(R.id.c_city);
        booking_number = findViewById(R.id.c_booking_number);
        travel_date = findViewById(R.id.c_travel_date);
        kind_of_room = findViewById(R.id.c_kind_of_room);
        guest = findViewById(R.id.c_guests);
        exchange_rate = findViewById(R.id.c_exchange_rate);
        brutto = findViewById(R.id.c_brutto);
        netto = findViewById(R.id.c_netto);
        company_commission = findViewById(R.id.c_company_commission);
        personel_commission = findViewById(R.id.c_your_commission);
        notes = findViewById(R.id.c_notes);
        record_button = findViewById(R.id.add_database_button);
        company_name = findViewById(R.id.c_company_name);
        hotel_name = findViewById(R.id.c_hotel_name);

        record_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean inserted = db.insertData(spinner.getSelectedItem().toString() != "" ? spinner.getSelectedItem().toString() : "-",
                            customer_name.getText().toString() != "" ? customer_name.getText().toString() : "-",
                            company_name.getText().toString() != "" ? company_name.getText().toString() : "-",
                            country.getText().toString() != "" ? country.getText().toString() : "-",
                            city.getText().toString() != "" ? city.getText().toString() : "-",
                            travel_date.getText().toString() != "" ? travel_date.getText().toString() : "-",
                            date.getText().toString() != "" ? date.getText().toString() : "-",
                            kind_of_room.getText().toString() != "" ? kind_of_room.getText().toString() : "-",
                            guest.getText().toString() != "" ? guest.getText().toString() : "-",
                            phone.getText().toString() != "" ? phone.getText().toString() : "-",
                            exchange_rate.getText().toString() != "" ? exchange_rate.getText().toString() : "0",
                            Integer.parseInt(brutto.getText().toString() != "" ? brutto.getText().toString() : "0"),
                            Integer.parseInt(netto.getText().toString() != "" ? netto.getText().toString() : "0"),
                            Integer.parseInt(company_commission.getText().toString() != "" ? company_commission.getText().toString() : "0"),
                            Integer.parseInt(personel_commission.getText().toString() != "" ? personel_commission.getText().toString() : "0"),
                            notes.getText().toString() != "" ? notes.getText().toString() : "-",
                            booking_number.getText().toString() != "" ? booking_number.getText().toString() : "0",
                            hotel_name.getText().toString() != "" ? hotel_name.getText().toString() : "-");
                    if (inserted) {
                        Toast.makeText(AddCustomer.this, "Customer Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context, MainActivity.class));
                        finish();
                    }
                    else
                        Toast.makeText(AddCustomer.this, "Error, please try again later.", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(AddCustomer.this, "Error, please fill correctly.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
