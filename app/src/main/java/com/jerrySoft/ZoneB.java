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

public class ZoneB extends AppCompatActivity {
ListView bList;
//string array of all local govt in b
    String [] lgaB ={"Katstina-Ala","Konshisha","Kwande","Logo","Ukum","Ushongo","Vandeikya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_b);
        bList = (ListView) findViewById(R.id.zone_b_list);
        TextView scrollingLabel =(findViewById(R.id.msgLabel));

        ArrayAdapter adapter = new ArrayAdapter<String>(ZoneB.this, android.R.layout.simple_list_item_1, lgaB);
        bList.setAdapter(adapter);
        bList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue =(String)bList.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),itemValue+ " is in Zone B", Toast.LENGTH_LONG).show();
                if(position==0){
                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==6){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==1){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==3){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==4){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==5){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }
                if(position==2){

                    Intent zoneBIntent = new Intent(ZoneB.this, CallsReport.class);
                    zoneBIntent.putExtra("LGA", itemValue);
                    startActivity(zoneBIntent);
                }

            }
        });
    }
}
