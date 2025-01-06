package com.nttbank.microservices.movementservice.mapper;

import com.nttbank.microservices.movementservice.dto.MovementDTO;
import com.nttbank.microservices.movementservice.model.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MovementMapper {
  MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

  Movement movementDtoToMovement(MovementDTO movementDTO);


}
