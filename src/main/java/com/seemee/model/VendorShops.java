package com.seemee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.seemee.util.ObjectIdDeserializer;

import java.util.List;

@Document(collection = "VendorShops")
public class VendorShops {
    @JsonDeserialize(using = ObjectIdDeserializer.class)
    @Id
    @JsonProperty("_id")
    private String id;
    @JsonProperty("vendorId")
    private String vendorId;
    @JsonProperty("vendorName")
    private String vendorName;
    @JsonProperty("vendorShopName")
    private String vendorShopName;
    @JsonProperty("vendorAddress")
    private List<Address> vendorAddress;
    @JsonProperty("vendorContactDetails")
    private List<ContactDetails> vendorContactDetails;
    @JsonProperty("vendorBankDetails")
    private List<BankDetails> vendorBankDetails;
    @JsonProperty("vendorServices")
    private List<Service> vendorServices;
    @JsonProperty("vendorDocuments")
    private List<Document> vendorDocuments;
    @JsonProperty("vendorImages")
    private List<Image> vendorImages;
    @JsonProperty("vendorReviews")
    private List<Review> vendorReviews;

    // Getters and Setters
    @Data
    public static class Address {
        private String floor;
        private String building;
        @Field("vendorAddress.streetName")
        private String streetName;
        private String city;
        private String state;
        private String country;
        private String pincode;
        private List<Double> location; // For geospatial coordinates
    }

    @Data
    public static class ContactDetails {
        private String phone;
        private String email;
    }

    @Data
    public static class BankDetails {
        private String bankName;
        private String branchName;
        private String accountNumber;
        private String accountName;
        private String ifsc;
    }

    @Setter
    @Getter
    public static class Service {
        private String serviceId;
        private String serviceName;
        private String serviceDescription;
        private String servicePrice;
        private String serviceDuration;

        // Getters and Setters

    }

    @Setter
    @Getter
    public static class Document {
        private String documentId;
        private String documentName;
        private String documentNumber;
        private String documentType;

        // Getters and Setters

    }

    @Setter
    @Getter
    public static class Image {
        private String imageId;
        private String imageType;
        private String imagePath;

        // Getters and Setters

    }

    @Setter
    @Getter
    public static class Review {
        private String reviewId;
        private String reviewerName;
        private String reviewerEmail;
        private String reviewerPhone;
        private String reviewerLocation;
        private String reviewerRating;
        private String reviewerReview;
    }
}
