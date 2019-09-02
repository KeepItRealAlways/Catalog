package org.neriko.catalog.resource_models.product_offering_price;

import org.neriko.catalog.resource_models.*;

import java.util.List;

public class ProductOfferingPrice {
    private String id;
    private String href;
    private String name;
    private String description;
    private String version;
    private TimePeriod validFor;
    private String priceType;
    private Quantity unitOfMeasure;
    private String recurringChargeTimePeriodType;
    private int recurringChargeTimePeriodLength;
    private String atype;
    private String abaseType;
    private String aschemaLocatrion;
    private DateTime lastUpdate;
    private boolean isBundle;
    private String lifecycleStatus;
    private Money price;
    private float percentage;
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    private List<ProdSpecCharValueUse> prodSpecCharValueUse;
    private List<ProductOfferingTerm> productOfferingTerm;
    private List<Tax> tax;
    private List<ConstraintRef> constraintRef;
    private List<PlaceRef> place;
    private List<BundledPopRelationship> bundledPopRelationship;
    private List<PopRelationship> popRelationship;
}
