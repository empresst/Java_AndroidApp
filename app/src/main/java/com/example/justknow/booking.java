package com.example.justknow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class booking extends AppCompatActivity {
    TextView bname,baddress,bcash,registered;
    Button confirm,bback,time,date;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bname = findViewById(R.id.med_name);
        baddress = findViewById(R.id.baddress);
        bcash = findViewById(R.id.med_price);
        registered = findViewById(R.id.registered);
        confirm = findViewById(R.id.add_cart_med);
        bback = findViewById(R.id.back_button_med);
        time=findViewById(R.id.timebutton);
        date=findViewById(R.id.datebutton);

        Intent it = getIntent();
        String name= it.getStringExtra("docname");
        String address= it.getStringExtra("docaddress");
        String cash= it.getStringExtra("docfees");
        bname.setText(name);
        baddress.setText(address);
        bcash.setText(cash);
        datepicker();
        timepicker();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registered.setText("APPOINTMENT BOOKED");
                startActivity(new Intent(booking.this,findmydoc.class));
            }

        });
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(booking.this,findmydoc.class));
            }
        });




    }
    private void datepicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);}

    private void timepicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay+":"+minute);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int mins = calendar.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK,timeSetListener,hour,mins,true);
    }
}