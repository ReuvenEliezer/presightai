//package com.presight.ai.consumer;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.presight.ai.consumer.config.MongoConfig;
//import de.flapdoodle.embed.mongo.MongodExecutable;
//import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.config.ImmutableMongodConfig;
//import de.flapdoodle.embed.mongo.config.MongodConfig;
//import de.flapdoodle.embed.mongo.config.Net;
//import de.flapdoodle.embed.mongo.distribution.Version;
//import de.flapdoodle.embed.process.runtime.Network;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.util.SocketUtils;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//@Configuration
//public class MockitoMongoConfiguration extends MongoConfig {
//
//    private static final String CONNECTION_STRING = "mongodb://%s:%d";
//
//    private MongodExecutable mongodExecutable;
//
//    @Override
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
//        String ip = "localhost";
//        int randomPort = SocketUtils.findAvailableTcpPort();
//
//        try {
//
//            ImmutableMongodConfig mongodConfig = MongodConfig
//                    .builder()
//                    .version(Version.Main.PRODUCTION)
//                    .net(new Net(ip, randomPort, Network.localhostIsIPv6()))
//                    .build();
//
//            MongodStarter starter = MongodStarter.getDefaultInstance();
//            mongodExecutable = starter.prepare(mongodConfig);
//            mongodExecutable.start();
//        }catch (IOException e){
//
//        }
//        return new MongoTemplate(mongoClient1(ip, randomPort), getDatabaseName());
//    }
//
//    @Bean
//    public MongoClient mongoClient1(String ip, int randomPort) {
//        return MongoClients.create(String.format(CONNECTION_STRING, ip, randomPort));
//    }
//
//}
