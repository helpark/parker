package com.helenpark.parker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;


/**
 * Created by helenpark on 16-09-17.
 */
public class SuggestionsAdapter extends ArrayAdapter<ParkingLot> {
    private final Context context;
    private final ArrayList<ParkingLot> items;

    public SuggestionsAdapter(Context context, ArrayList<ParkingLot> items) {
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.suggestion, parent, false);
        TextView lotPrice = (TextView) rowView.findViewById(R.id.lotPrice);
        TextView lotDescription = (TextView) rowView.findViewById(R.id.lotDescription);
        ImageView lotImage = (ImageView) rowView.findViewById(R.id.lotImage);


        ParkingLot parkingLot = items.get(position);
        lotPrice.setText(String.valueOf(parkingLot.getCost()));
        lotDescription.setText(parkingLot.address);
        Picasso.with(this.context).load(parkingLot.getImage_url()).into(lotImage);

        return rowView;
    }
}

