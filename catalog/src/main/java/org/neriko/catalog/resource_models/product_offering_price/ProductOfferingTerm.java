package org.neriko.catalog.resource_models.product_offering_price;

import org.neriko.catalog.resource_models.Quantity;
import org.neriko.catalog.resource_models.TimePeriod;

public class ProductOfferingTerm {
    private String name; //A string. Name of the productOfferingTerm.
    private String description; //A string. Description of the productOfferingTerm.
    private Quantity duration; //A quantity (Quantity). Duration of the productOfferingTerm.
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod for which the productOfferingTerm is valid.
    private String atype; //a == @ A string. The class type of ProductOfferingTerm
    private String aschemaLocation; //a == @ A string. A link to the schema describing this product offering term.
}
