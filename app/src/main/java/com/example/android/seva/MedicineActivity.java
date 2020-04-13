package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
    }

    boolean checkCough = false;
    boolean checkCold = false;
    boolean checkFever = false;
    boolean checkHeadache = false;
    boolean checkPainkiller = false;
    boolean checkLoosemotion = false;
    boolean checkAntibiotics = false;
    String name = "";
    String phnNo="";
    String address="";
    String description="";
    public void order(View view) {
        EditText namee = (EditText) findViewById(R.id.name_add);
        name = namee.getText().toString();

        EditText phoneNo= (EditText) findViewById(R.id.phnNo_add);
        phnNo = phoneNo.getText().toString();

        EditText adrs = (EditText) findViewById(R.id.address_add);
        address = adrs.getText().toString();

        EditText desc = (EditText) findViewById(R.id.desc_add);
        description = desc.getText().toString();

        CheckBox cough= (CheckBox) findViewById(R.id.cough_CheckBox);
        checkCough =cough.isChecked();

        CheckBox cold = (CheckBox) findViewById(R.id.cold_CheckBox);
        checkCold = cold.isChecked();

        CheckBox fever = (CheckBox) findViewById(R.id.fever_CheckBox);
        checkFever = fever.isChecked();

        CheckBox headache = (CheckBox) findViewById(R.id.headache_CheckBox);
        checkHeadache = headache.isChecked();

        CheckBox painkiller = (CheckBox) findViewById(R.id.painkiller_CheckBox);
        checkPainkiller = painkiller.isChecked();

        CheckBox loosemotion = (CheckBox) findViewById(R.id.loosemotion_CheckBox);
        checkLoosemotion = loosemotion.isChecked();

        CheckBox antibiotics = (CheckBox) findViewById(R.id.antibiotic_CheckBox);
        checkAntibiotics = antibiotics.isChecked();

        createOrderSummary();
    }

    public void createOrderSummary() {

        String s = "Name: " + name + "\nPhone No: " + phnNo + "\n\nADDRESS: \n" + address + "\n";
        int i=1;

        if (checkCough == true) {
            s = s + "\n" + i + ". Cough";
            i++;
        }

        if (checkCold == true) {
            s = s + "\n" + i  + ". Cold";
            i++;
        }

        if (checkFever == true) {
            s = s + "\n" + i + ". Fever";
            i++;
        }

        if (checkHeadache == true) {
            s = s + "\n" + i + ". Headache";
            i++;
        }

        if (checkPainkiller == true) {
            s = s + "\n" + i + ". Pain Killer";
            i++;
        }

        if (checkLoosemotion == true) {
            s = s + "\n" + i + ". Loose Motion";
            i++;
        }

        if (checkAntibiotics == true) {
            s = s + "\n" + i + ". Antibiotics";
            i++;
        }
        if(description.compareTo("")!=0)
            s = s + "\n\n"+ "SECONDARY NEED:" + "\n" + description;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,s);
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "shubhamkhatri234@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Medicine order for "+name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }}

