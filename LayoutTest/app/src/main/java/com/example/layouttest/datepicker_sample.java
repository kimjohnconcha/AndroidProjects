package com.example.layouttest;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class datepicker_sample extends Activity {

    public TextView tvDisplayDate;
    public DatePicker dpResult;
    public Button btnChangeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker_sample);

        displayCurrentDateOnView();
        addListenerButton();
    }

    // display current date
    public  void displayCurrentDateOnView()
    {
        tvDisplayDate = (TextView)findViewById(R.id.tvDate);
        dpResult = (DatePicker)findViewById(R.id.dbResult);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        tvDisplayDate.setText(new StringBuilder()
        .append(month + 1).append("-").append(day).append("-").append(year).append(" "));

        dpResult.init(year, month, day, null);
    }

    public void addListenerButton()
    {
        btnChangeDate = (Button)findViewById(R.id.btnUpdateDate);

        //btnChangeDate.om

        btnChangeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {

            tvDisplayDate.setText(new StringBuilder().append(selectedMonth + 1).append("-").append(selectedDay).append("-").append(selectedYear).append(" "));

            dpResult.init(year, month, day,null);
        }
    };

}
