package iceShop.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import iceShop.backend.domain.Customer;
import iceShop.backend.dto.customer.CustomerDTO;
/*
private String fullName;
  private String address;
  private String gender;
  private String phone;
  private String status = UserStatusEnum.ACTIVE.toString();
  private BigDecimal total;
  private BigDecimal numberOfOrder;

*/
public class CustomerMapper {
  public static CustomerDTO toDTO(Customer customer){
    return new CustomerDTO(
      customer.getFullName(),
      customer.getAddress(),
      customer.getGender(),
      customer.getPhone(),
      customer.getStatus().name(),
      customer.getTotal(),
      customer.getNumberOfOrder()
    );
  }

  public static List<CustomerDTO> toDTOs(List<Customer> customers){
    List<CustomerDTO> customerDTOs = new ArrayList<>();
    for(Customer c : customers){
      customerDTOs.add(toDTO(c));
    }
    
    return customerDTOs;
  }
}
