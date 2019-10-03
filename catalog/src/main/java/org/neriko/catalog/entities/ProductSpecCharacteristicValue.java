package org.neriko.catalog.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "prod_spec_char_val")
public class ProductSpecCharacteristicValue {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private boolean isDefault; //A boolean. Indicates if the value is the default value for a characteristic.

    @Column
    private String unitOfMeasure; //A string. Could be minutes, GB...

    @Column
    private Timestamp validForBegin; //A time TimePeriod. The TimePeriod of time for which a value is applicable.

    @Column
    private Timestamp validForEnd; //A time TimePeriod. The TimePeriod of time for which a value is applicable.

    @Column(name = "val")
    private String value; /*A discrete value that the characteristic can take on. The type of
                            value is determined by ‘valueType’ characteristic.*/

    @Column(name = "val_from")
    private String valueFrom; //A string. The low range value that a characteristic can take on.

    @Column(name = "val_to")
    private String valueTo; //A string. The upper range value that a characteristic can take on.

    @Column(name = "val_type")
    private String valueType; /*A string. A kind of value that the characteristic can take on, such as
                                numeric, text, and so forth.*/

    @Column
    private String rangeInterval; /*A string. An indicator that specifies the inclusion or exclusion of the
                                    valueFrom and valueTo attributes. If applicable, possible values are
                                    "open", "closed", "closedBottom" and "closedTop".*/

    @Column
    private String regex; //A string. Regular expression to define constraint on the allowed value.
}
