package iceShop.backend.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_details")
public class OrderDetail extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private BigDecimal unitPrice;
  private BigDecimal quantity;
  private String purchasedType; // wholesale or retail

  @ManyToOne
  @JoinColumn(name="order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;
}
