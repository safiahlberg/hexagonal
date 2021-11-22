package com.wixia.hexagonal;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOwnerRepository.class)
public class MongoDbConfiguration {
}
