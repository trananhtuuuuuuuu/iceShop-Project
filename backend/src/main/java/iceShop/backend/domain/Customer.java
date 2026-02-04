package iceShop.backend.domain;

import java.math.BigDecimal;
import java.util.UUID;

import iceShop.backend.Enum.UserStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends User{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private BigDecimal numberOfOrder;
  private BigDecimal total;
  
  @Enumerated(EnumType.STRING)
  private UserStatusEnum  status;

  @OneToOne
  @JoinColumn(name="account_id", nullable = true)
  private Account account;

  public Customer(String fullName,
    String phone,
    String address,
    String gender,
    BigDecimal numberOfOrder,
    BigDecimal total,
    UserStatusEnum status){
      super(fullName, phone, address, gender);
      this.numberOfOrder = numberOfOrder;
      this.total = total;
      this.status = status;
  }
}
