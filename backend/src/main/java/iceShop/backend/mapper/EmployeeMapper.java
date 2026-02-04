package iceShop.backend.mapper;

import iceShop.backend.domain.Employee;
import iceShop.backend.dto.employee.EmployeeDTO;

public class EmployeeMapper {
  public static EmployeeDTO toDTO(Employee employee){
    return new EmployeeDTO(
      employee.getFullName(),
      employee.getPhone(),
      employee.getAddress(),
      employee.getGender(),
      employee.getStatus().name(),
      employee.getSalary()
    );
  }
}
