package iceShop.backend.request.customer;


import iceShop.backend.Enum.UserStatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
  @NotBlank(message = "Name is mandatory")
  private String fullName;

  @NotBlank(message = "Address is mandatory")
  private String address;

  @NotBlank(message = "Gender is mandatory")
  private String gender;

  @NotBlank(message = "Phone is mandatory")
  private String phone;

  private String status = UserStatusEnum.ACTIVE.toString();
}
