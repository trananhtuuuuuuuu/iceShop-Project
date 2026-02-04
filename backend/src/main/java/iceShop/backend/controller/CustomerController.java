package iceShop.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iceShop.backend.domain.Customer;
import iceShop.backend.dto.customer.CustomerDTO;
import iceShop.backend.mapper.CustomerMapper;
import iceShop.backend.request.customer.CreateCustomerRequest;
import iceShop.backend.request.customer.ReplaceCustomerRequest;
import iceShop.backend.request.customer.UpdateCustomerRequest;
import iceShop.backend.response.ApiResponse;
import iceShop.backend.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
  
  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity<Object> CreateCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
    Customer customer = this.customerService.CreateCustomerService(createCustomerRequest);

    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(CustomerMapper.toDTO(customer));
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.CREATED.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }

  @GetMapping
  public ResponseEntity<Object> GetAllCustomers(){
    List<Customer> customers = this.customerService.GetAllCustomersService();
    List<CustomerDTO> customerDTOs = CustomerMapper.toDTOs(customers);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(customerDTOs);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) customerDTOs.size());

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> GetCustomerById(@PathVariable UUID  id){
    Customer customer = this.customerService.GetCustomerByIdService(id);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(CustomerMapper.toDTO(customer));
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> ReplaceCustomer(@PathVariable UUID id,
    @Valid @RequestBody ReplaceCustomerRequest replaceCustomerRequest
  ){
    Customer customer = this.customerService.ReplaceCustomerService(id, replaceCustomerRequest);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(CustomerMapper.toDTO(customer));
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Object> UpdateCustomer(@PathVariable UUID id,
    @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest
  ){
    Customer customer = this.customerService.UpdateCustomerService(id, updateCustomerRequest);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(CustomerMapper.toDTO(customer));
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> DeleteCustomer(@PathVariable UUID id){
    this.customerService.DeleteCustomerService(id);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(null);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
  }

}
