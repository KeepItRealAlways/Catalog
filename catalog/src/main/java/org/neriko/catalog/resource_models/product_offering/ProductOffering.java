package org.neriko.catalog.resource_models.product_offering;

import org.neriko.catalog.resource_models.*;

import java.util.List;

public class ProductOffering {
    private String id; //A string. Unique identifier of the productOffering.
    private String href; //A string. Reference of the ProductOffering.
    private String name; //A string. Name of the productOffering.
    private String description; //A string. Description of the productOffering.
    private boolean isBundle; /*A boolean. isBundle determines whether a productOffering
                                represents a single productOffering (false), or a bundle of
                                productOfferings (true).*/
    private DateTime lastUpdate; //A date time (DateTime). Date and time of the last update.
    private String lifecycleStatus; //A string. Used to indicate the current lifecycle status.
    private TimePeriod validFor; //A time TimePeriod. The TimePeriod for which the productOffering is valid.
    private String version; //A string. ProductOffering version.
    private String atype; //a == @ A string. Class type of the product offering.
    private String abaseType; //a == @ A string. Immediate base (class) type of the product offering.
    private String aschemaLocation; //a == @ A string. A link to the schema describing this product offering.
    private boolean isSellable; /*A boolean. A flag indicating if this product offer can be sold
                                stand-alone for sale or not. If this flag is false it indicates that the
                                offer can only be sold within a bundle.*/
    private List<CategoryRef> category;/*A list of category references (CategoryRef [*]). The category
                                        resource is used to group product offerings, service and
                                        resource candidates in logical containers. Categories can
                                        contain other categories and/or product offerings, resource or
                                        service candidates.*/
    private List<AgreementRef> agreement; /*A list of agreement references (AgreementRef [*]). An
                                            agreement represents a contract or arrangement, either written
                                            or verbal and sometimes enforceable by law, such as a service
                                            level agreement or a customer price agreement. An agreement
                                            involves a number of other business entities, such as products,
                                            services, and resources and/or their specifications.*/
    private List<MarketSegmentRef> marketSegment; /*A list of market segment references (MarketSegmentRef [*]).
                                                    provides references to the corresponding market segment as
                                                    target of product offerings. A market segment is grouping of
                                                    Parties, GeographicAreas, SalesChannels, and so forth.*/
    private List<Attachment> attachment;/*A list of attachments (Attachment [*]). Complements the
                                        description of an element (for instance a product) through video,
                                        pictures...*/
    private List<ProductOfferingPrice> productOfferingPrice; /*A list of product offering prices
                                                               (ProductOfferingPrice [*]). An amount, usually of money,
                                                               that is asked for or allowed when a ProductOffering is
                                                               bought, rented, or leased. The price is valid for a
                                                               defined TimePeriod of time and may not represent the actual
                                                               price paid by a customer. It should be noted that a
                                                               product offering price can be created directly via
                                                               Product Offering Price resource as well. However, some
                                                               product offering price subresources may not be exposed
                                                               through Product Offering resource.*/
    private List<ProductOfferingTerm> productOfferingTerm; /*A list of product offering terms (ProductOfferingTerm [*]).
                                                            A condition under which a ProductOffering is made available
                                                            to Customers. For instance, a productOffering can be offered
                                                            with multiple commitment TimePeriods.*/
    private ResourceCandidateRef resourceCandidate; /*A resource candidate reference (ResourceCandidateRef). A
                                                    resource candidate is an entity that makes a
                                                    ResourceSpecification available to a catalog.*/
    private SLARef serviceLevelAgreement; /*A SLA reference (SLARef). ServiceLevelAgreement reference:
                                            A service level agreement (SLA) is a type of agreement that
                                            represents a formal negotiated agreement between two parties
                                            designed to create a common understanding about products,
                                            services, priorities, responsibilities, and so forth. The SLA is a
                                            set of appropriate procedures and targets formally or informally
                                            agreed between parties in order to achieve and maintain
                                            specified Quality of Service.*/
    private ServiceCandidateRef serviceCandidate; /*A service candidate reference (ServiceCandidateRef).
                                                    ServiceCandidate is an entity that makes a ServiceSpecification
                                                    available to a catalog.*/
    private List<ProdSpecCharValueUse> prodSpecCharValueUse; /*A list of prod spec char value uses (ProdSpecCharValueUse
                                                            [*]). A use of the ProdSpecCharacteristicValue by a
                                                            ProductOffering to which additional properties (attributes)
                                                            apply or override the properties of similar properties
                                                            contained in ProdSpecCharacteristicValue. It should be noted
                                                            that characteristics which their value(s) addressed by this
                                                            object must exist in corresponding product specification.
                                                            The available characteristic values for a
                                                            ProductSpecCharacteristic in a Product specification can be
                                                            modified at the ProductOffering level. For example, a
                                                            characteristic 'Color' might have values White, Blue, Green,
                                                            and Red. But, the list of values can be restricted to e.g.
                                                            White and Blue in an associated product offering. It should
                                                            be noted that the list of values in 'ProdSpecCharValueUse'
                                                            is a strict subset of the list of values as defined in the
                                                            corresponding product specification characteristics.*/
    private ProductSpecificationRef productSpecification; /*A product specification reference (ProductSpecificationRef).
                                                            A ProductSpecification is a detailed description of a
                                                            tangible or intangible object made available externally in
                                                            the form of a ProductOffering to customers or other parties
                                                            playing a party role.*/
    private List<BundledProductOffering> bundledProductOffering; /*A list of bundled product offerings
                                                                   (BundledProductOffering [*]). A type of
                                                                   ProductOffering that belongs to a grouping of
                                                                   ProductOfferings made available to the market. It
                                                                   inherits of all attributes of ProductOffering.*/
    private List<ChannelRef> channel; /*A list of channel references (ChannelRef [*]). The channel
                                        defines the channel for selling product offerings.*/
    private List<PlaceRef> place; /*A list of place references (PlaceRef [*]). Place defines the
                                    places where the products are sold or delivered.*/


}
