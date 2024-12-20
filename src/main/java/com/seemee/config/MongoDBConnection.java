package com.seemee.config;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoDBConnection {

    static String CONNECTION_URI= "mongodb+srv://krishk:uh3RIF6cWPWLvFiA@cluster0.szsml.mongodb.net/SeeMee?retryWrites=true&w=majority";

    // Method to establish and return a connection to MongoDB
    public static MongoClient connect() {
        return MongoClients.create(CONNECTION_URI);
    }

    // Method to get the database
    public static MongoDatabase getDatabase(MongoClient client, String dbName) {
        return client.getDatabase(dbName);
    }
}
