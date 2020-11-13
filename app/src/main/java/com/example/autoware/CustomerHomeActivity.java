package com.example.autoware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerHomeActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drl;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        drl = (DrawerLayout) findViewById(R.id.cust_drawer);
        nv = (NavigationView) findViewById(R.id.cust_navigationdrawer);
        toggle = new ActionBarDrawerToggle(this, drl, R.string.open, R.string.close);
        drl.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent it;
                switch (item.getItemId()) {
                    case R.id.dr_cust_logout:
                        FirebaseAuth.getInstance().signOut();
                        it = new Intent(CustomerHomeActivity.this, MainActivity.class);
                        startActivity(it);
                        finish();
                        break;

                    case R.id.dr_cust_cars:
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.cust_framelayout,new CarsFragment());
                        ft.commit();
                        break;

                    case R.id.dr_cust_services:
                        break;
                }
                drl.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Toast.makeText(this, "onOptionsItemSelected "+id, Toast.LENGTH_SHORT).show();
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


}


