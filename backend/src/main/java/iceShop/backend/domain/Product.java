package iceShop.backend.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;
  private String category;
  private BigDecimal inventory;
  private BigDecimal unitPrice;

  @OneToMany(mappedBy = "product")
  private List<OrderDetail> orderDetails;

  @OneToOne(mappedBy = "product")
  private IceProduct iceProduct;

  @OneToOne(mappedBy = "product")
  private WaterProduct waterProduct;
}
