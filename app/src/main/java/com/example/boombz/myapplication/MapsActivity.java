package com.example.boombz.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boombz.myapplication.Models.Estrada;
import com.example.boombz.myapplication.Models.EstradasResponse;
import com.example.boombz.myapplication.Modules.DirectionFinder;
import com.example.boombz.myapplication.Modules.DirectionFinderListener;
import com.example.boombz.myapplication.Modules.Route;
import com.example.boombz.myapplication.app.App;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Call;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private GoogleMap mMap;
    private Button btnFindPath;
    private EditText etOrigin;
    private EditText etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    private List<Marker> ocorrenciasMarkers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnFindPath = (Button) findViewById(R.id.btnFindPath);
        etOrigin = (EditText) findViewById(R.id.etOrigin);
        etDestination = (EditText) findViewById(R.id.etDestination);

        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
        estradasProcessWithRetrofit();

    }

    private void sendRequest() {
        String origin = etOrigin.getText().toString();
        String destination = etDestination.getText().toString();

        if (origin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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

        // Add a marker in Prometeu and move the camera
        LatLng UM = new LatLng(41.5594118,-8.3975468);
        mMap.addMarker(new MarkerOptions().position(UM).title("Prometeu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(UM));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }

    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }


    public void estradasProcessWithRetrofit(){

        final Call<List<Estrada>> mService = App.getEstradasService().listEstradas();

        mService.enqueue(new Callback<List<Estrada>>() {
            @Override
            public void onResponse(Response<List<Estrada>> response, Retrofit retrofit) {
               // EstradasResponse response1 = EstradasResponse.parseJSON(response.body().toString());
                //Toast.makeText(MapsActivity.this, response1.toString(),Toast.LENGTH_LONG).show();
                //Log.d("e",response1.toString());

                Gson gson = new GsonBuilder().create();
                List<Estrada> estradas = response.body();
                for (Estrada res: estradas ) {
                    LatLng lnt = new LatLng(Double.parseDouble(res.getLat()),Double.parseDouble(res.getLon()));
                    BitmapDescriptor icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
                    if (res.getTipo().equals("Trabalhos")) {
                        icon = BitmapDescriptorFactory.fromResource(R.drawable.trabalhos);
                    }
                    if (res.getTipo().equals("Condicionamento")) {
                        icon = BitmapDescriptorFactory.fromResource(R.drawable.alert);
                    }
                    if (res.getTipo().equals("Outros")) {
                        icon = BitmapDescriptorFactory.fromResource(R.drawable.outros);
                    }
                    ocorrenciasMarkers.add(mMap.addMarker(new MarkerOptions()
                            .title(res.getTipo() + " - " + res.getConcelho())
                            .position(lnt)
                            .icon(icon)
                    ));
                }


/*
                EstradasResponse estradasResponse =  EstradasResponse.parseJSON(response.toString());




                Estrada[] users = gson.fromJson(response, Estrada[].class);
                System.out.println(Arrays.toString(users));
                //or since we know that there will be only one object in array
                System.out.println(users[0]);


                for (Estrada res: estradas ) {
                    System.out.println(res.toString());

                }
*/

                /*
                if(response!=null){
                     //EstradasResponse.parseJSON(response.body().toString());

                }
                */


            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MapsActivity.this,// "Please check your network connection and internet permission"+
                        "error"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("error",t.getMessage(),t);
            }
        });
    }

}
