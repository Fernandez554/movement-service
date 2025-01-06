package com.nttbank.microservices.movementservice.repo;

import com.nttbank.microservices.movementservice.model.entity.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Represents a repository for movements in the banking system. This interface is used to interact
 * with the 'movements' collection in the MongoDB database.
 */
public interface IMovementRepo extends ReactiveMongoRepository<Movement, String> {

  public Flux<Movement> findAllByAccountId(String accountNumber);

}
