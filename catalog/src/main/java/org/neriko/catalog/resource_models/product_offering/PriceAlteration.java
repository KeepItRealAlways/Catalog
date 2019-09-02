package org.neriko.catalog.resource_models.product_offering;

import org.neriko.catalog.resource_models.TimePeriod;

public class PriceAlteration {
    private String name; //A string. A short descriptive name such as "Monthly discount"
    private String description; /*A string. A narrative that explains in detail the semantics of this
                                  order item price alteration.*/
    private String priceType; //A string. A category that describes the price such as recurring, one time and usage.
    private String unitOfMeasure; //A string. Could be minutes, GB...
    private String recurringChargeTimePeriod; //A string. Could be month, week...
    private int applicationDuration; /*An integer. Duration during which the alteration applies on the
                                        order item price (for instance 2 months free of charge for the
                                        recurring charge).*/
    private int priority; /*An integer. Priority level for applying this alteration among all the defined
                            alterations on the order item price.*/
    private String priceCondition; //A string. Condition that triggers the price application
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod for which the price alteration is valid
    private Price price; /*A price (Price). Provides all amounts (tax included, duty free, tax
                           rate), used currency and percentage to apply for Price Alteration.*/
}
