CREATE TABLE catalog(
    catalog_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    version VARCHAR,
    last_update TIMESTAMP,
    type VARCHAR,
    name VARCHAR,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE category(
    category_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    last_update TIMESTAMP,
    version VARCHAR,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    parent_id VARCHAR,
    name VARCHAR,
    description VARCHAR,
    catalog_fk VARCHAR,
    FOREIGN KEY (catalog_fk) REFERENCES catalog(catalog_id)
);

CREATE TABLE market_segment_ref(
    market_segment_ref_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR
);

CREATE TABLE channel(
    channel_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR
);

CREATE TABLE place(
    place_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    geolocation_url VARCHAR,
    address VARCHAR,
    role VARCHAR
);

CREATE TABLE prod_spec_char_val_use(
    prod_spec_char_val_use_id VARCHAR PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    val_type VARCHAR,
    min_cardinality INTEGER,
    max_cardinality INTEGER,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE prod_spec(
    prod_spec_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    description VARCHAR,
    brand VARCHAR,
    last_update TIMESTAMP,
    lifecycle_status VARCHAR,
    prodNumber VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    prod_spec_char_val_use_fk VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use_fk) REFERENCES prod_spec_char_val_use(prod_spec_char_val_use_id)
);

CREATE TABLE prod_offer(
    prod_offer_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    description VARCHAR,
    last_update TIMESTAMP,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    version VARCHAR,
    category_fk VARCHAR,
    FOREIGN KEY (category_fk) REFERENCES category(category_id),
    prod_spec_fk VARCHAR,
    FOREIGN KEY (prod_spec_fk) REFERENCES prod_spec(prod_spec_id)
);

CREATE TABLE prod_offer_price(
    prod_offer_price_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    description VARCHAR,
    version VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    price_type VARCHAR,
    unit_of_measure_amount BIGINT,
    unit_of_measure_units VARCHAR,
    recurring_charge_period_type VARCHAR,
    recurring_charge_period_length INTEGER,
    last_update TIMESTAMP,
    lifecycle_status VARCHAR,
    price_val FLOAT,
    price_units VARCHAR,
    percentage FLOAT,
    prod_offer_fk VARCHAR,
    FOREIGN KEY (prod_offer_fk) REFERENCES prod_offer(prod_offer_id)
);

CREATE TABLE prod_spec_char(
    prod_spec_char_id VARCHAR PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    val_type VARCHAR,
    configurable BOOLEAN,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    min_cardinality INTEGER,
    max_cardinality INTEGER,
    is_unique BOOLEAN,
    regex VARCHAR,
    extensible BOOLEAN,
    prod_spec_fk VARCHAR,
    FOREIGN KEY (prod_spec_fk) REFERENCES prod_spec(prod_spec_id) 
);

CREATE TABLE prod_spec_char_val(
    is_default BOOLEAN,
    unit_of_measure VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    val VARCHAR,
    val_from VARCHAR,
    val_to VARCHAR,
    val_type VARCHAR,
    range_interval VARCHAR,
    regex VARCHAR,
    prod_spec_char_fk VARCHAR,
    FOREIGN KEY (prod_spec_char_fk) REFERENCES prod_spec_char(prod_spec_char_id),
    prod_spec_char_val_use_fk VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use_fk) REFERENCES prod_spec_char_val_use(prod_spec_char_val_use_id)
);

CREATE TABLE related_party_ref(
    related_party_ref_id VARCHAR PRIMARY KEY,
    href VARCHAR,
    role VARCHAR,
    name VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE c_rpr(
    catalog_fk VARCHAR,
    FOREIGN KEY (catalog_fk) REFERENCES catalog(catalog_id),
    related_party_ref_fk VARCHAR,
    FOREIGN KEY (related_party_ref_fk) REFERENCES related_party_ref(related_party_ref_id),
    CONSTRAINT c_crr_pkey PRIMARY KEY (catalog_fk, related_party_ref_fk)
);

CREATE TABLE ps_rpr(
    prod_spec_fk VARCHAR,
    FOREIGN KEY (prod_spec_fk) REFERENCES prod_spec(prod_spec_id),
    related_party_ref_fk VARCHAR,
    FOREIGN KEY (related_party_ref_fk) REFERENCES related_party_ref(related_party_ref_id),
    CONSTRAINT ps_prr_pkey PRIMARY KEY (prod_spec_fk, related_party_ref_fk)
);

CREATE TABLE pscvu_pop(
    prod_spec_char_val_use_fk VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use_fk) REFERENCES prod_spec_char_val_use(prod_spec_char_val_use_id),
    prod_offer_price_fk VARCHAR,
    FOREIGN KEY (prod_offer_price_fk) REFERENCES prod_offer_price(prod_offer_price_id),
    CONSTRAINT pscvu_pop_pkey PRIMARY KEY (prod_spec_char_val_use_fk, prod_offer_price_fk)
);

CREATE TABLE pscvu_po(
    prod_spec_char_val_use_fk VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use_fk) REFERENCES prod_spec_char_val_use(prod_spec_char_val_use_id),
    prod_offer_fk VARCHAR,
    FOREIGN KEY (prod_offer_fk) REFERENCES prod_offer(prod_offer_id),
    CONSTRAINT pscvu_po_pkey PRIMARY KEY (prod_spec_char_val_use_fk, prod_offer_fk)
);

CREATE TABLE po_p(
    prod_offer_fk VARCHAR,
    FOREIGN KEY (prod_offer_fk) REFERENCES prod_offer(prod_offer_id),
    place_fk VARCHAR,
    FOREIGN KEY (place_fk) REFERENCES place(place_id),
    CONSTRAINT po_p_pkey PRIMARY KEY (prod_offer_fk, place_fk)
);

CREATE TABLE pop_p(
    prod_offer_price_fk VARCHAR,
    FOREIGN KEY (prod_offer_price_fk) REFERENCES prod_offer_price(prod_offer_price_id),
    place_fk VARCHAR,
    FOREIGN KEY (place_fk) REFERENCES place(place_id),
    CONSTRAINT pop_p_pkey PRIMARY KEY (prod_offer_price_fk, place_fk)
);

CREATE TABLE po_msr(
    prod_offer_fk VARCHAR,
    FOREIGN KEY (prod_offer_fk) REFERENCES prod_offer(prod_offer_id),
    market_segment_ref_fk VARCHAR,
    FOREIGN KEY (market_segment_ref_fk) REFERENCES market_segment_ref(market_segment_ref_id),
    CONSTRAINT po_msr_pkey PRIMARY KEY (market_segment_ref_fk, prod_offer_fk)
);

CREATE TABLE po_c(
    prod_offer_fk VARCHAR,
    FOREIGN KEY (prod_offer_fk) REFERENCES prod_offer(prod_offer_id),
    channel_fk VARCHAR,
    FOREIGN KEY (channel_fk) REFERENCES channel(channel_id),
    CONSTRAINT po_c_pkey PRIMARY KEY (prod_offer_fk, channel_fk)
);