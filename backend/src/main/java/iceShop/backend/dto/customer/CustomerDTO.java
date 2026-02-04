package iceShop.backend.dto.customer;

import java.math.BigDecimal;

import iceShop.backend.Enum.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
  private String fullName;
  private String address;
  private String gender;
  private String phone;
  private String status = UserStatusEnum.ACTIVE.toString();
  private BigDecimal total;
  private BigDecimal numberOfOrder;
}
