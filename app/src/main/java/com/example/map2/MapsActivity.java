package com.example.map2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng m1 = new LatLng(20,  40);

        marker = mMap.addMarker(new MarkerOptions()
                .position(m1)
                .draggable(true)
                .title("marker 1")
        );

        mMap.setOnMapClickListener(this);


      //  mMap.addMarker(new MarkerOptions().position(m1).title("Welcome here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        //When map is clicked
        Toast.makeText(this, "Map is clicked", Toast.LENGTH_LONG).show();

    }

//    @Override
//    public void onMarkerDragStart(Marker marker) {
//
//    }
//
//    @Override
//    public void onMarkerDrag(Marker marker) {
//
//    }
//
//    @Override
//    public void onMarkerDragEnd(Marker marker) {
//        //Getting the new position lat and lng
//        Toast.makeText(this, "lat:" + marker.getPosition().latitude
//                + "\nlng: " +marker.getPosition().longitude,
//        Toast.LENGTH_SHORT).show();
//
//    }

//    @Override
  //  public boolean onMarkerClick(Marker marker) {

   //     Toast.makeText(this, "My Latitude position: "+ marker.getPosition().latitude,
    //           Toast.LENGTH_LONG).show();

    //      return false;
   // }
}