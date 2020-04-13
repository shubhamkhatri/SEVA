package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    boolean checkFlour = false;
    boolean checkRice = false;
    boolean checkDal = false;
    boolean checkMilk = false;
    boolean checkSugar = false;
    boolean checkSpices = false;
    boolean checkVegetables = false;
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

        CheckBox floor= (CheckBox) findViewById(R.id.flour_CheckBox);
        checkFlour =floor.isChecked();

        CheckBox rice = (CheckBox) findViewById(R.id.rice_CheckBox);
        checkRice = rice.isChecked();

        CheckBox dal = (CheckBox) findViewById(R.id.dal_CheckBox);
        checkDal = dal.isChecked();

        CheckBox milk = (CheckBox) findViewById(R.id.milk_CheckBox);
        checkMilk = milk.isChecked();

        CheckBox sugar = (CheckBox) findViewById(R.id.sugar_CheckBox);
        checkSugar = sugar.isChecked();

        CheckBox spices = (CheckBox) findViewById(R.id.spices_CheckBox);
        checkSpices = spices.isChecked();

        CheckBox vegetables = (CheckBox) findViewById(R.id.veg_CheckBox);
        checkVegetables = vegetables.isChecked();

        createOrderSummary();
    }

    public void createOrderSummary() {

        String s = "Name: " + name + "\nPhone No: " + phnNo + "\n\nADDRESS: \n" + address + "\n";
        int i=1;

        if (checkFlour == true) {
            s = s + "\n" + i + ". Flour";
            i++;
        }

        if (checkRice == true) {
            s = s + "\n" + i  + ". Rice";
            i++;
        }

        if (checkDal == true) {
            s = s + "\n" + i + ". Dal";
            i++;
        }

        if (checkMilk == true) {
            s = s + "\n" + i + ". Milk";
            i++;
        }

        if (checkSugar == true) {
            s = s + "\n" + i + ". Sugar";
            i++;
        }

        if (checkSpices == true) {
            s = s + "\n" + i + ". Spices";
            i++;
        }

        if (checkVegetables == true) {
            s = s + "\n" + i + ". Vegetables";
            i++;
        }
        if(description.compareTo("")!=0)
        s = s + "\n\n"+ "SECONDARY NEED:" + "\n" + description;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,s);
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "shubhamkhatri234@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Food order for "+name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

}}
