package com.the3rocks.advertscreen.datasource.local.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdLocal {

    @SerializedName("adId")
    public long id;

    @SerializedName("isFavourite")
    public boolean isFavourite;

    @SerializedName("price")
    public String price;

    @SerializedName("address")
    public String address;

    @SerializedName("isLocated")
    public boolean isLocated;

    @SerializedName("latitude")
    public float latitude;

    @SerializedName("longitude")
    public float longitude;

    @SerializedName("map_image_url")
    public String mapImageUrl;

    @SerializedName("pictures")
    public List<String> pictures;

    @SerializedName("url")
    public String url;

    @SerializedName("title")
    public String title;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;

    @SerializedName("sms")
    public String sms;

    @SerializedName("description")
    public String description;

    @SerializedName("name")
    public String name;

    @SerializedName("postingSince")
    public String postingSince;

    @SerializedName("attributes")
    public List<AttributeLocal> attributes;

    public long getId() {
        return id;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public String getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public boolean isLocated() {
        return isLocated;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getMapImageUrl() {
        return mapImageUrl;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSms() {
        return sms;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPostingSince() {
        return postingSince;
    }

    public List<AttributeLocal> getAttributes() {
        return attributes;
    }
}