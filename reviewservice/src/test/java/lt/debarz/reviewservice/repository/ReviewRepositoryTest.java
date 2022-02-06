package lt.debarz.reviewservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ReviewRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    ReviewRepository repository;



}
