package com.the3rocks.advertscreen.datasource.local.model;


import com.google.gson.annotations.SerializedName;

public class AttributeLineLocal {

    @SerializedName("attributeLabel")
    public String label;

    @SerializedName("attributeText")
    public String text;

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }
}
