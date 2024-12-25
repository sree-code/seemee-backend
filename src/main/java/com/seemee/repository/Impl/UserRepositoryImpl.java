package com.seemee.repository.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.seemee.config.MongoDBConnection;
import com.seemee.constants.SeeMeeConstants;
import com.seemee.dto.AuthenticateUser;
import com.seemee.dto.LoginResponse;
import com.seemee.model.User;
import com.seemee.repository.UserRepository;
import com.seemee.service.impl.UserServiceImpl;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Repository
public class UserRepositoryImpl implements UserRepository {
    Logger logger = Logger.getLogger(UserRepositoryImpl.class.getName());

    @Override
    public User getUserProfile(String email) {
        logger.info("Email:- "+ email);
        User user = new User();
        ObjectMapper objectMapper = new ObjectMapper();

        try (MongoClient client = MongoDBConnection.connect()){

            // Get the database
            MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

            // Get the collection
            MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

            // Query for vendors with the given street name
            MongoCursor<Document> cursor = collection.find(
                    new Document("email", email)
            ).iterator();

            for (MongoCursor<Document> it = cursor; it.hasNext(); ) {
                Document doc = it.next();
                user = objectMapper.readValue(doc.toJson(), User.class);
            }
        } catch (Exception e) {
            logger.info("Exception: " + e.getMessage());
        }

        return user;
    }

    @Override
    public void createUserProfile(User user) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (MongoClient client = MongoDBConnection.connect()){

            // Get the database
            MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

            // Get the collection
            MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

            // Insert the document
            collection.insertOne(Document.parse(objectMapper.writeValueAsString(user)));

        } catch (Exception e) {
            logger.info("Exception: " + e.getMessage());
        }
    }

    @Override
    public User authenticateUser(AuthenticateUser authenticateUser) {
    String email = authenticateUser.getEmail();
    String password = authenticateUser.getPassword();
    logger.info("Email:- " + email);
    User user = new User();
    ObjectMapper objectMapper = new ObjectMapper();

    try (MongoClient client = MongoDBConnection.connect()) {

        // Get the database
        MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

        // Get the collection
        MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

        // Query for vendors with the given street name
        MongoCursor<Document> cursor = collection.find(
                new Document("email", email)
        ).iterator();

        for (MongoCursor<Document> it = cursor; it.hasNext(); ) {
            Document doc = it.next();
            user = objectMapper.readValue(doc.toJson(), User.class);
        }
    } catch (Exception e) {
        logger.info("Exception: " + e.getMessage());
    }
    return user;

}


    public String updatePassword(AuthenticateUser authenticateUser) {
        String email = authenticateUser.getEmail();
        String password = authenticateUser.getPassword();
        logger.info("Email:- " + email);
        User user = new User();
        ObjectMapper objectMapper = new ObjectMapper();

        try (MongoClient client = MongoDBConnection.connect()) {

            // Get the database
            MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

            // Get the collection
            MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

            // Query for vendors with the given street name
            MongoCursor<Document> cursor = collection.find(
                    new Document("email", email)
            ).iterator();

            for (MongoCursor<Document> it = cursor; it.hasNext(); ) {
                Document doc = it.next();
                user = objectMapper.readValue(doc.toJson(), User.class);
            }
        } catch (Exception e) {
            logger.info("Exception: " + e.getMessage());
        }

        if (user.getEmail().equals(email)) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setPassword(hashedPassword);
            try (MongoClient client = MongoDBConnection.connect()) {

                // Get the database
                MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

                // Get the collection
                MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

                // Update the document
                collection.updateOne(new Document("email", email), new Document("$set", new Document("password", hashedPassword)));

            } catch (Exception e) {
                logger.info("Exception: " + e.getMessage());
            }
            return "Success";
        } else {
            return "Failure";
        }
    }

    public String updateAddress(User user, String index) {
        String email = user.getEmail();
        logger.info("Email:- " + email);
        ObjectMapper objectMapper = new ObjectMapper();

        try (MongoClient client = MongoDBConnection.connect()) {

            // Get the database
            MongoDatabase database = MongoDBConnection.getDatabase(client, SeeMeeConstants.SeeMee);

            // Get the collection
            MongoCollection<Document> collection = database.getCollection(SeeMeeConstants.user);

            // Update the document
            collection.updateOne(new Document("email", email), new Document("$set", new Document(index, user.getAddress().get(Integer.parseInt(index)))));

        } catch (Exception e) {
            logger.info("Exception: " + e.getMessage());
        }
        return "Success";
    }

}
