package com.nttbank.microservices.movementservice.service.impl;

import com.nttbank.microservices.movementservice.model.entity.Movement;
import com.nttbank.microservices.movementservice.repo.IMovementRepo;
import com.nttbank.microservices.movementservice.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Represents a service for movements in the banking system.
 */
@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

  private final IMovementRepo repo;

  @Override
  public Mono<Movement> save(Movement movement) {
    return repo.save(movement);
  }

  @Override
  public Mono<Movement> update(Movement movement) {
    return repo.save(movement);
  }

  @Override
  public Flux<Movement> findAll() {
    return repo.findAll();
  }

  @Override
  public Mono<Movement> findById(String movementId) {
    return repo.findById(movementId);
  }

  @Override
  public Mono<Void> delete(String movementId) {
    return repo.deleteById(movementId);
  }

  @Override
  public Flux<Movement> findAllByAccountId(String accountId) {
    return repo.findAllByAccountId(accountId);
  }
}
