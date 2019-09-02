package org.neriko.catalog.resource_models.product_offering;

import org.neriko.catalog.resource_models.Money;

public class Price {
    private Money dutyFreeAmount; //A money (Money). All taxes excluded amount (expressed in the given currency).
    private float percentage; //A float. Percentage to apply for ProdOfferPriceAlteration.
    private Money taxIncludedAmount; //A money (Money). All taxes included amount (expressed in the given currency).
    private float taxRate; //A float. Tax rate.
}
