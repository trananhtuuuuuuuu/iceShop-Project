package iceShop.backend.domain;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
  private LocalDate CreatedAt;
  private LocalDate DeletedAt;
  private LocalDate UpdatedAt;
}

