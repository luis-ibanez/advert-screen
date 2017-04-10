package com.the3rocks.advertscreen.datasource.local.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttributeLocal {

    @SerializedName("attributeIcon")
    public String icon;

    @SerializedName("attributeLines")
    public List<AttributeLineLocal> attributeLines;

    public String getIcon() {
        return icon;
    }

    public List<AttributeLineLocal> getAttributeLines() {
        return attributeLines;
    }
}
