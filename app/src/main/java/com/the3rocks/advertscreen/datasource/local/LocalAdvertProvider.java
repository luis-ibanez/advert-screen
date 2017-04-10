package com.the3rocks.advertscreen.datasource.local;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.the3rocks.advertscreen.datasource.local.model.AdLocal;
import com.the3rocks.advertscreen.domain.model.Advert;

import javax.inject.Inject;

public class LocalAdvertProvider {

    private static String jsonText = "" +
            "{\n" +
            "  \"adId\": 9805340664,\n" +
            "  \"isFavourite\": true,\n" +
            "  \"price\": \"$3,842.56\",\n" +
            "  \"address\": \"183 Dennett Place, Reinerton, Federated States Of Micronesia, 568\",\n" +
            "  \"latitude\": -89.464091,\n" +
            "  \"longitude\": -30.065909,\n" +
            "  \"isLocated\": true,\n" +
            "  \"map_image_url\": \"https://maps.googleapis.com/maps/api/staticmap?zoom=13&size=600x300&maptype=roadmap&markers=color:red%7C7C-89.464091,-30.065909&key=AIzaSyCN9Jx6qybB1VVnYw4LBaxaQ8RB_fmu2ZQ\",\n" +
            "  \"pictures\": [\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\",\n" +
            "    \"https://placebear.com/300/200\"\n" +
            "  ],\n" +
            "  \"url\": \"https://www.gumtree.com/p/skoda/2011-skoda-yeti-e-tdi-cr-with-new-alloys-tires-fully-valeted-new-mot-no-advisories/1226529400\",\n" +
            "  \"title\": \"2011 SKODA YETI E TDI CR WITH NEW ALLOYS TIRES FULLY VALETED NEW MOT NO ADVISORIES\",\n" +
            "  \"email\": \"reneboyle@pyramis.com\",\n" +
            "  \"phone\": \"+1 (992) 505-3855\",\n" +
            "  \"sms\": \"+1 (904) 495-3211\",\n" +
            "  \"description\": \"Aute aliquip proident tempor veniam culpa ex. Laboris velit cillum deserunt ex. Enim excepteur reprehenderit elit mollit fugiat veniam commodo consectetur eiusmod qui quis sint. Culpa deserunt voluptate id nisi ad tempor sint in dolor cupidatat cillum ea consectetur. Ex nisi ut duis mollit non voluptate id duis ex elit elit in. Anim culpa eiusmod officia exercitation non magna.\\r\\n\",\n" +
            "  \"name\": \"Luis\",\n" +
            "  \"postingSince\": \"Posting for 1+ years\",\n" +
            "  \"attributes\": [\n" +
            "    {\n" +
            "      \"attributeIcon\": \"http://placehold.it/64x64/FFC0CB\",\n" +
            "      \"attributeLines\": [\n" +
            "        {\n" +
            "          \"attributeLabel\": \"irure\",\n" +
            "          \"attributeText\": \"qui\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"qui\",\n" +
            "          \"attributeText\": \"exercitation\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"culpa\",\n" +
            "          \"attributeText\": \"ullamco\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"minim\",\n" +
            "          \"attributeText\": \"enim\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"veniam\",\n" +
            "          \"attributeText\": \"quis\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"irure\",\n" +
            "          \"attributeText\": \"qui\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"qui\",\n" +
            "          \"attributeText\": \"exercitation\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"culpa\",\n" +
            "          \"attributeText\": \"ullamco\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"minim\",\n" +
            "          \"attributeText\": \"enim\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"attributeLabel\": \"veniam\",\n" +
            "          \"attributeText\": \"quis\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private Gson gson;

    @Inject
    public LocalAdvertProvider(Gson gson) {
        this.gson = gson;
    }

    public Advert getAdvert(){
        AdLocal advertLocal = gson.fromJson(jsonText, AdLocal.class);
                                                                                                                                                                                                           return LocalDataSourceParse.parseAdLocal(advertLocal);
    }
}
