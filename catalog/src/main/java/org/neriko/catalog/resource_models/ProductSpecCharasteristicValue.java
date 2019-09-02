package org.neriko.catalog.resource_models;

public class ProductSpecCharasteristicValue {
    private boolean isDefault; //A boolean. Indicates if the value is the default value for a characteristic.
    private String unitOfMeasure; //A string. Could be minutes, GB...
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod of time for which a value is applicable.
    private Object value; /*A discrete value that the characteristic can take on. The type of
                            value is determined by ‘valueType’ characteristic.*/
    private String valueFrom; //A string. The low range value that a characteristic can take on.
    private String valueTo; //A string. The upper range value that a characteristic can take on.
    private String valueType; /*A string. A kind of value that the characteristic can take on, such as
                                numeric, text, and so forth.*/
    private String rangeInterval; /*A string. An indicator that specifies the inclusion or exclusion of the
                                    valueFrom and valueTo attributes. If applicable, possible values are
                                    "open", "closed", "closedBottom" and "closedTop".*/
    private String regex; //A string. Regular expression to define constraint on the allowed value.
    private String atype; //a == @
    private String schemaLocation; //a == @
}
