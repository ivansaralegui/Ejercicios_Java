package com.example.Ejercicio12_MongoDB.controladores;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableMongoRepositories(basePackages = "com.baeldung.repository")
public class MongoDBConfig {
    public String getDatabaseName() {
        return "Ejercicio12_MongoDB";
    }

    public MongoClient mongoClient() {
        ConnectionString connection = new ConnectionString("mongodb://localhost:27017/Ejercicio12_MongoDB");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connection).build();

        return MongoClients.create(mongoClientSettings);
    }

    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "Ejercicio12_MongoDB");
    }

}
