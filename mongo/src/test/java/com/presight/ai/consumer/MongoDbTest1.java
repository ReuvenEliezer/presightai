//package com.presight.ai.consumer;
//
//import ac.simons.spring.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
//import ac.simons.spring.boot.test.autoconfigure.data.mongo.AutoConfigureEmbeddedTestMongod;
//import com.mongodb.BasicDBObjectBuilder;
//import com.mongodb.DBObject;
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
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.util.SocketUtils;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureEmbeddedTestMongod(enabled = false)
//public class MongoDbTest1 {
//
//    /**
//     * https://www.baeldung.com/spring-boot-embedded-mongodb
//     */
//
//    @MockBean
//    private MongoConfig mongoConfig;
//
//    private static final String CONNECTION_STRING = "mongodb://%s:%d";
//
//    public MongodExecutable mongodExecutable;
//
//    @MockBean
//    private MongoTemplate mongoTemplate;
//
//    @BeforeEach
//    public void setup() throws IOException {
//        String ip = "localhost";
//        int randomPort = SocketUtils.findAvailableTcpPort();
//        Mockito.when(mongoConfig.mongoClient()).thenReturn(mongoClient(ip, randomPort));
//
//        ImmutableMongodConfig mongodConfig = MongodConfig
//                .builder()
//                .version(Version.Main.PRODUCTION)
//                .net(new Net(ip, randomPort, Network.localhostIsIPv6()))
//                .build();
//
//        MongodStarter starter = MongodStarter.getDefaultInstance();
//        mongodExecutable = starter.prepare(mongodConfig);
//        mongodExecutable.start();
//        Mockito.when(mongoConfig.mongoTemplate()).thenReturn(new MongoTemplate(mongoClient(ip, randomPort), mongoConfig.getTableName()));
//    }
//
//    private MongoClient mongoClient(String ip, int randomPort) {
//        return MongoClients.create(String.format(CONNECTION_STRING, ip, randomPort));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        mongodExecutable.stop();
//    }
//
//    @TestConfiguration
//    static class Config {
//        @Bean
//        public MongoClient mongoClient(String ip, int randomPort) {
//            return MongoClients.create(String.format(CONNECTION_STRING, ip, randomPort));
//        }
//
//        @Bean
//        public MongoTemplate mongoTemplate() throws UnknownHostException {
//            String ip = "localhost";
//            int randomPort = SocketUtils.findAvailableTcpPort();
//            ImmutableMongodConfig mongodConfig = MongodConfig
//                    .builder()
//                    .version(Version.Main.PRODUCTION)
//                    .net(new Net(ip, randomPort, Network.localhostIsIPv6()))
//                    .build();
//
//            MongodStarter starter = MongodStarter.getDefaultInstance();
////            mongodExecutable = starter.prepare(mongodConfig);
////            mongodExecutable.start();
//            return new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, randomPort)), "test");
//        }
//    }
//
//    @Test
//    public void test() {
//        // given
//        DBObject objectToSave = BasicDBObjectBuilder.start()
//                .add("key", "value")
//                .get();
//
//        // when
//        mongoTemplate.save(objectToSave, "person");
//
//        // then
//        assertThat(mongoTemplate.findAll(DBObject.class, "person")).extracting("key")
//                .containsOnly("value");
//    }
//}