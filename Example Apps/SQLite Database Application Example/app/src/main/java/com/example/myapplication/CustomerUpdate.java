package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CustomerUpdate extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    Context context = this;
    DatabaseHelper db;
    EditText date, customer_name, phone, country, company_commission, city, hotel_name, booking_number,company_name, travel_date, kind_of_room, guest, exchange_rate, brutto, netto, personel_commission, notes;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_update);
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
        update_button = findViewById(R.id.add_database_button);
        company_name = findViewById(R.id.c_company_name);
        hotel_name = findViewById(R.id.c_hotel_name);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", -1);
        System.out.println(id);
        if (id == -1) {
            Toast.makeText(CustomerUpdate.this, "Something wrong(ID). Please try again later.", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor result = db.getUserInfo(id);
        if (result.getCount() == 0) {
            Toast.makeText(CustomerUpdate.this, "Something wrong(No Result). Please try again later.", Toast.LENGTH_SHORT).show();
            return;
        }
        while (result.moveToNext()) {
            date.setText(result.getString(2));
            customer_name.setText(result.getString(3));
            phone.setText(result.getString(4));
            country.setText(result.getString(5));
            city.setText(result.getString(6));
            booking_number.setText(result.getInt(7) + "");
            travel_date.setText(result.getString(8));
            hotel_name.setText(result.getString(9));
            kind_of_room.setText(result.getString(10));
            guest.setText(result.getString(11));
            exchange_rate.setText(result.getInt(12) + "");
            brutto.setText(result.getInt(13) + "");
            netto.setText(result.getInt(14) + "");
            company_commission.setText(result.getInt(15) + "");
            personel_commission.setText(result.getInt(16) + "");
            notes.setText(result.getString(17));
            company_name.setText(result.getString(18) + "");
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    boolean updated = db.updateData(id,
                            spinner.getSelectedItem().toString() != "" ? spinner.getSelectedItem().toString() : "-",
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
                    if (updated) {
                        Toast.makeText(CustomerUpdate.this, "Customer Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context, MainActivity.class));
                        finish();
                    }
                    else
                        Toast.makeText(CustomerUpdate.this, "Error, please try again later.", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(CustomerUpdate.this, "Error, please fill correctly.", Toast.LENGTH_SHORT).show();
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
