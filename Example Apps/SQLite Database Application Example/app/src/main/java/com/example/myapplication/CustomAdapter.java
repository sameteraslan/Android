package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<Customer> customersArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public CustomAdapter(ArrayList<Customer> customersArrayList, Context context) {
        this.customersArrayList = customersArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.row_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.customer_name.setText(customersArrayList.get(i).getCustomer_name());
        viewHolder.number.setText(customersArrayList.get(i).getCustomer_phone());
        viewHolder.number.setText((i + 1) + "");
        viewHolder.linearLayout.setTag(viewHolder);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomerDetails.class);
                System.out.println("id numberrrrrr" + customersArrayList.get(i).id);
                int id = customersArrayList.get(i).id;
                intent.putExtra("ID", id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customersArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, customer_name, phone;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.numbers);
            customer_name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            linearLayout = itemView.findViewById(R.id.linear);
        }
    }

}
