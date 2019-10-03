package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "prod_offer")
public class ProductOffering {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prod_offer_id;

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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_fk")
    private CategoryRef category;

    @ManyToOne
    @JoinColumn(name = "prod_spec_fk")
    private ProductSpecification productSpecification;

    @ManyToMany
    @JoinTable(
            name = "po_msr",
            joinColumns = { @JoinColumn(name = "prod_offer_fk") },
            inverseJoinColumns = { @JoinColumn(name = "market_segment_ref_fk") }
    )
    Set<MarketSegmentRef> marketSegmentRefSet = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "po_p",
            joinColumns = { @JoinColumn(name = "prod_offer_fk") },
            inverseJoinColumns = { @JoinColumn(name = "place_fk") }
    )
    Set<Place> placeSet = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "po_c",
            joinColumns = { @JoinColumn(name = "prod_offer_fk") },
            inverseJoinColumns = { @JoinColumn(name = "channel_fk") }
    )
    Set<Channel> channelSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "prod_offer_fk")
    Set<ProductOfferingPrice> productOfferingPriceSet;

    @ManyToMany
    @JoinTable(
            name = "pscvu_po",
            joinColumns = { @JoinColumn(name = "prod_spec_char_val_use_fk") },
            inverseJoinColumns = { @JoinColumn(name = "prod_offer_fk") }
    )
    Set<ProdSpecCharValueUse> prodSpecCharValueUseSet = new HashSet<>();
}
