package com.jerrySoft;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Button btnA, btnB, btnC;
    TextView textView, textView2;
    Intent intentC;
    ActionBarDrawerToggle actionToggle;
    NavigationView navigationView;
    Toolbar toolbar;
   // CollapsingToolbarLayout collapse;

//navigation listening class method
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        switch(item.getItemId()){
            case R.id.dev:
                Intent devIntent = new Intent(MainActivity.this, AboutDeveloper.class);
                startActivity(devIntent);
                break;
            case R.id.about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutApp.class);
                startActivity(aboutIntent);
                break;
            case R.id.contact:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Contact");
                alertDialog.setMessage("For further assistance, you can \ncall Benue state police command with this " +
                        " number:\n 08066006475");
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;
            case R.id.facebook:
                Intent faceBookIntent = new Intent(MainActivity.this, PoliceFaceBookPage.class);
                startActivity(faceBookIntent);

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnA = (Button) findViewById(R.id.buttonA);
        btnB = (Button) findViewById(R.id.buttonB);
        btnC = (Button) findViewById(R.id.buttonC);
        //  textView = (TextView)findViewById(R.id.textZone);
        textView = (TextView) findViewById(R.id.zoneReportLabel);
        TextView labelReason = (TextView) findViewById(R.id.labelReason);
        ImageView imageView = (ImageView) findViewById(R.id.imageBanner);
        navigationView = findViewById(R.id.navigate);
       // collapse = (CollapsingToolbarLayout)findViewById(R.id.collapseit);

        //tool bar implementation
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(actionToggle);
        actionToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentC = new Intent(MainActivity.this, ZoneC.class);
                startActivity(intentC);

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentB = new Intent(MainActivity.this, ZoneB.class);

                startActivity(intentB);
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentA = new Intent(MainActivity.this, ZoneA.class);
                startActivity(intentA);
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newCongif) {
        super.onConfigurationChanged(newCongif);
        actionToggle.onConfigurationChanged(newCongif);
    }

    //this method alert user that want to exit the from the app
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new androidx.appcompat.app.AlertDialog.Builder(this);
        alertDialog.setTitle("Crime Reporters");
        alertDialog.setMessage("Are you Sure You Want to Exit?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create().show();
        //super.onBackPressed();
    }
}
