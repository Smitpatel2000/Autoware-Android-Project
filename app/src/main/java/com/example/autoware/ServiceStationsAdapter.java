package com.example.autoware;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ServiceStationsAdapter extends BaseAdapter {

    private Activity c;
    private ArrayList<Owner> ServiceStations;
    private static LayoutInflater inflater = null;

    public ServiceStationsAdapter() {
    }

    public ServiceStationsAdapter(Activity c, ArrayList<Owner> serviceStations) {
        this.c = c;
        ServiceStations = serviceStations;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Owner getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}