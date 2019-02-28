package com.example.baller;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Arrays;

public class Core
{
    public static Baller[] ballers = new Baller[100];
    public static String[] theBallerStrings = new String[100];
    private static int numBallers = 0;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("ballers");

    public static void listenForDatabaseChanges()
    {
        //async listener
        ValueEventListener prListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // Get Post object and use the values to update the UI
                System.out.println(dataSnapshot);
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Baller ba = ds.getValue(Baller.class);
                    System.out.println("***** Data Changed");
                    ba.display();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                // Getting Post failed, log a message
                System.out.println("loadPost:onCancelled " + databaseError.toException());
            }
        };
        Core.myRef.addValueEventListener(prListener);
    }

    public static void writePatientRecordToFirebase(Baller ba)
    {
        //static context
        Core.myRef.push().setValue(ba);
    }

    public static void addBaller(Baller ba)
    {
        //encapsulated the logic of adding patient records here
        Core.ballers[Core.numBallers] = ba;
        Core.theBallerStrings[Core.numBallers] = ba.toString();
        Core.numBallers++;
        Core.writePatientRecordToFirebase(ba);
    }

    public static String getBallers()
    {
        return Arrays.toString(ballers);
    }

}
