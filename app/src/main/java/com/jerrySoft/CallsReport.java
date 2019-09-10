package com.jerrySoft;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class CallsReport extends AppCompatActivity {
    // Button policeB, safetyB, reportB;
    String lGAname;
    private static final int REQUEST_CALL = 1;
    //Spinner callSpin;
    GridView grid;
    String[] securityName = {"POLICE", "ROAD SAFETY", "NDLEA", "NAFDAC", "NEMA", "FILE A REPORT"};
    Integer[] logo = {R.drawable.police_logo,
            R.drawable.road,
            R.drawable.ndlea,
            R.drawable.nfdac,
            R.drawable.nema,
            R.drawable.report_file};

    // this method handle permission from the user
    public void callPermission() {

        ActivityCompat.requestPermissions(CallsReport.this,
                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

    }

    //this method pass the result of the request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPermission();
            } else {
                Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_grid_calls);

        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
        lGAname = getIntent().getStringExtra("LGA");
        welcomeText.setText("Welcome, " + lGAname + " LGA");

        CustomAdapter adapter = new CustomAdapter(CallsReport.this, securityName, logo);
        grid = (GridView) findViewById(R.id.gridID);

        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    if (ActivityCompat.checkSelfPermission(CallsReport.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        callPermission();
                    } else {
                        Intent policeIntent = new Intent(Intent.ACTION_CALL);
                        policeIntent.setData(Uri.parse("tel:07067374913"));
                        startActivity(policeIntent);
                    }


                }
                if (position == 1) {

                    if (ActivityCompat.checkSelfPermission(CallsReport.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        callPermission();
                    } else {
                        Intent roadIntent = new Intent(Intent.ACTION_CALL);
                        roadIntent.setData(Uri.parse("tel:122"));
                        startActivity(roadIntent);
                    }


                }
                if (position == 2) {

                    if (ActivityCompat.checkSelfPermission(CallsReport.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        callPermission();
                    } else {
                        Intent drugIntent = new Intent(Intent.ACTION_CALL);
                        drugIntent.setData(Uri.parse("tel:+2348062199999"));
                        startActivity(drugIntent);
                    }


                }
                if (position == 3) {

                    if (ActivityCompat.checkSelfPermission(CallsReport.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        callPermission();
                    } else {
                        Intent nafdacIntent = new Intent(Intent.ACTION_CALL);
                        nafdacIntent.setData(Uri.parse("tel:07067374913"));
                        startActivity(nafdacIntent);
                    }


                }
                if (position == 4) {

                    if (ActivityCompat.checkSelfPermission(CallsReport.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        callPermission();
                    } else {
                        Intent nemaIntent = new Intent(Intent.ACTION_CALL);
                        nemaIntent.setData(Uri.parse("tel:080022556362"));
                        startActivity(nemaIntent);
                    }


                }


                if (position == 5) {


                    Intent reportIntent = new Intent(CallsReport.this, ReportA.class);
                    reportIntent.putExtra("LG", lGAname);
                    startActivity(reportIntent);

                }

            }
        });


    }


}



