package ptollemy.u1558457.will.rioolympicsevent;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class GotoActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double lat;
    private double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);

        GPSTracker mGPS = new GPSTracker(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(mGPS.canGetLocation ){
            mGPS.returnLocation();
            lat = mGPS.getLatitude();
            lng = mGPS.getLongitude();
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

        // Add a marker in Sydney and move the camera
        LatLng you = new LatLng(lat, lng);
        LatLng rio = new LatLng(-22.9, -43.2);
        mMap.addMarker(new MarkerOptions().position(you).title("Marker at you"));
        mMap.addMarker(new MarkerOptions().position(rio).title("Marker in Rio"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(you));

        Polyline line = mMap.addPolyline(new PolylineOptions().
                    add(new LatLng(lat,lng),
                        new LatLng(-22.9,-43.2))
                    .width(5).color(Color.RED));
    }
}
