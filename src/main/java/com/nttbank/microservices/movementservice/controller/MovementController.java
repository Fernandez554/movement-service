package com.nttbank.microservices.movementservice.controller;

import com.nttbank.microservices.movementservice.dto.MovementDTO;
import com.nttbank.microservices.movementservice.mapper.MovementMapper;
import com.nttbank.microservices.movementservice.model.entity.Movement;
import com.nttbank.microservices.movementservice.service.MovementService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
@Validated
public class MovementController {

  private final MovementService movementService;
  private final MovementMapper movementMapper;

  @GetMapping
  public Mono<ResponseEntity<Flux<Movement>>> findAll() {
    Flux<Movement> accountList = movementService.findAll();

    return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(accountList))
        .defaultIfEmpty(ResponseEntity.noContent().build());
  }

  @PostMapping
  public Mono<ResponseEntity<Movement>> save(@Valid @RequestBody MovementDTO movementDTO,
      final ServerHttpRequest req) {
    Movement mov = movementMapper.movementDtoToMovement(movementDTO);
    return movementService.save(mov)
        .map(c -> ResponseEntity.created(
                URI.create(req.getURI().toString().concat("/").concat(c.getId())))
            .contentType(MediaType.APPLICATION_JSON).body(c))
        .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @GetMapping("/{account_id}")
  public Mono<ResponseEntity<Flux<Movement>>> findAllByAccountId(
      @Valid @PathVariable("account_id") String accountId) {
    Flux<Movement> accountList = movementService.findAllByAccountId(accountId);

    return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(accountList))
        .defaultIfEmpty(ResponseEntity.noContent().build());
  }


}

