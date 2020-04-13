package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class WorkerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
    }

    boolean checkPlumber = false;
    boolean checkElectrician = false;
    boolean checkSweeper = false;
    boolean checkCarpenter = false;

    String name = "";
    String phnNo="";
    String description="";
    String address="";

    public void order(View view) {
        EditText namee = (EditText) findViewById(R.id.name_add);
        name = namee.getText().toString();

        EditText phoneNo= (EditText) findViewById(R.id.phnNo_add);
        phnNo = phoneNo.getText().toString();

        EditText adrs = (EditText) findViewById(R.id.address_add);
        address = adrs.getText().toString();

        EditText desc = (EditText) findViewById(R.id.desc_add);
        description = desc.getText().toString();

        CheckBox plumber= (CheckBox) findViewById(R.id.plumber_CheckBox);
        checkPlumber =plumber.isChecked();

        CheckBox electrician = (CheckBox) findViewById(R.id.electrician_CheckBox);
        checkElectrician = electrician.isChecked();

        CheckBox sweeper = (CheckBox) findViewById(R.id.sweeper_CheckBox);
        checkSweeper = sweeper.isChecked();

        CheckBox carpenter = (CheckBox) findViewById(R.id.carpenter_CheckBox);
        checkCarpenter = carpenter.isChecked();

        createOrderSummary();
    }

    public void createOrderSummary() {

        String s = "Name: " + name + "\nPhone No: " + phnNo + "\n\nADDRESS: \n" + address + "\n";;
        int i=1;

        if (checkPlumber == true) {
            s = s + "\n" + i + ". Plumber";
            i++;
        }

        if (checkElectrician == true) {
            s = s + "\n" + i  + ". Electrician";
            i++;
        }

        if (checkSweeper == true) {
            s = s + "\n" + i + ". Sweeper";
            i++;
        }

        if (checkCarpenter == true) {
            s = s + "\n" + i + ". Carpenter";
            i++;
        }
        if(description.compareTo("")!=0)
        s = s + "\n\n"+ "SECONDARY NEED:" + "\n" + description;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,s);
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "shubhamkhatri234@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Worker arrangement for "+name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }}

