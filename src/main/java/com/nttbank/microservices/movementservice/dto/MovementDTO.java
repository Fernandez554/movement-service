package com.nttbank.microservices.movementservice.dto;

import com.nttbank.microservices.movementservice.model.MovementType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementDTO {

  private String id;

  private String customerId;

  private String accountId;

  @NotNull(message = "Movement type cannot be null.")
  private MovementType type;

  @DecimalMin(value = "0.00", message = "Amount must be greater than 0.")
  @NotNull(message = "Amount cannot be null.")
  private BigDecimal amount;

  @DecimalMin(value = "0.00", inclusive = true, message = "Balance after movement cannot be negative.")
  private BigDecimal balanceAfterMovement;

  @NotNull(message = "Timestamp cannot be null.")
  private LocalDateTime timestamp;

  @Size(max = 255, message = "Description cannot exceed 255 characters.")
  private String description;

}
