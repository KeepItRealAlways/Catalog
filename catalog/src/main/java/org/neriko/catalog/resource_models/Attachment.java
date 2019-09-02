package org.neriko.catalog.resource_models;

import org.neriko.catalog.resource_models.TimePeriod;

public class Attachment {
    private String description; //A string. A narrative text describing the content of the attachment.
    private String href; //A string. Reference of the attachment.
    private String id; //A string. Unique identifier of the attachment.
    private String type; //A string. Attachment type such as video, picture
    private String url; //A string. Uniform Resource Locator, is a web page address (a subset of URI).
    private String mimeType; //A string. Attachment mime type such as extension file for video, picture and document.
    private TimePeriod validFor; /* A time TimePeriod. A base/value business entity used
                                to represent a TimePeriod of time between two timepoints.*/
    private String atype; //a == @ A string. the class type of the Attachment.
    private String abaseType; //a == @ A string. The immediate base class type of the attachment.
    private String aschemaLocation; //a == @ A string. A link to the schema describing this attachment entity.
}
