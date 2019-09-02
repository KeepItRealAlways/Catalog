package org.neriko.catalog.resource_models;

public class RelatedPartyRef {
    private String id; //Unique identifier of related party
    private String href; //Reference of the relatedParty, could be a party reference or a partyRole reference
    private String role; //Name of the related party
    private String name; //Role of the related party
    private TimePeriod validFor; //The TimePeriod for which the related party is linked to the entity
    private String areferredType; //a == @ The class type of the referred object
}
