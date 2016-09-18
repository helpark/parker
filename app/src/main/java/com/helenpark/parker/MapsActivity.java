package com.helenpark.parker;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ListView suggestionsListview;
    private SuggestionsAdapter adapter;
    private SlidingUpPanelLayout slidingLayout;
    private ArrayList<ParkingLot> suggestionResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Setting the listview of suggestions
        suggestionsListview = (ListView) findViewById(R.id.suggestionsListview);
        //slidingLayout.setScrollableView(suggestionsListview);
        // TODO: suggestionResults should give parking lot suggestions in the array in the form of array of objects,
        // TODO: must write the logic for this elsewhere and populate list with this information -> suggestionResults rn is dummy, delete this!
        ParkingLot p1 = new ParkingLot("406 Oakwood Avenue", 43.688069, -79.439317, new ArrayList(), new ArrayList());
        suggestionResults.add(p1);
        adapter = new SuggestionsAdapter(this, suggestionResults);
        suggestionsListview.setAdapter(adapter);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //TODO: Add tonys data here, and make markers

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }




}
