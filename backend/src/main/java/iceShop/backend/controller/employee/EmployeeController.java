package iceShop.backend.controller.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iceShop.backend.domain.Employee;
import iceShop.backend.dto.employee.EmployeeDTO;
import iceShop.backend.mapper.EmployeeMapper;
import iceShop.backend.request.employee.CreateEmployeeRequest;
import iceShop.backend.request.employee.ReplaceEmployeeRequest;
import iceShop.backend.request.employee.UpdateEmployeeRequest;
import iceShop.backend.response.ApiResponse;
import iceShop.backend.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Object> CreateEmployee(
    @Valid @RequestBody CreateEmployeeRequest createEmployeeRequest
  ){
    Employee newEmployee = this.employeeService.CreateEmployeeService(createEmployeeRequest);
    EmployeeDTO employeeDTO = EmployeeMapper.toDTO(newEmployee);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.CREATED.value());
    apiResponse.setError(null);
    apiResponse.setTotalObjects((long) 1);
    apiResponse.setData(employeeDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
  }

  @GetMapping
  public ResponseEntity<Object> GetAllEmployees() {
    
    List<EmployeeDTO> employeeDTOs = new ArrayList<>();
    List<Employee> employees = this.employeeService.GetAllEmployeesService();
    ApiResponse apiResponse =  new ApiResponse();

    for(Employee e : employees){
      EmployeeDTO employeeDTO = EmployeeMapper.toDTO(e);
      employeeDTOs.add(employeeDTO);
    }

    Long total = (long) employeeDTOs.size();
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects(total);
    apiResponse.setData(employeeDTOs);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @GetMapping("/id")
  public ResponseEntity<Object> GetEmployeeById(@PathVariable UUID id) {
    
    Employee employee = this.employeeService.GetEmployeeByIdService(id);
    EmployeeDTO employeeDTO = EmployeeMapper.toDTO(employee);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(employeeDTO);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> DeleteEmployeeById(@PathVariable UUID id) {
    
    this.employeeService.DeleteEmployeeByIdService(id);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(null);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
  }

  @PutMapping("{id}")
  public ResponseEntity<Object> ReplaceEmployeeById(@PathVariable UUID id, 
    @Valid @RequestBody ReplaceEmployeeRequest replaceEmployeeRequest) {
      
    Employee employee = this.employeeService.ReplaceEmployeeByIdService(id, replaceEmployeeRequest);
    EmployeeDTO employeeDTO = EmployeeMapper.toDTO(employee);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(employeeDTO);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Object> UpdateEmployeeById(@PathVariable UUID id, 
    @Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest){

    Employee employee = this.employeeService.UpdateEmployeeByIdService(id, updateEmployeeRequest);
    EmployeeDTO employeeDTO = EmployeeMapper.toDTO(employee);
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setData(employeeDTO);
    apiResponse.setError(null);
    apiResponse.setMessage("Successfully");
    apiResponse.setStatusCode(HttpStatus.OK.value());
    apiResponse.setTotalObjects((long) 1);

    return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
  }
  
  

}
