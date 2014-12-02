package com.gamepari.sootah.images;

import android.location.Address;

import com.gamepari.sootah.location.Places;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Locale;

/**
 * Created by seokceed on 2014-11-23.
 */
public class PhotoMetaData {

    public static final int ADDRESS_FROM_PLACESAPI = 1234;
    public static final int ADDRESS_FROM_GEOCODE = 4543;
    public static final int ADDRESS_NONE = 2394;

    private int addressType = ADDRESS_NONE;

    private int orientation_degree;
    private String filePath;

    private LatLng latLng;
    private Address address;
    private List<Places> placesList;
    private Places confirmedPlace;

    public Places getConfirmedPlace() {
        return confirmedPlace;
    }

    public void setConfirmedPlace(Places confirmedPlace) {
        this.confirmedPlace = confirmedPlace;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public List<Places> getPlacesList() {
        return placesList;
    }

    public void setPlacesList(List<Places> placesList) {
        this.placesList = placesList;
    }

    public int getOrientation_degree() {
        return orientation_degree;
    }

    public void setOrientation_degree(int orientation_degree) {
        this.orientation_degree = orientation_degree;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddressString() {

        Locale userLocale = Locale.getDefault();
        String addressStr = "";

        if (userLocale.equals(Locale.KOREA)) {
            addressStr += address.getAdminArea() + " " + address.getLocality() + " "
                    + address.getThoroughfare() + " " + address.getSubThoroughfare();
        } else {
            addressStr = address.getLocality() + ", " + addressStr;
            if (address.getThoroughfare() != null && !address.getThoroughfare().equals("Unnamed Rd")) {
                addressStr = address.getThoroughfare() + ", " + addressStr;
                if (address.getSubThoroughfare() != null && !address.getSubThoroughfare().equals("Unnamed Rd")) {
                    addressStr = address.getSubThoroughfare() + " " + addressStr;
                }
            }
        }

        return addressStr;
    }

    public void clearPlaceData() {
        latLng = null;
        addressType = ADDRESS_NONE;
        address = null;
        if (placesList != null) placesList.clear();
        placesList = null;
        confirmedPlace = null;
    }


}
