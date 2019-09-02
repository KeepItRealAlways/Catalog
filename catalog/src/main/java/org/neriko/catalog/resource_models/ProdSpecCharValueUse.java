package org.neriko.catalog.resource_models;

import org.neriko.catalog.resource_models.ProductSpecCharasteristicValue;
import org.neriko.catalog.resource_models.ProductSpecificationRef;

import java.util.List;

public class ProdSpecCharValueUse {
    private String name; //A string. Name of the associated productSpecCharacteristic
    private String description; //A string. A narrative that explains in detail what the productSpecCharacteristic is.
    private String valueType; /*A string. A kind of value that the characteristic
                                value can take on, such as numeric, text and so forth.*/
    private int minCardinality; /*An integer. The minimum number of instances a
                                CharacteristicValue can take on. For example, zero to
                                five phone numbers in a group calling plan, where zero
                                is the value for the minCardinality*/
    private int maxCardinality; /*An integer. The maximum number of instances a
                                CharacteristicValue can take on. For example, zero to
                                five phone numbers in a group calling plan, where five is
                                the value for the maxCardinality.*/
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod for which the productSpecCharacteristic is valid.
    private List<ProductSpecCharasteristicValue> productSpecCharasteristicValue;/*A list of product spec characteristic
                                                                              values (ProductSpecCharacteristicValue
                                                                              [1..*]). A number or text that can be
                                                                              assigned to a ProductSpecCharacteristic.*/
    private ProductSpecificationRef productSpecification; /*A product specification reference
                                                            (ProductSpecificationRef). A ProductSpecification is a
                                                            detailed description of a tangible or intangible object
                                                            made available externally in the form of a
                                                            ProductOffering to customers or other parties playing a
                                                            party role.*/
}
