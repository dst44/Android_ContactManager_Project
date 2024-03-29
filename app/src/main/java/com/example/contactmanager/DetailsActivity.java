package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView detsName, detsPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detsName = findViewById(R.id.dets_name);
        detsPhone = findViewById(R.id.dets_phone);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            String name = bundle.getString("name");
            String num = bundle.getString("phone");

            detsName.setText(name);
            detsPhone.setText(num);
        }


    }
}
