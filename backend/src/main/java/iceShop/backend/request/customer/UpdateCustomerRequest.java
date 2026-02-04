package iceShop.backend.request.customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
  private String fullName;
  private String address;
  private String gender;
  private String phone;
  private String status;
}
