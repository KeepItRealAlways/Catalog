package org.neriko.catalog.resource_models.product_offering;

import org.neriko.catalog.resource_models.TimePeriod;

import java.util.List;

public class ProductOfferingPrice {
    private String name; //A string. Name of the productOfferingPrice.
    private String description; //A string. Description of the productOfferingPrice.
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod for which the productOfferingPrice is valid.
    private String priceType; /*A string. A category that describes the price, such as recurring,
                                discount, allowance, penalty, and so forth.*/
    private String unitOfMeasure; /*A string. A unit representing how an ProductOffering is available
                                    at the offered price. Its meaning depends on the priceType. It
                                    could be a price, a rate, or a discount. It Could be minutes, GB…*/
    private String recurringChargeTimePeriod; /*A string. The TimePeriod to repeat the application of the price
                                            Could be month, week...*/
    private String version; //A string. ProductOffering version.
    private String id; //A string. unique id of this POP.
    private String href; //A string. Hyperlink reference to the product offering price if it is exposed as a resource
    private String atype; //a == @ A string. The class type of this Product Offering Price (POP).
    private String abaseType; //a == @ A string. the immediate base class type of this product offering price (POP).
    private String aschemaLocation; //a == @ A string. hyperlink reference to the schema describing this POP
    private boolean isBundle; //A boolean. A flag indicating if this POP is composite (bundle) or not.
    private Price price; /*A sub-resource that provides all amounts (tax included, duty free,
                            tax rate), used currency and percentage to apply for Price
                            Alteration.*/
    private List<PriceAlteration> priceAlteration; /*A list of priceAlteration sub-resources (PriceAlteration [*]). A
                                                     priceAlteration object represents an amount, usually of money,
                                                     that modifies the price charged for an order item*/
}
