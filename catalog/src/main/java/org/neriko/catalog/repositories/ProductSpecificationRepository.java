package org.neriko.catalog.repositories;

import org.neriko.catalog.entities.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, String> { }
