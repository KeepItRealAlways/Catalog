package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "prod_spec_char")
public class ProductSpecCharacteristic {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prod_spec_char_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String valueType;

    @Column
    private Boolean configurable;

    @Column
    private Timestamp validForBegin;

    @Column
    private Timestamp validForEnd;

    @Column
    private Integer minCardinality;

    @Column
    private Integer maxCardinality;

    @Column
    private Boolean isUnique;

    @Column
    private String regex;

    @Column
    private Boolean extensible;
}
