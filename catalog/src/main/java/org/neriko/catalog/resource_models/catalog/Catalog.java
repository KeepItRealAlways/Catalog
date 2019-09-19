package org.neriko.catalog.resource_models.catalog;

import lombok.Data;
import org.neriko.catalog.resource_models.CategoryRef;
import org.neriko.catalog.resource_models.RelatedPartyRef;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class Catalog {

    private String id; //Unique identifier of the catalog
    private String href; //Reference of the catalog
    private String version; //Catalog version
    private Timestamp lastUpdate;
    private String type;
    private String name; //Name of the catalog
    private String lifecycleStatus; //Used to indicate the current lifecycle status
    private Timestamp validForBegin; //The TimePeriod for which the catalog is valid
    private Timestamp validForEnd;

    private String atype = "ProductCatalog"; //Indicates the (class) type of catalog. For entity catalogs, this will be ‘ProductCatalog’.
    private String abaseType = ""; //a == @ Indicates the base type of this catalog
    private String aschemaLocation = ""; //a == @ This field provides a link to the schema describing this REST resource

    private List<CategoryRef> category;
    private List<RelatedPartyRef> relatedParty;
}
