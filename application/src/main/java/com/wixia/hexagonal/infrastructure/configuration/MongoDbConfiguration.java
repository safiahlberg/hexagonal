package com.wixia.hexagonal.infrastructure.configuration;

import com.wixia.hexagonal.infrastructure.repository.mongo.SpringDataMongoOwnerRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOwnerRepository.class)
public class MongoDbConfiguration {
}
