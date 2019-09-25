package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "prod_offer")
public class ProductOffering {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "href")
    private String href;

    @Column(name="last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    @Column(name = "version")
    private String version;

    @Column(name = "lifecycle_status")
    private String lifecycleStatus;

    @Column(name = "valid_for_begin")
    private Timestamp validForBegin;

    @Column(name = "valid_for_end")
    private Timestamp validForEnd;

    @Column(name = "parent_category")
    private String parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "prod_spec", referencedColumnName = "id")
    private ProductSpecification productSpecification;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "po_msr",
            joinColumns = { @JoinColumn(name = "prod_offer") },
            inverseJoinColumns = { @JoinColumn(name = "market_segment_ref") }
    )
    Set<MarketSegmentRef> marketSegmentRefSet = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "po_p",
            joinColumns = { @JoinColumn(name = "prod_offer") },
            inverseJoinColumns = { @JoinColumn(name = "place") }
    )
    Set<Place> placeSet = new HashSet<>();

    //ToDo Place M-t-M
    //ToDo ProdSpecCharValueUse M-t-M
}
