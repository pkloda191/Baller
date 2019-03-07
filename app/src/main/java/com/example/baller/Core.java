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
    public static BallerCustomArrayAdapter aa;

    public static void listenForDatabaseChanges()
    {
        //async listener
        ValueEventListener prListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // Get Post object and use the values to update the UI
                Core.numBallers = 0;
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Baller ba = ds.getValue(Baller.class);
                    Core.addBallerLocal(ba);
                }
                Core.aa.notifyDataSetChanged();
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

    public static void writeBallerToFirebase(Baller ba)
    {
        //static context
        Core.myRef.push().setValue(ba);
    }

    public static void addBallerLocal(Baller ba)
    {
        //encapsulated the logic of adding patient records here
        Core.ballers[Core.numBallers] = ba;
        Core.theBallerStrings[Core.numBallers] = ba.toString();
        Core.numBallers++;
    }

    public static void addBallerDB(Baller ba)
    {
        Core.writeBallerToFirebase(ba);
    }

    public static String getBallers()
    {
        return Arrays.toString(ballers);
    }

}
