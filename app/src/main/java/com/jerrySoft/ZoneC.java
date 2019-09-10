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

public class ZoneC extends AppCompatActivity {
    //list container
 ListView listView;
 // Zone c local government lists
 String [] lgaZoneC = {"Ado","Agatu", "Apa","Obi", "Ogbadibo","Ohimini","Oju","Okpokwu","Otukpo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_c);

        listView =(ListView)findViewById(R.id.zone_c_list);
        TextView msgLabelC = (TextView)findViewById(R.id.msgLabelC) ;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ZoneC.this, android.R.layout.simple_list_item_1, lgaZoneC);
        listView.setAdapter( adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue =(String)listView.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),itemValue+ " is in Zone C", Toast.LENGTH_LONG).show();
                if(position==0){

                    Intent zoneCIntent = new Intent(ZoneC.this, CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==1){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==2){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==3){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==4){

                    Intent zoneCIntent = new Intent(ZoneC.this, CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==5){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==6){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==7){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }
                if(position==8){

                    Intent zoneCIntent = new Intent(ZoneC.this,  CallsReport.class);
                    zoneCIntent.putExtra("LGA", itemValue);
                    startActivity(zoneCIntent);
                }

            }
        });
    }
}
