package iceShop.backend.request.employee;

import java.math.BigDecimal;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {
  @NotBlank(message = "Name is mandatory")
  private String fullName;

  @NotBlank(message = "Phone is mandatory")
  private String phone;

  @NotBlank(message = "Address is mandatory")
  private String address;

  @NotBlank(message = "Gender is mandatory")
  private String gender;

  @NotBlank(message = "Status is mandatory")
  private String status = "ACTIVE";

  @NotNull(message = "Salary is mandatory")
  @PositiveOrZero(message = "Salary must be >= 0")
  private BigDecimal salary;
}
