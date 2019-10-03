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
@Table(name="catalog")
public class Catalog {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String catalog_id; //Unique identifier of the catalog

    @Column(name="href")
    private String href; //Reference of the catalog

    @Column(name="version")
    private String version; //Catalog version

    @Column(name="last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    @Column(name="type")
    private String type;

    @Column(name="name")
    private String name; //Name of the catalog

    @Column(name="lifecycle_status")
    private String lifecycleStatus; //Used to indicate the current lifecycle status

    @Column(name="valid_for_begin")
    private Timestamp validForBegin; //The TimePeriod for which the catalog is valid

    @Column(name="valid_for_end")
    private Timestamp validForEnd;

    @ManyToMany
    @JoinTable(
            name = "c_rpr",
            joinColumns = { @JoinColumn(name = "related_party_ref_fk") },
            inverseJoinColumns = { @JoinColumn(name = "catalog_fk") }
    )
    Set<RelatedPartyRef> relatedPartyRefSet = new HashSet<>();
}
