package com.example.hospital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DiabAdapter extends ArrayAdapter<Diab> {
    private Context mcontext;
    private int mResource;



    public DiabAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Diab> objects) {
        super(context, resource, objects);
        this.mcontext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LayputInflater = LayoutInflater.from(mcontext);

        convertView = LayputInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imageView);

        TextView txtName = convertView.findViewById(R.id.txtname);

        TextView txDes = convertView.findViewById(R.id.txDes);

        imageView.setImageResource(getItem(position).getImage());

        txtName.setText(getItem(position).getName());

        txDes.setText(getItem(position).getDes());

        return convertView;
    }
}

