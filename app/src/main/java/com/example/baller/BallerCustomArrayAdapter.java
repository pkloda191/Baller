package com.example.baller;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BallerCustomArrayAdapter extends ArrayAdapter
{
    private Context mContext;
    private Baller[] ballerList = new Baller[100];
    private int textViewResourceId;

    public BallerCustomArrayAdapter(Context context, int textViewResourceId,
                                     Baller[] list)
    {
        super(context, textViewResourceId , list);
        mContext = context;
        ballerList = list;
        this.textViewResourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //android will re-use existing rows for performance reasons.
        //this checks to see if the convertView is already a thing or not
        //if it is not a thing, it inflates the layout for use this time
        //it will likely be a thing the next time we process this row.
        View listItem = convertView;
        if(listItem == null)
        {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId,parent,false);
        }

        //Get the PatientRecord object from bucket position which
        //is the row in our listview we are currently filling
        Baller ba = this.ballerList[position];

        TextView nameTV = (TextView)listItem.findViewById(R.id.nameTV);
        TextView ageTV = (TextView)listItem.findViewById(R.id.ageTV);
        TextView jerseyNumberTV = (TextView)listItem.findViewById(R.id.jerseyNumberTV);
        TextView heightTV = (TextView)listItem.findViewById(R.id.heightTV);


        nameTV.setText(ba.getFirst_name() + " " + ba.getLast_name());
        ageTV.setText("Age: " + ba.getAge());
        jerseyNumberTV.setText("#" + ba.getJersey_number());
        heightTV.setText(ba.getHeight_feet() + "'" + ba.getHeight_inches() + "\"");


        //return the View after we have set all of the values
        return listItem;
    }
}
