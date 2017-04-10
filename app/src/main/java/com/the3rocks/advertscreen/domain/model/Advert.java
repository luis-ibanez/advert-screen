package com.the3rocks.advertscreen.domain.model;

import java.util.List;

public final class Advert {

    private long id;
    private boolean isFavourite;
    private String price;
    private String address;
    private boolean isLocated;
    private float latitude;
    private float longitude;
    public String mapImageUrl;
    private List<String> pictures;
    private String url;
    private String title;
    private String email;
    private String phone;
    private String sms;
    private String description;
    private String name;
    private String postingSince;
    private List<Attribute> attributes;

    public Advert(long id, boolean isFavourite, String price, String address, boolean isLocated, float latitude, float longitude, String mapImageUrl, List<String> pictures, String url, String title, String email, String phone, String sms, String description, String name, String postingSince, List<Attribute> attributes) {
        this.id = id;
        this.isFavourite = isFavourite;
        this.price = price;
        this.address = address;
        this.isLocated = isLocated;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapImageUrl = mapImageUrl;
        this.pictures = pictures;
        this.url = url;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.sms = sms;
        this.description = description;
        this.name = name;
        this.postingSince = postingSince;
        this.attributes = attributes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostingSince() {
        return postingSince;
    }

    public void setPostingSince(String postingSince) {
        this.postingSince = postingSince;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public boolean isLocated() {
        return isLocated;
    }

    public void setLocated(boolean located) {
        isLocated = located;
    }

    public String getMapImageUrl() {
        return mapImageUrl;
    }

    public void setMapImageUrl(String mapImageUrl) {
        this.mapImageUrl = mapImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return id == advert.getId();
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).hashCode();
    }

    @Override
    public String toString() {
        return "Advert with id " + id;
    }
}

