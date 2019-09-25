package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "geolocation_url")
    private String geolocationUrl;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "placeSet")
    private Set<ProductOffering> productOfferingSet = new HashSet<>();

    //ToDo prod_offer_price m-t-m
}
