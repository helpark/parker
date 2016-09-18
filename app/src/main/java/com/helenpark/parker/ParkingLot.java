package com.helenpark.parker;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * Created by helenpark on 16-09-17.
 */
public class ParkingLot {

    String address;
    Double longitute;
    Double latitude;
    ArrayList<Boolean> paymentOptions = new ArrayList<>();
    String goggleAPI_streetViewKey = "AIzaSyBDle5FUKG1Uh1C_QO7S-kQIiV6VCa6G5o";
    String imageURL;

    // TODO: Change the pricing/timing to match Ming Lei's Data formatting
    ArrayList<Boolean> pricing = new ArrayList<>();

    public ParkingLot(String address, Double longitute, Double latitude, ArrayList paymentOptions, ArrayList pricing) {
        this.address = address;
        this.longitute = longitute;
        this.latitude = latitude;
        this.paymentOptions = paymentOptions;
        this.pricing = pricing;
    }

    public Double getCost() {
        // TODO: Write method to get current price based on time
        return 0.0;
    }

    public String getImage_url() {
        // TODO: finalise how big the picture should be, just a placeholder for now.
        imageURL = "https://maps.googleapis.com/maps/api/streetview?size=600x300&location=" + this.longitute + "," + this.latitude + "&key=AIzaSyBDle5FUKG1Uh1C_QO7S-kQIiV6VCa6G5o";
        Log.e("image URl: ", imageURL);
        /*
        try {
            JSONObject request = new JSONObject();
            request.put("size", "600x300");
            request.put("location", this.latitude + "," + this.longitute);
            request.put("key", "AIzaSyBDle5FUKG1Uh1C_QO7S-kQIiV6VCa6G5o");

            JsonObjectRequest HTTPrequest = new JsonObjectRequest(Request.Method.POST, "https://maps.googleapis.com/maps/api/streetview?", request,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            return response;
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
        } catch (JSONException J) {
            Log.d("LOGIN","FAIL");
        }
*/


        return imageURL;
    }
}
