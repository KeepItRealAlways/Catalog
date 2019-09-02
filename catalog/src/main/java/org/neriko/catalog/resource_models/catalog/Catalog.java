package org.neriko.catalog.resource_models.catalog;

import lombok.Data;
import org.neriko.catalog.resource_models.CategoryRef;
import org.neriko.catalog.resource_models.DateTime;
import org.neriko.catalog.resource_models.RelatedPartyRef;
import org.neriko.catalog.resource_models.TimePeriod;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id; //Unique identifier of the catalog

    @Column(name = "href")
    private String href; //Reference of the catalog

    @Column(name = "version")
    private String version; //Catalog version

    @Column(name = "lastUpdate")
//    private DateTime lastUpdate; //Date and time of the last update
    private Timestamp lastUpdate;

//    private String type; //Used to indicate the current lifecycle status

    @Column(name = "name")
    private String name; //Name of the catalog
//    private String lifecycleStatus; //Used to indicate the current lifecycle status
//    private TimePeriod validFor; //The TimePeriod for which the catalog is valid
//
//    private String atype = "ProductCatalog"; //Indicates the (class) type of catalog. For entity catalogs, this will be ‘ProductCatalog’.
//    private String abaseType = ""; //a == @ Indicates the base type of this catalog
//    private String aschemaLocation = ""; //a == @ This field provides a link to the schema describing this REST resource
//
//    private List<CategoryRef> category;
//    private List<RelatedPartyRef> relatedParty;
}
