package com.nttbank.microservices.movementservice.service;

import com.nttbank.microservices.movementservice.model.entity.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {

  Mono<Movement> save(Movement movement);

  Mono<Movement> update(Movement movement);

  Flux<Movement> findAll();

  Mono<Movement> findById(String movementId);

  Mono<Void> delete(String movementId);

  Flux<Movement> findAllByAccountId(String accountId);

}
