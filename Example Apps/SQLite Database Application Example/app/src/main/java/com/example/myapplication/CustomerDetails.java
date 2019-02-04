package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerDetails extends AppCompatActivity {

    TextView date, customer_name, phone, country, city, hotel_name, booking_number,company_name, company_commission, travel_date, kind_of_room, guest, exchange_rate, brutto, netto, personel_commission, notes, company_commission_amount, your_commission_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        company_commission_amount = findViewById(R.id.c_company_commission_amount);
        your_commission_amount = findViewById(R.id.c_your_commission_amount);
        date = findViewById(R.id.c_date);
        customer_name = findViewById(R.id.c_customer_name);
        phone = findViewById(R.id.c_phone);
        country = findViewById(R.id.c_country);
        city = findViewById(R.id.c_city);
        booking_number = findViewById(R.id.c_number_of_book);
        travel_date = findViewById(R.id.c_travel_date);
        kind_of_room = findViewById(R.id.c_kind_of_room);
        guest = findViewById(R.id.c_guests);
        exchange_rate = findViewById(R.id.c_exchange_rate);
        brutto = findViewById(R.id.c_brutto);
        netto = findViewById(R.id.c_netto);
        company_commission = findViewById(R.id.c_company_commission);
        personel_commission = findViewById(R.id.c_your_commission);
        notes = findViewById(R.id.c_notes);
        company_name = findViewById(R.id.c_company_name);
        hotel_name = findViewById(R.id.c_hotel_name);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        System.out.println("id number:" + id);
        if (id == -1)
            return;
        DatabaseHelper db = new DatabaseHelper(this);

        Cursor result = db.getUserInfo(id);

        if (result.getCount() == 0) {
            Toast.makeText(CustomerDetails.this, "Something wrong. Please contact with developer!", Toast.LENGTH_SHORT).show();
            return;
        }
        while (result.moveToNext()) {
            //bilgiler buraya gelecek;
            date.setText(result.getString(2));
            customer_name.setText(result.getString(3));
            phone.setText(result.getString(4));
            country.setText(result.getString(5));
            city.setText(result.getString(6));
            booking_number.setText(result.getString(7) + "");
            travel_date.setText(result.getString(8));
            hotel_name.setText(result.getString(9));
            kind_of_room.setText(result.getString(10));
            guest.setText(result.getString(11));
            exchange_rate.setText(result.getString(12) + "");
            brutto.setText(result.getInt(13) + "");
            netto.setText(result.getInt(14) + "");
            company_commission.setText(result.getInt(15) + "");
            personel_commission.setText(result.getInt(16) + "");
            notes.setText(result.getString(17));
            company_commission_amount.setText((Integer.parseInt(brutto.getText().toString()) - Integer.parseInt(netto.getText().toString())) + "");
            your_commission_amount.setText((Integer.parseInt(company_commission_amount.getText().toString()) * Integer.parseInt(personel_commission.getText().toString()) / 100) + "");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DatabaseHelper db = new DatabaseHelper(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        System.out.println(id);
        switch (item.getItemId()) {
            case R.id.item1:
                db.deleteRecord(id);
                Toast.makeText(CustomerDetails.this, "Deleted succesfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(this, CustomerUpdate.class);
                intent2.putExtra("ID", id);
                startActivity(intent2);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
}
