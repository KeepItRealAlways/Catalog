package org.neriko.catalog.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
public class CategoryRef {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String category_id; //A string. Unique identifier of the category.

    @Column(name = "href")
    private String href; //A string. Reference of the category

    @Column(name = "version")
    private String version; //Category version

    @Column(name = "name")
    private String name; //Name of the category
}
