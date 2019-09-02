package org.neriko.catalog.resource_models.category;

import org.neriko.catalog.resource_models.CategoryRef;
import org.neriko.catalog.resource_models.DateTime;
import org.neriko.catalog.resource_models.ProductOfferingRef;
import org.neriko.catalog.resource_models.TimePeriod;

import java.util.List;

public class Category {
    private String id; //A string. Unique identifier of the category.
    private String href; //A string. Reference of the category
    private DateTime lastUpdate; //Date and time of the last update
    private String version; //Category version
    private String lifecycleStatus; //Used to indicate the current lifecycle status
    private TimePeriod validFor; //The TimePeriod for which the category is valid
    private String parentId; //Unique identifier of the parent category
    private boolean isRoot; //If true, this Boolean indicates that the category is a root of categories
    private String name; //Name of the category
    private String description; //Description of the category
    private String atype; //a == @ A string. the class type of the Category.
    private String abaseType; //a == @ A string. the base class type of the category.
    private String aschemaLocation; //a == @ A string. link to the schema describing this category.
    private List<ProductOfferingRef> productOffering; /*A list of product offering references
                                                        (ProductOfferingRef [*]). A product offering represents
                                                        entities that are orderable from the provider of the
                                                        catalog, this resource includes pricing information.*/
    private List<CategoryRef> subCategory; /*A list of (sub-)category references (CategoryRef [*]).
                                            The category resource is used to group product
                                            offerings, service and resource candidates in logical
                                            containers. Categories can contain other (sub-)categories
                                            and/or product offerings.*/
}
