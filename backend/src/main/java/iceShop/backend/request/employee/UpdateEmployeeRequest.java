package iceShop.backend.request.employee;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {
  private String fullName;
  private String phone;
  private String address;
  private String gender;
  private String status = "ACTIVE";
  private BigDecimal salary;
}
