package iceShop.backend.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import iceShop.backend.Enum.UserStatusEnum;
import iceShop.backend.domain.Employee;
import iceShop.backend.repository.EmployeeRepository;
import iceShop.backend.request.employee.CreateEmployeeRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  // public Employee(String fullName,
  //   String phone,
  //   String address,
  //   String gender, 
  //   UserStatusEnum status,
  //   BigDecimal salary){
  //     super(fullName, phone, address, gender);
  //     this.status = status;
  //     this.salary = salary;
  // }

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


}
