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
@Table(name = "prod_spec")
public class ProductSpecification {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prod_spec_id;

    @Column(name = "href")
    private String href;

    @Column(name="last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

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

    @Column(name = "brand")
    private String brand;

    @Column(name = "prodnumber")
    private String productNumber;

    @ManyToMany
    @JoinTable(
            name = "ps_rpr",
            joinColumns = { @JoinColumn(name = "related_party_ref_fk") },
            inverseJoinColumns = { @JoinColumn(name = "prod_spec_fk") }
    )
    Set<RelatedPartyRef> relatedPartyRefSet = new HashSet<>();
}
