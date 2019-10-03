package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "prod_spec_char_val_use")
public class ProdSpecCharValueUse {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prod_spec_char_val_use_id;

    @Column
    private String name; //A string. Name of the associated productSpecCharacteristic

    @Column
    private String description; //A string. A narrative that explains in detail what the productSpecCharacteristic is.

    @Column(name = "val_type")
    private String valueType; /*A string. A kind of value that the characteristic
                                value can take on, such as numeric, text and so forth.*/

    @Column
    private int minCardinality; /*An integer. The minimum number of instances a
                                CharacteristicValue can take on. For example, zero to
                                five phone numbers in a group calling plan, where zero
                                is the value for the minCardinality*/

    @Column
    private int maxCardinality; /*An integer. The maximum number of instances a
                                CharacteristicValue can take on. For example, zero to
                                five phone numbers in a group calling plan, where five is
                                the value for the maxCardinality.*/

    @Column
    private Timestamp validForBegin; //A time TimePeriod. The TimePeriod for which the productSpecCharacteristic is valid.

    @OneToMany
    @JoinColumn(name = "prod_spec_char_val_use_fk")
    Set<ProductSpecification> productSpecificationSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "prod_spec_char_val_use_fk")
    Set<ProductSpecCharacteristicValue> productSpecCharacteristicValueSet = new HashSet<>();
}
