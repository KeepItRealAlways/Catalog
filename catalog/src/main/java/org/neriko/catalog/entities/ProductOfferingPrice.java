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
@Table(name = "prod_offer_price")
public class ProductOfferingPrice {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prod_offer_price_id;

    @Column(name="href")
    private String href;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="version")
    private String version;

    @Column(name="valid_for_begin")
    private Timestamp validForBegin;

    @Column(name="valid_for_end")
    private Timestamp validForEnd;

    @Column(name="price_type")
    private String priceType;

    @Column(name="unit_of_measure_amount")
    private Integer unitOfMeasureAmount;

    @Column(name="unit_of_measure_units")
    private String unitOfMeasureUnits;

    @Column(name="recurring_charge_period_type")
    private String recurringChargeTimePeriodType;

    @Column(name="recurring_charge_period_length")
    private Integer recurringChargeTimePeriodLength;

    @Column(name="last_update")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    @Column(name="lifecycle_status")
    private String lifecycleStatus;

    @Column(name="price_val")
    private Float priceValue;

    @Column(name="price_units")
    private String priceUnits;

    @Column(name="percentage")
    private Float percentage;

    @ManyToMany
    @JoinTable(
            name = "pop_p",
            joinColumns = { @JoinColumn(name = "prod_offer_price_fk") },
            inverseJoinColumns = { @JoinColumn(name = "place_fk") }
    )
    Set<Place> placeSet = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pscvu_pop",
            joinColumns = { @JoinColumn(name = "prod_spec_char_value_use_fk") },
            inverseJoinColumns = { @JoinColumn(name = "prod_offer_price_fk") }
    )
    Set<ProdSpecCharValueUse> prodSpecCharValueUseSet = new HashSet<>();
}
