package com.example.autoware;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.remote.FirestoreChannel;

import java.util.ArrayList;

public class Owner_ManageServiceFragment extends Fragment {

    private TextView ServiceDetails, jobcard;
    private Button Save, Back, Done;
    private EditText Tax, ServiceCharges;
    private LinearLayout SparepartsList;
    private ArrayList<CheckBox> SparepartsCheckBoxes;
    private ArrayList<Sparepart> Spareparts;
    private FirebaseFirestore db;
    private Services service;
    private int total = 0;
    private String ser;

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
        Done = (Button) v.findViewById(R.id.btn_done);
        Back = (Button) v.findViewById(R.id.btn_back);
        ServiceDetails = (TextView) v.findViewById(R.id.ServiceDetails);
        jobcard = (TextView) v.findViewById(R.id.jobcard);
        ServiceCharges = (EditText) v.findViewById(R.id.service_charges);
        Tax = (EditText) v.findViewById(R.id.Charges_tax);
        SparepartsList = v.findViewById(R.id.linear_layout_sparepartlist);
        db = FirebaseFirestore.getInstance();

        Bundle b = this.getArguments();
        db.collection("Services").document(b.getString("ServiceID")).get().addOnSuccessListener(
                new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        service = documentSnapshot.toObject(Services.class);
                    }
                }
        );
        PopulateServiceDetails();
        db.collection("Spareparts").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).collection("Spareparts").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            Sparepart s = document.toObject(Sparepart.class);
                            Spareparts.add(s);
                            CheckBox cb = new CheckBox((getActivity().getApplicationContext()));
                            cb.setText(s.getName() + " - ₹" + s.getPrice());
                            cb.setTextSize(20);
                            cb.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PopulateJobCard();
                                }
                            });
                            SparepartsCheckBoxes.add(cb);
                        }
                    }
                });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < SparepartsCheckBoxes.size(); i++) {
                    if(SparepartsCheckBoxes.get(i).isChecked())
                    {
                        Spareparts.get(i);
                    }
                }

            }
        });
        return v;
    }

    public void PopulateServiceDetails() {
        ser = "Service Details:\n";
        for (String s : service.getCars()) {
            ser += "Car Number: " + s + "\n";
        }
        if (service.getTowingFlag())
            ser += "Towing Service: YES\n";
        else
            ser += "Towing Service: NO\n";
        db.collection("Customers").document(service.getCustomerID()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Customer c = documentSnapshot.toObject(Customer.class);
                ser += c.getName() + "\nEmail: " + c.getEmail() + "\nAddress" + c.getLocation();
            }
        });
        ser += "\nDate of Booking: " + service.getDate();
        ser += "\nDescription: " + service.getDescription();
        if (service.getStatus())
            ser += "\nStatus: Pending";
        else
            ser += "\nStatus: Completed";
    }

    public void PopulateJobCard() {
        String jobcardstring = "";
        for (int i = 0; i < SparepartsCheckBoxes.size(); i++) {
            if (SparepartsCheckBoxes.get(i).isChecked()) {
                jobcardstring += "Spare part " + i + ": " + Spareparts.get(i).getName() + " - ₹" + Spareparts.get(i).getPrice() + "\n";
                total += Spareparts.get(i).getPrice();
            }
        }
        if (!TextUtils.isEmpty(ServiceCharges.getText())) {
            total += Integer.parseInt(ServiceCharges.getText().toString());
            jobcardstring += "\nService Charges applied:\t " + ServiceCharges.getText().toString();
            jobcardstring += "\nTotal Amount:\t ₹" + total;

        }
        if (!TextUtils.isEmpty(Tax.getText())) {
            total += (Integer.parseInt(Tax.getText().toString()) / total);

            jobcardstring += "\nTotal Taxable Amount:\t  ₹" + (Float.parseFloat(Tax.getText().toString()) / total) + " @ " + Tax.getText().toString();
        }
        jobcard.setText(jobcardstring);
    }
}