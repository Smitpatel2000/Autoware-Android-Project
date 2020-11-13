package com.example.autoware;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CarListAdapter extends BaseAdapter {
    private Activity c;
    private ArrayList<Car> Cars;
    private static LayoutInflater inflater = null;

    public CarListAdapter() {
    }

    public CarListAdapter(Activity c, ArrayList<Car> cars) {
        this.c = c;
        Cars = cars;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Cars.size();
    }

    @Override
    public Car getItem(int position) {
        return Cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = inflater.inflate(R.layout.item_recycler,null);
        TextView RegistrationNumber = (TextView) itemView.findViewById(R.id.text_big);
        TextView CarDetails = (TextView) itemView.findViewById(R.id.text_small);
        Car selectedCar = getItem(position);
        RegistrationNumber.setText(selectedCar.getRegistrationNumber());
        CarDetails.setText(selectedCar.getBrand()+" " +selectedCar.getModel() +", " +selectedCar.getFuelType());
        return itemView;
    }
}
