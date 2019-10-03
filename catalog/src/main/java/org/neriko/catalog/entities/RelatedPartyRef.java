package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "related_party_ref")
public class RelatedPartyRef {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String related_party_ref_id; //Unique identifier of related party

    @Column
    private String href; //Reference of the relatedParty, could be a party reference or a partyRole reference

    @Column
    private String role; //Name of the related party

    @Column
    private String name; //Role of the related party

    @Column
    private Timestamp validForBegin; //The TimePeriod for which the related party is linked to the entity

    @Column
    private Timestamp validForEnd; //The TimePeriod for which the related party is linked to the entity
}
