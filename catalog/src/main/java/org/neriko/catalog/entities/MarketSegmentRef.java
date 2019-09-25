package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "market_segment_ref")
public class MarketSegmentRef {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "marketSegmentRefSet")
    private Set<ProductOffering> productOfferingSet = new HashSet<>();
}
