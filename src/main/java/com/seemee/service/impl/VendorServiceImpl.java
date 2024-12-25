package com.seemee.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import com.seemee.config.MongoDBConnection;
import com.seemee.constants.SeeMeeConstants;
import com.seemee.model.VendorShops;
import com.seemee.repository.VendorRepository;
import com.seemee.service.VendorService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class VendorServiceImpl implements VendorService {

    Logger logger = Logger.getLogger(VendorServiceImpl.class.getName());

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public List<VendorShops> getVendorsByStreetName(String streetName) {
        return vendorRepository.getVendorsByStreetName(streetName);
    }

}
