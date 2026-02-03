package iceShop.backend.domain;

import java.math.BigDecimal;
import java.util.UUID;

import iceShop.backend.Enum.UserStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer extends User{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private BigDecimal numberOfOrder;
  private BigDecimal total;
  private UserStatusEnum  status;

  @OneToOne
  @JoinColumn(name="account_id")
  private Account account;

}
