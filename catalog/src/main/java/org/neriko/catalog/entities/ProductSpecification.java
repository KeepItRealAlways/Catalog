package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "prod_spec")
public class ProductSpecification {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; //A string. Unique identifier of the category.

    @Column(name = "href")
    private String href; //A string. Reference of the category

    @Column(name="last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate; //Date and time of the last update

    @Column(name = "lifecycle_status")
    private String lifecycleStatus; //Used to indicate the current lifecycle status

    @Column(name = "valid_for_begin")
    private Timestamp validForBegin; //The TimePeriod for which the category is valid

    @Column(name = "valid_for_end")
    private Timestamp validForEnd; //The TimePeriod for which the category is valid

    @Column(name = "parent_category")
    private String parentId; //Unique identifier of the parent category

    @Column(name = "name")
    private String name; //Name of the category

    @Column(name = "description")
    private String description; //Description of the category

    @Column(name = "brand")
    private String brand; //Description of the category

    @Column(name = "prodnumber")
    private String productNumber; //Description of the category

    @ManyToOne
    @JoinColumn(name = "catalog", referencedColumnName = "id")
    private Catalog catalog;

    //ToDo prodSpecValUse M-t-O
    //ToDo relatedPartyRef M-t-M
}
