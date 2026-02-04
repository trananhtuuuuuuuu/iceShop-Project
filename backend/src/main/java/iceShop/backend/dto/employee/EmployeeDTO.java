package iceShop.backend.dto.employee;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
  private String fullName;
  private String phone;
  private String address;
  private String gender;
  private String status;
  private BigDecimal salary;
}
