package com.example.autoware;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Owner_ManageServiceFragment extends Fragment {

    private TextView ServiceDetails, jobcard;
    private Button Save,Back,Done;
    private EditText Tax, ServiceCharges;
    private LinearLayout SparepartsList;
    private ArrayList<String> Spareparts;
    private ArrayList<Integer> Sparepartprice;
    public Owner_ManageServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_owner__manage_service, container, false);
        Save = (Button) v.findViewById(R.id.btn_save);
        Done= (Button)v.findViewById(R.id.btn_done);
        Back = (Button)v.findViewById(R.id.btn_back);
        ServiceDetails = (TextView)v.findViewById(R.id.ServiceDetails);
        jobcard = (TextView)v.findViewById(R.id.jobcard);
        ServiceCharges = (EditText) v.findViewById(R.id.service_charges);
        Tax = (EditText) v.findViewById(R.id.Charges_tax);
        SparepartsList = v.findViewById(R.id.linear_layout_sparepartlist);

        return  v;
    }
}