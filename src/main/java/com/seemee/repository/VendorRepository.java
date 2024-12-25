package com.seemee.repository;

import com.seemee.model.VendorShops;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository{
    List<VendorShops> getVendorsByStreetName(String streetName);
}
