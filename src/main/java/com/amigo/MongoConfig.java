package com.amigo;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends  AbstractMongoConfiguration {


    @Override
    public String getDatabaseName() {
        return "amigo";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("mongodb://heroku_07nblqtz:ff08k99pomnicnmv69dtga0otb@ds249605.mlab.com:49605/");
    }

}