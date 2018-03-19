package com.example.mdb;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories


public class DatabaseConfig  extends AbstractMongoConfiguration {
    @Value("${db.connection.url}")
    private String mongoConnectionUrl;

    @Value("${tenant.db.name}")
    private String databaseName;

    @Value("${db.connectionTimeout}")
    private Integer connectionTimeout;

    @Value("${db.connectionsPerHost}")
    private Integer connectionsPerHost;

    @Override
    public Mongo mongo() {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
        if(connectionTimeout > 10*1000)
            optionsBuilder.connectTimeout(10*1000);
        if(connectionsPerHost > 100)
            optionsBuilder.connectionsPerHost(connectionsPerHost);
        optionsBuilder.threadsAllowedToBlockForConnectionMultiplier(10);


        MongoClientURI uri = new MongoClientURI(this.mongoConnectionUrl, optionsBuilder );
        return new MongoClient( uri );
    }

    @Override
    protected String getDatabaseName() {
        return this.databaseName;
    }
}
