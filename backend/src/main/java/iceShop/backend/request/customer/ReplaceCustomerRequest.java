package iceShop.backend.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplaceCustomerRequest {
  @NotBlank(message = "Name is mandatory")
  private String fullName;

  @NotBlank(message = "Address is mandatory")
  private String address;

  @NotBlank(message = "Gender is mandatory")
  private String gender;

  @NotBlank(message = "Phone is mandatory")
  private String phone;

  @NotBlank(message = "Status is mandatory")
  private String status;

}
