package org.neriko.catalog.resource_models.product_offering;

public class BundledProductOffering {
    private String id; //A string. Unique identifier of the BundledProductOffering.
    private String href; //A string. Unique reference of the BundledProductOffering.
    private String lifecycleStatus; //A string. Used to indicate the current lifecycle status.
    private String name; //A string. Name of the BundledProductOffering.
    private BundledProdOfferOption bundledProductOfferingOption; /*A bundled product offer option
                                                                   (BundledProdOfferOption). A set of numbers that
                                                                   specifies the lower and upper limits for a
                                                                   ProductOffering that can be procured as part of the
                                                                   related BundledProductOffering. Values can range from
                                                                   0 to unbounded.*/
}
