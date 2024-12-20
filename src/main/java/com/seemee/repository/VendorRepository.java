package com.seemee.repository;

import com.seemee.model.VendorShops;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends MongoRepository<VendorShops, String> {
    // Custom query to find vendors by street name
    @Query("{'vendorAddress.streetName': ?0 }")
    List<VendorShops> findByStreetName(String streetName);
}
