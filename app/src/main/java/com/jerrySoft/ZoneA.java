package com.jerrySoft;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ZoneA extends AppCompatActivity {
ListView aList;
String [] lGaA = {"Buruku", "Gboko","Guma", "Gwer East","Gwer West", "Makurdi", "Tarka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        aList = (ListView)findViewById(R.id.zone_a_list);
       TextView msgLabelA =(TextView)findViewById(R.id.msgLabel);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ZoneA.this, android.R.layout.simple_list_item_1,lGaA);
        aList.setAdapter(adapter);



        aList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String itemValue =(String)aList.getItemAtPosition(position);

               Toast.makeText(getApplicationContext(),itemValue + "  is in Zone A", Toast.LENGTH_LONG).show();
                if(position==1){

                    Intent reportPage = new Intent(ZoneA.this,CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==2){

                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==3){

                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==4){


                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==5){

                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==6){

                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }
                if(position==0){

                    Intent reportPage = new Intent(ZoneA.this, CallsReport.class);
                    reportPage.putExtra("LGA",itemValue);
                    startActivity(reportPage);
                }

            }
        });

    }
}
