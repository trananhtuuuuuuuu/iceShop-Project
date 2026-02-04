package iceShop.backend.service;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


import org.springframework.stereotype.Service;

import iceShop.backend.Enum.UserStatusEnum;
import iceShop.backend.domain.Employee;
import iceShop.backend.repository.EmployeeRepository;
import iceShop.backend.request.employee.CreateEmployeeRequest;
import iceShop.backend.request.employee.ReplaceEmployeeRequest;
import iceShop.backend.request.employee.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public Employee CreateEmployeeService(CreateEmployeeRequest createEmployeeRequest){
    Employee employee = new Employee(createEmployeeRequest.getFullName(),
      createEmployeeRequest.getPhone(),
      createEmployeeRequest.getAddress(),
      createEmployeeRequest.getGender(),
      UserStatusEnum.valueOf(createEmployeeRequest.getStatus()),
      createEmployeeRequest.getSalary()
    );

    employee.setCreatedAt(LocalDate.now());
    return this.employeeRepository.save(employee);
  }

  public List<Employee> GetAllEmployeesService(){
    return this.employeeRepository.findAll();
  }


  public Employee GetEmployeeByIdService(UUID id){
    return this.employeeRepository.findById(id).get(); // need process Exception right here
  }


  public void DeleteEmployeeByIdService(UUID id){
    this.employeeRepository.deleteById(id);
  }

  public Employee ReplaceEmployeeByIdService(UUID id, 
    ReplaceEmployeeRequest replaceEmployeeRequest){

    Employee employee = GetEmployeeByIdService(id);
    employee.setAddress(replaceEmployeeRequest.getAddress());
    employee.setFullName(replaceEmployeeRequest.getFullName());
    employee.setGender(replaceEmployeeRequest.getGender());
    employee.setPhone(replaceEmployeeRequest.getPhone());
    employee.setSalary(replaceEmployeeRequest.getSalary());
    employee.setStatus(UserStatusEnum.valueOf(replaceEmployeeRequest.getStatus()));
    employee.setUpdatedAt(LocalDate.now());

    return this.employeeRepository.save(employee);
  }

  public Employee UpdateEmployeeByIdService(UUID id, 
    UpdateEmployeeRequest updateEmployeeRequest){

    Employee employee = GetEmployeeByIdService(id);
    if(updateEmployeeRequest.getFullName() != null){
      employee.setFullName(updateEmployeeRequest.getFullName());
    }

    if(updateEmployeeRequest.getAddress() != null){
      employee.setAddress(updateEmployeeRequest.getAddress());
    }

    if(updateEmployeeRequest.getGender() != null){
      employee.setGender(updateEmployeeRequest.getGender());
    }

    if(updateEmployeeRequest.getPhone() != null){
      employee.setPhone(updateEmployeeRequest.getPhone());
    }

    if(updateEmployeeRequest.getSalary() != null){
      employee.setSalary(updateEmployeeRequest.getSalary());
    }

    if(updateEmployeeRequest.getStatus() != null){
      employee.setStatus(UserStatusEnum.valueOf(updateEmployeeRequest.getStatus()));
    }
    
    employee.setUpdatedAt(LocalDate.now());
    return this.employeeRepository.save(employee);
  }


}
