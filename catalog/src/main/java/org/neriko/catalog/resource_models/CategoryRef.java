package org.neriko.catalog.resource_models;

public class CategoryRef {
    private String id; //Unique identifier of the category
    private String href; //Reference of the catalog
    private String version; //Category version
    private String name; //Name of the category
    private String areferredType; //a == @ A string. the class type of the referred category.
}
