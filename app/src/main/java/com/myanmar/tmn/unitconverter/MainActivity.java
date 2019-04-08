package com.myanmar.tmn.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

     Spinner fromSpinner,toSpinner;
     EditText fromEd, toEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.units,
                android.R.layout.simple_spinner_item);

        fromSpinner =  findViewById(R.id.sp_from);
        toSpinner = findViewById(R.id.sp_to);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

    }

    public void convert(View view){
        fromEd = findViewById(R.id.ed_from);
        toEd = findViewById(R.id.ed_to);

        String fromString = (String) fromSpinner.getSelectedItem();
        String toString = (String) toSpinner.getSelectedItem();
        double input = Double.valueOf(fromEd.getText().toString());

        Converter.Unit fromUnit = Converter.Unit.fromString(fromString);
        Converter.Unit toUnit = Converter.Unit.fromString(toString);

        Converter converter = new Converter(fromUnit, toUnit);
        double result = converter.convert(input);
        toEd.setText(String.valueOf(result));
    }
}
