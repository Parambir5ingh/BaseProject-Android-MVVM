package com.prm.base_mvvm.ProjectUtils;

public class BaseLocation
{
    private String LocationName;
    private double latitude, longitude;

    public String getLocationName()
    {
        return LocationName;
    }

    public void setLocationName(String locationName)
    {
        LocationName = locationName;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }
}
