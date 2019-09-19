CREATE TABLE catalog(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    version VARCHAR,
    last_update TIMESTAMP,
    type VARCHAR,
    name VARCHAR,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE сategory(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    last_update TIMESTAMP,
    version VARCHAR,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    parent_id VARCHAR,
    name VARCHAR,
    description VARCHAR,
    catalog VARCHAR,
    FOREIGN KEY (catalog) REFERENCES catalog(id)
);

CREATE TABLE market_segment_ref(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR
);

CREATE TABLE channel(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR
);

CREATE TABLE place(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    geolocation_url VARCHAR,
    address VARCHAR,
    role VARCHAR
);

CREATE TABLE prod_spec_char_val_use(
    id VARCHAR PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    val_type VARCHAR,
    min_cardinality INTEGER,
    max_cardinality INTEGER,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE prod_spec(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    description VARCHAR,
    brand VARCHAR,
    last_update TIMESTAMP,
    lifecycle_status VARCHAR,
    prodNumber VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    prod_spec_char_val_use VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use) REFERENCES prod_spec_char_val_use(id)
);

CREATE TABLE prod_offer(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    name VARCHAR,
    description VARCHAR,
    last_update TIMESTAMP,
    lifecycle_status VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP,
    version VARCHAR,
    category VARCHAR,
    FOREIGN KEY (category) REFERENCES сategory(id),
    prod_spec VARCHAR,
    FOREIGN KEY (prod_spec) REFERENCES prod_spec(id)
);

CREATE TABLE prod_offer_price(
    id VARCHAR PRIMARY KEY,
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
    prod_offer VARCHAR,
    FOREIGN KEY (prod_offer) REFERENCES prod_offer(id)
);

CREATE TABLE prod_spec_char(
    id VARCHAR PRIMARY KEY,
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
    prod_spec VARCHAR,
    FOREIGN KEY (prod_spec) REFERENCES prod_spec(id) 
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
    prod_spec_char VARCHAR,
    FOREIGN KEY (prod_spec_char) REFERENCES prod_spec_char(id),
    prod_spec_char_val_use VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use) REFERENCES prod_spec_char_val_use(id)
);

CREATE TABLE related_party_ref(
    id VARCHAR PRIMARY KEY,
    href VARCHAR,
    role VARCHAR,
    name VARCHAR,
    valid_for_begin TIMESTAMP,
    valid_for_end TIMESTAMP
);

CREATE TABLE c_rpr(
    catalog VARCHAR,
    FOREIGN KEY (catalog) REFERENCES catalog(id),
    related_party_ref VARCHAR,
    FOREIGN KEY (related_party_ref) REFERENCES related_party_ref(id),
    CONSTRAINT c_crr_pkey PRIMARY KEY (catalog, related_party_ref)
);

CREATE TABLE ps_rpr(
    prod_spec VARCHAR,
    FOREIGN KEY (prod_spec) REFERENCES prod_spec(id),
    related_party_ref VARCHAR,
    FOREIGN KEY (related_party_ref) REFERENCES related_party_ref(id),
    CONSTRAINT ps_prr_pkey PRIMARY KEY (prod_spec, related_party_ref)
);

CREATE TABLE pscvu_pop(
    prod_spec_char_val_use VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use) REFERENCES prod_spec_char_val_use(id),
    prod_offer_price VARCHAR,
    FOREIGN KEY (prod_offer_price) REFERENCES prod_offer_price(id),
    CONSTRAINT pscvu_pop_pkey PRIMARY KEY (prod_spec_char_val_use, prod_offer_price)
);

CREATE TABLE pscvu_po(
    prod_spec_char_val_use VARCHAR,
    FOREIGN KEY (prod_spec_char_val_use) REFERENCES prod_spec_char_val_use(id),
    prod_offer VARCHAR,
    FOREIGN KEY (prod_offer) REFERENCES prod_offer(id),
    CONSTRAINT pscvu_po_pkey PRIMARY KEY (prod_spec_char_val_use, prod_offer)
);

CREATE TABLE po_p(
    prod_offer VARCHAR,
    FOREIGN KEY (prod_offer) REFERENCES prod_offer(id),
    place VARCHAR,
    FOREIGN KEY (place) REFERENCES place(id),
    CONSTRAINT po_p_pkey PRIMARY KEY (prod_offer, place)
);

CREATE TABLE pop_p(
    prod_offer_price VARCHAR,
    FOREIGN KEY (prod_offer_price) REFERENCES prod_offer_price(id),
    place VARCHAR,
    FOREIGN KEY (place) REFERENCES place(id),
    CONSTRAINT pop_p_pkey PRIMARY KEY (prod_offer_price, place)
);

CREATE TABLE po_msr(
    prod_offer VARCHAR,
    FOREIGN KEY (prod_offer) REFERENCES prod_offer(id),
    market_segment_ref VARCHAR,
    FOREIGN KEY (market_segment_ref) REFERENCES market_segment_ref(id),
    CONSTRAINT po_msr_pkey PRIMARY KEY (market_segment_ref, prod_offer)
);

CREATE TABLE po_c(
    prod_offer VARCHAR,
    FOREIGN KEY (prod_offer) REFERENCES prod_offer(id),
    channel VARCHAR,
    FOREIGN KEY (channel) REFERENCES channel(id),
    CONSTRAINT po_c_pkey PRIMARY KEY (prod_offer, channel)
);