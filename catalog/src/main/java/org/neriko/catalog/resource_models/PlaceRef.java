package org.neriko.catalog.resource_models;

public class PlaceRef {
    private String href; //A string. Unique reference of the place.
    private String id; //A string. Unique identifier of the place.
    private String name; /*A string. A user-friendly name for the place, such as "Paris Store",
                           "London Store", "Main Home".*/
    private String geoLocationUrl; //A sring (Sring). A url providing a map for localizing the place.
    private String address; /*A string. A string characterizing an address (for instance a formatted
                            address or an identifier taken from an address database or an
                            address API).*/
    private String role; //A string. Role of the place (for instance: 'home delivery', 'shop retrieval').
    private String areferredType; //a == @ A string. class type of the referred Place object
}
