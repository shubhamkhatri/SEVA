package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFood(View view)
    {
        Intent i=new Intent(this,FoodActivity.class);
        startActivity(i);
    }

    public void openMedicine(View view)
    {
        Intent i=new Intent(this,MedicineActivity.class);
        startActivity(i);
    }
    public void openWorker(View view)
    {
        Intent i=new Intent(this,WorkerActivity.class);
        startActivity(i);
    }
    public void openDonation(View view)
    {
        Intent i=new Intent(this,DonationActivity.class);
        startActivity(i);
    }

    public void openContact(View view)
    {
        Intent i=new Intent(this,contactActivity.class);
        startActivity(i);
    }
    //created by shubham khatri
}
