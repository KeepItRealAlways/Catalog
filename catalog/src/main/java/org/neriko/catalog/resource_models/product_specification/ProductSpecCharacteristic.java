package org.neriko.catalog.resource_models.product_specification;

import org.neriko.catalog.resource_models.ProductSpecCharasteristicValue;
import org.neriko.catalog.resource_models.TimePeriod;

import java.util.List;

public class ProductSpecCharacteristic {
    private String name;
    private String description;
    private String valueType;
    private boolean configurable;
    private TimePeriod validFor;
    private String atype;
    private String aschemaLocation;
    private String avalueSchemaLocation;
    private int minCardinality;
    private int maxCardinality;
    private boolean isUnique;
    private String regex;
    private boolean extensible;
    private List<ProductSpecCharasteristicValue> productSpecCharasteristicValue;
    private List<ProductSpecCharRelationship> productSpecCharRelationship;
}
