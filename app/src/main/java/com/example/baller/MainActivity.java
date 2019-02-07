package com.example.baller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //System.out.println("****** ON RESUME!!!!!!");
        String stringOfAllBallers = Core.getBallers();
        String ballerListArray[] = stringOfAllBallers.split(",");
        String[] myBallers = {ballerListArray[0],ballerListArray[1],ballerListArray[2],ballerListArray[3],ballerListArray[4],ballerListArray[5]};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.list_view_row, myBallers);
        ListView lv = (ListView)this.findViewById(R.id.listView);
        lv.setAdapter(aa);
        lv.invalidateViews(); //this line forces a list view to refresh!!!! hint hint
    }


    public void onAddPatientRecordPressed(View v) {
        Intent i = new Intent(this, BallerAddNewActivity.class);
        this.startActivity(i);
    }
}

