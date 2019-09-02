package org.neriko.catalog.resource_models;

public class ChannelRef {
    private String href; //A string. Unique identifier of the channel.
    private String id; //A string. Unique identifier of the channel.
    private String name; //A string. Name of the channel.
    private String areferredType; /*a == @ A string. (Class) type of the referred channel like
                                           DistributionChannel, SalesChannel and so on.*/
}
