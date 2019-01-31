package com.example.baller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BallerAddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baller_add_new);
    }

    public void onAddButtonPressed(View v)
    {
        EditText firstNameET = (EditText)this.findViewById(R.id.firstNameET);
        EditText lastNameET = (EditText)this.findViewById(R.id.lastNameET);
        EditText jerseyNumberET = (EditText)this.findViewById(R.id.jerseyNumberET);
        EditText ageET = (EditText)this.findViewById(R.id.ageET);
        EditText height_feetET = (EditText)this.findViewById(R.id.height_feetET);
        EditText height_inchesET = (EditText)this.findViewById(R.id.height_inchesET);

        String fname = firstNameET.getText().toString();
        String lname = lastNameET.getText().toString();
        int jerseyNumber = Integer.parseInt(jerseyNumberET.getText().toString());
        int age = Integer.parseInt(ageET.getText().toString());
        int htft = Integer.parseInt(height_feetET.getText().toString());
        int htin = Integer.parseInt(height_inchesET.getText().toString());
        Baller ball = new Baller(fname, lname, jerseyNumber, age, htft, htin);
        ball.display();
    }
}
