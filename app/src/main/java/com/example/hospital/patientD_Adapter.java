package com.example.hospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class patientD_Adapter extends RecyclerView.Adapter<patientD_Adapter.MyViewHolder> {


    Context context;
    ArrayList<patientD> list;

    public patientD_Adapter(Context context, ArrayList<patientD> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        patientD pd= list.get(position);
        holder.name.setText(pd.getName());
        holder.age.setText(pd.getAge());
        holder.gender.setText(pd.getGender());
        holder.phone.setText(pd.getPhone());
        holder.email.setText(pd.getEmail());
        holder.appointmentDate.setText(pd.getDate());
        holder.appointmentTime.setText(pd.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView name,age,gender,phone,email,appointmentDate,appointmentTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tv1);
            age=itemView.findViewById(R.id.tv2);
            gender=itemView.findViewById(R.id.tv3);
            phone=itemView.findViewById(R.id.tv4);
            email=itemView.findViewById(R.id.tv5);
            appointmentDate=itemView.findViewById(R.id.tv6);
            appointmentTime=itemView.findViewById(R.id.tv7);
        }
    }
}
