package iceShop.backend.service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import iceShop.backend.Enum.UserStatusEnum;
import iceShop.backend.domain.Customer;
import iceShop.backend.repository.CustomerRepository;
import iceShop.backend.request.customer.CreateCustomerRequest;
import iceShop.backend.request.customer.ReplaceCustomerRequest;
import iceShop.backend.request.customer.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
  
  private final CustomerRepository customerRepository;

  public Customer CreateCustomerService(CreateCustomerRequest createCustomerRequest){
    Customer newCustomer = new Customer(createCustomerRequest.getFullName(), 
    createCustomerRequest.getPhone(), 
    createCustomerRequest.getAddress(), 
    createCustomerRequest.getGender(),
    new BigDecimal(0), 
    new BigDecimal(0), 
    UserStatusEnum.valueOf(createCustomerRequest.getStatus()));

    newCustomer.setCreatedAt(LocalDate.now());

    return this.customerRepository.save(newCustomer);
  }

  public List<Customer> GetAllCustomersService(){
    return this.customerRepository.findAll();
  }

  public Customer GetCustomerByIdService(UUID id){
    return this.customerRepository.findById(id).get();
  }

  public Customer ReplaceCustomerService(UUID id, 
    ReplaceCustomerRequest replaceCustomerRequest){
      
      Customer customer = GetCustomerByIdService(id);
      customer.setAddress(replaceCustomerRequest.getAddress());
      customer.setFullName(replaceCustomerRequest.getFullName());
      customer.setGender(replaceCustomerRequest.getGender());
      customer.setPhone(replaceCustomerRequest.getPhone());
      customer.setUpdatedAt(LocalDate.now());

    return customer;
  }

  public Customer UpdateCustomerService(UUID id,
    UpdateCustomerRequest updateCustomerRequest){
      Customer customer = GetCustomerByIdService(id);

      if(updateCustomerRequest.getAddress() != null){
        customer.setAddress(updateCustomerRequest.getAddress());
      }

      if(updateCustomerRequest.getFullName() != null){
        customer.setFullName(updateCustomerRequest.getFullName());
      }

      if(updateCustomerRequest.getGender() != null){
        customer.setGender(updateCustomerRequest.getGender());
      }
      
      if(updateCustomerRequest.getPhone() != null){
        customer.setPhone(updateCustomerRequest.getPhone());
      }
      customer.setUpdatedAt(LocalDate.now());

    return customer;
  }

  public void DeleteCustomerService(UUID id){
    this.customerRepository.deleteById(id);
  }

}
