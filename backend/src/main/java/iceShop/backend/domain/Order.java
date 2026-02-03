package iceShop.backend.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order  extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private BigDecimal totalPrice;

  @OneToOne
  @JoinColumn(name="order_type_id")
  private OrderType orderType;

  @OneToMany(mappedBy = "order")
  private List<OrderDetail> orderDetails;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

}
