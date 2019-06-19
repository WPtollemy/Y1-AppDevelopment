package ptollemy.u1558457.will.rioolympicsevent;

/**
 * I have a class called GPSTracker which is used to find the location of the user
 * it does this by implementing the LocationListener, I couldn't easily figure out
 * how to do this or implement it so I needed to research it to get help, and I found
 * this page http://stackoverflow.com/questions/17591147/how-to-get-current-location-in-android
 * in which I copied the code and it also helped me understand what is and how to use a
 * location listener
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public final class GPSTracker implements LocationListener {

    private final Context mapContext;

    // flag for GPS status
    public boolean isGPSEnabled = false;

    // flag for network status
    boolean networkEnabled = false;

    // flag for GPS status
    boolean canGetLocation = false;

    Location location; // location
    double lat; // latitude
    double lng; // longitude

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.mapContext = context;
        returnLocation();
    }

    /**
     * Function to get the user's current location
     *
     * @return
     */
    public Location returnLocation() {
        try {
            locationManager = (LocationManager) mapContext.getSystemService(Context.LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            Log.v("isGPSEnabled", "=" + isGPSEnabled);

            // getting network status
            networkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            Log.v("networkEnabled", "=" + networkEnabled);

            if (isGPSEnabled == false && networkEnabled == false) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true;
                if (networkEnabled) {
                    location=null;
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            lat = location.getLatitude();
                            lng = location.getLongitude();
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    location=null;
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                lat = location.getLatitude();
                                lng = location.getLongitude();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    /**
     * Stop using GPS listener Calling this function will stop using GPS in your
     * app
     * */
    public void stopUsingGPS() {
        if (locationManager != null) {
            locationManager.removeUpdates(GPSTracker.this);
        }
    }

    /**
     * Function to get latitude
     * */
    public double getLatitude() {
        if (location != null) {
            lat = location.getLatitude();
        }

        // return latitude
        return lat;
    }

    /**
     * Function to get longitude
     * */
    public double getLongitude() {
        if (location != null) {
            lng = location.getLongitude();
        }

        // return longitude
        return lng;
    }

    /**
     * Function to check GPS/wifi enabled
     *
     * @return boolean
     * */
    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    @Override
    public void onLocationChanged(Location location) {
        //Do nothing
    }

    @Override
    public void onProviderDisabled(String provider) {
        //Do nothing
    }

    @Override
    public void onProviderEnabled(String provider) {
        //Do nothing
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //Do nothing
    }

}