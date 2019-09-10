package com.jerrySoft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportA extends AppCompatActivity {
    Spinner spinner;
    AutoCompleteTextView addrWard;
    String[] crimeType = {"Select Crime Type", "Stealing", "murder", "communal crisis", "Homicide", "Attempted Suicide", "Fear", "others"};
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> wards;
    String[] wardList = {"Mbaawa,", " Mbabai", "Mbagwen", "Mbasaan, ", " Uyiev ", " Ingohov,", " Mbakpa, ", " Njiriv, ", " Raav", "Yonov ",
            "Ingohov,", " Mbakpa,", " Njiriv,", " Raav,", " Yonov Mbavaa,", " Shan-Gevtie, ", "Ikurav-Ya, ", "Nanev", "Shangev-Ya, ",
            "Turan Gaambe-Ya,", " Gaambe_Tiev Kpav,", " Kyuran-Tev, ", " Mbaterem, ", "Ngenev, ", "Tongov, ", "Torov", "Ucha, ", " Ugond Igede,",
            " Ito, ", "Uwokwu Adoka,", " Akpa, ", "Oglewu,", " Onyan-Gede", " Ugboju Ikov,", " Mbagba, ", "Mbaikyaa,", " Ushongo, "
            , "Utange Adoka,", " Akpa, ", "Oglewu,", " Onyan-Gede,", " Edumogan", " Ichama, ", "Okpoga, Orokam, ", "Otukpa, ", "Owukpa,",
            " Ahmadu Bello,", " Ella Market,", " G.R.A, ", "General Hospital", "Local Government Clinic,", " Ministry of Works, ", " New Market,"
            , "No. Cross, Ochido,", " Ogwonogba, ", "OOL, Post Office", " Rail Way Station,", " Rice Mill, ", "Sabon Gari,", " Ipav,",
            " Kusuv, ", "Mbagen, ", " Mbakor,", " Mbalagh,", " Mbatiav, ", "Mbatierev", "Mbayion",
            " Shorov, ", "Utur, ", "Yandev,", " Mbaduku,", " Mbagbera,", "Mbaka-Ange, ", " Mbara, ", " Mbayongo,", " Mingev,", " Tsambe,",
            " Ute Ochekwu"};

    String msgBody, address, subject;
    EditText message;
    TextView lGAName;
    String lGA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);


        lGAName = (TextView) findViewById(R.id.msgWelcome);
        // ImageView imageLogo = (ImageView)findViewById(R.id.imageLogo);
        message = (EditText) findViewById(R.id.zoneAreportField);
        Button sendBtn = (Button) findViewById(R.id.zoneAbtn);
        addrWard = (AutoCompleteTextView) findViewById(R.id.zoneAaddrField);

        spinner = (Spinner) findViewById(R.id.spinnerA);

        adapter = new ArrayAdapter<String>(ReportA.this, android.R.layout.simple_spinner_dropdown_item, crimeType);
        spinner.setAdapter(adapter);
        // wards adapter
        wards = new ArrayAdapter<String>(ReportA.this, android.R.layout.simple_list_item_1, wardList);

        addrWard.setAdapter(wards);
        lGA = getIntent().getStringExtra("LG");
        lGAName.setText("Hello " + lGA + " LGA, You Can Now Report");
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }

            private void sendMail() {
                //String msgBody =
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pressforabuja@police.gov.ng"});
                if (message.getText().toString().trim().equals("") || addrWard.getText().toString().trim().equals("")) {
                    Toast.makeText(ReportA.this, "Message Body OR\nDistrict name is empty..", Toast.LENGTH_SHORT).show();
                } else {
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, spinner.getSelectedItem().toString() + " In " + addrWard.getText().toString() + "  " +
                            "Destrict in " + lGA + " LGA");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString().trim());

                    emailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailIntent, "choose Email App"));
                }
            }


        });


    }
}

