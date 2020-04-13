package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class DonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
    }
    boolean checkLunch = false;
    boolean checkDinner = false;

    String name = "";
    String phnNo="";
    String address="";
    String date="";
    String amount="";

    public void order(View view) {
        EditText namee = (EditText) findViewById(R.id.name_add);
        name = namee.getText().toString();

        EditText phoneNo= (EditText) findViewById(R.id.phnNo_add);
        phnNo = phoneNo.getText().toString();

        EditText adrs = (EditText) findViewById(R.id.address_add);
        address = adrs.getText().toString();

        EditText datee = (EditText) findViewById(R.id.date_add);
        date = datee.getText().toString();

        EditText amnt = (EditText) findViewById(R.id.amount_add);
        amount = amnt.getText().toString();


        CheckBox lunch= (CheckBox) findViewById(R.id.lunch_CheckBox);
        checkLunch =lunch.isChecked();

        CheckBox dinner = (CheckBox) findViewById(R.id.dinner_CheckBox);
        checkDinner = dinner.isChecked();


        createOrderSummary();
    }

    public void createOrderSummary() {

        String s = "Name: " + name + "\nPhone No: " + phnNo + "\n\nADDRESS: \n" + address + "\nDATE: " + date;


        if (checkLunch == true) {
            s = s + "\nLunch Availability for ";

        }

        if (checkDinner == true) {
            s = s + "\nDinner Availability for ";
                }


        if(amount.compareTo("")!=0)
            s = s + amount + " people.";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,s);
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "shubhamkhatri234@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Food Donation By "+name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }}
