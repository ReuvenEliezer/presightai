package com.presight.ai.consumer.repositories;

import com.presight.ai.consumer.entities.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {

}
