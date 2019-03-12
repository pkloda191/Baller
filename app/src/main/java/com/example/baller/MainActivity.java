package com.example.baller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        System.out.println("*** Linked List Test");
        LinkedList ll = new LinkedList();
        ll.addFront(7);
        ll.addFront(2);
        ll.addEnd(6);
        ll.addEnd(93);
        ll.addEnd(8);
        //ll.removeFront();
        //ll.removeEnd();
        ll.removeAtIndex(2);
        ll.display();
        //initializes the array of Strings so there are place holder strings in there
        for(int i = 0; i < Core.ballers.length; i++)
        {
            Core.ballers[i] = new Baller();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Core.aa = new BallerCustomArrayAdapter(this, R.layout.list_view_row_advanced, Core.ballers);
        this.lv = (ListView)this.findViewById(R.id.listView);
        this.lv.setAdapter(Core.aa);

        //Start Listening for changes to the database
        Core.listenForDatabaseChanges(); //non-blocking!!!!
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Core.aa.notifyDataSetChanged();
    }

    public void onAddPatientRecordPressed(View v) {
        Intent i = new Intent(this, BallerAddNewActivity.class);
        this.startActivity(i);
    }
}

