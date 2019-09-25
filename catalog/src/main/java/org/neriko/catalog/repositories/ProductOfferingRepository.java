package org.neriko.catalog.repositories;

import org.neriko.catalog.entities.ProductOffering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOfferingRepository extends JpaRepository<ProductOffering, String> { }
