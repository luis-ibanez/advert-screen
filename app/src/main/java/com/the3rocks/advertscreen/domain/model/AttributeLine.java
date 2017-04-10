package com.the3rocks.advertscreen.domain.model;


import com.google.gson.annotations.SerializedName;

public class AttributeLine {
    private String label;
    private String text;

    public AttributeLine(String label, String text) {
        this.label = label;
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
