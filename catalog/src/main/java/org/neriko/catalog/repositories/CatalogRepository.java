package org.neriko.catalog.repositories;

import org.neriko.catalog.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, String> {}
