package org.neriko.catalog.resource_models.product_offering;

public class BundledProdOfferOption {
    private int numberRelOfferLowerLimit; /*An integer. lower limit for a product offering that can be
                                            procured as part of the related BundledProductOffering.*/
    private int numperRelOfferUpperLimit; /*An integer. upper limit for a product offering that can be
                                            procured as part of the related BundledProductOffering.*/
    private int numberRelOfferDefault; /*An integer. Default number of product offerings that should
                                         be procured as part of the related BundledProductOffering.*/
}
