package org.neriko.catalog.resource_models.product_specification;

import org.neriko.catalog.resource_models.*;

import java.util.List;

public class ProductSpecification {
    private String id;
    private String href;
    private String name;
    private String description;
    private String brand;
    private boolean isBundle;
    private DateTime lastUpdate;
    private String lifecycleStatus;
    private String productNumber;
    private TimePeriod validFor;
    private String version;
    private String atype;
    private String abaseType;
    private String aschemaLocation;
    private TargetProductSchemaRef targetProductSchema;
    private List<ResourceSpecificationRef> resourceSpecification;
    private List<ServiceSpecificationRef> serviceSpecification;
    private List<BundledProductSpecification> bundledProductSpecification;
    private List<ProductSpecCharacteristic> productSpecCharacterisitic;
    private List<ProductSpecificationRelationship> productSpecificationRelationship;
    private List<Attachment> attachment;
    private List<RelatedPartyRef> relatedParty;
}
