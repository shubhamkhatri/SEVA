package com.example.android.seva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void emailOne(View view){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "shubhamkhatri234@gmail.com" });
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        TextView textView= (TextView) findViewById(R.id.email_one);
        textView.setTextColor(Color.parseColor("#F44336"));

    }

    public void emailTwo(View view){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "sparshgoyal9@gmail.com" });
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        TextView textView= (TextView) findViewById(R.id.email_two);
        textView.setTextColor(Color.parseColor("#F44336"));

    }

    public void  phoneOne(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "9616488892"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        TextView textView= (TextView) findViewById(R.id.phone_one);
        textView.setTextColor(Color.parseColor("#F44336"));
    }

    public void  phoneTwo(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "8171341529"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        TextView textView= (TextView) findViewById(R.id.phone_two);
        textView.setTextColor(Color.parseColor("#F44336"));
    }

    public void  phoneThree(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "9876543210"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        TextView textView= (TextView) findViewById(R.id.phone_three);
        textView.setTextColor(Color.parseColor("#F44336"));
    }

}
