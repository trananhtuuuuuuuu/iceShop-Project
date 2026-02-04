package iceShop.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_types")
@Getter
@Setter
@NoArgsConstructor
public class OrderType extends BaseEntity{
  @Id
  private String id;
  private String orderType;
}
