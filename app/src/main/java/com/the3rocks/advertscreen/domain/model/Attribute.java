package com.the3rocks.advertscreen.domain.model;



import java.util.List;

public class Attribute {

    private String icon;
    private List<AttributeLine> attributeLines;

    public Attribute(String icon, List<AttributeLine> attributeLines) {
        this.icon = icon;
        this.attributeLines = attributeLines;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<AttributeLine> getAttributeLines() {
        return attributeLines;
    }

    public void setAttributeLines(List<AttributeLine> attributeLines) {
        this.attributeLines = attributeLines;
    }
}
