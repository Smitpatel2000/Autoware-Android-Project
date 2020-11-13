package com.example.autoware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drl;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drl = (DrawerLayout) findViewById(R.id.drawer);
        nv = (NavigationView) findViewById(R.id.navigationdrawer);
        toggle = new ActionBarDrawerToggle(this, drl,R.string.open,R.string.close);
        drl.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.di5) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent1 = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                    return true;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Toast.makeText(this, "onOptionsItemSelected "+id, Toast.LENGTH_SHORT).show();
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}