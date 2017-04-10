package com.the3rocks.advertscreen.datasource.local;


import com.the3rocks.advertscreen.datasource.local.model.AdLocal;
import com.the3rocks.advertscreen.datasource.local.model.AttributeLineLocal;
import com.the3rocks.advertscreen.datasource.local.model.AttributeLocal;
import com.the3rocks.advertscreen.domain.model.Advert;
import com.the3rocks.advertscreen.domain.model.Attribute;
import com.the3rocks.advertscreen.domain.model.AttributeLine;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSourceParse {

    public static Advert parseAdLocal(AdLocal adLocal){

        List<Attribute> parsedAttributes = new ArrayList<>();
        for(AttributeLocal attributeLocal : adLocal.getAttributes()){
            List<AttributeLine> parsedAttributeLines = new ArrayList<>();
            for(AttributeLineLocal attributeLineLocal : attributeLocal.getAttributeLines()){
                AttributeLine parsedAttributeLineLocal = new AttributeLine(
                        attributeLineLocal.getLabel(),
                        attributeLineLocal.getText()
                );
                parsedAttributeLines.add(parsedAttributeLineLocal);
            }
            Attribute parsedAttributeLocal = new Attribute(
                    attributeLocal.getIcon(),
                    parsedAttributeLines
            );
            parsedAttributes.add(parsedAttributeLocal);
        }

        Advert parsedAdvertLocal = new Advert(
                adLocal.getId(),
                adLocal.isFavourite(),
                adLocal.getPrice(),
                adLocal.getAddress(),
                adLocal.isLocated(),
                adLocal.getLatitude(),
                adLocal.getLongitude(),
                adLocal.getMapImageUrl(),
                adLocal.getPictures(),
                adLocal.getUrl(),
                adLocal.getTitle(),
                adLocal.getEmail(),
                adLocal.getPhone(),
                adLocal.getSms(),
                adLocal.getDescription(),
                adLocal.getName(),
                adLocal.getPostingSince(),
                parsedAttributes
        );

        return parsedAdvertLocal;
    }
}
