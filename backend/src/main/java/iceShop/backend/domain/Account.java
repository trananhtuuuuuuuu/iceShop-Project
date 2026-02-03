package iceShop.backend.domain;

import java.util.UUID;

import iceShop.backend.Enum.UserStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="accounts")
@Getter
@Setter
public class Account extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String fullName;
  private String password;
  private String accessToken;
  private String refreshToken;
  private UserStatusEnum status;

  @OneToOne(mappedBy = "account")
  private Employee employee;

  @OneToOne(mappedBy = "account")
  private Customer customer;
}
