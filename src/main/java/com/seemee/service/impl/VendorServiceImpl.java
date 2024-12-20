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
    @Autowired
    VendorRepository vendorRepository;
    Logger logger = Logger.getLogger(VendorServiceImpl.class.getName());
    // Method to query vendors by street name
    public List<VendorShops> getVendorsByStreetName(String streetName) {
        logger.info("StreetName"+ streetName);
        List<VendorShops> vendorList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (MongoClient client = MongoDBConnection.connect()){

            // Get the database
             MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

            // Get the collection
            MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.vendor);

            // Query for vendors with the given street name
            MongoCursor<Document> cursor = collection.find(
                    new Document("vendorAddress.streetName", streetName)
            ).iterator();

            for (MongoCursor<Document> it = cursor; it.hasNext(); ) {
                Document doc = it.next();
                VendorShops vendor = objectMapper.readValue(doc.toJson(), VendorShops.class);
                vendorList.add(vendor);
            }
        } catch (Exception e) {
            logger.info("Exception: " + e.getMessage());
        }

        return vendorList;
    }

}
