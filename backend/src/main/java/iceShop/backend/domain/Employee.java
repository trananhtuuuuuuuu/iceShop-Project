package iceShop.backend.domain;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import iceShop.backend.Enum.UserStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="employees")
@Getter
@Setter
public class Employee extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Enumerated(EnumType.STRING)
  private UserStatusEnum status;
  private BigDecimal salary;

//  private identification_image;
//  private personal_image;
//  private contract_image;


  @OneToOne
  @JoinColumn(name="account_id", nullable = true)
  private Account account;

  @OneToMany(mappedBy = "employee")
  private List<LeaveRequest> leaveRequests;
}
