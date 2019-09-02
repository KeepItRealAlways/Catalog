package org.neriko.catalog.repositories;

import org.neriko.catalog.resource_models.catalog.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, String> {
    List<Catalog> findAll();

}
