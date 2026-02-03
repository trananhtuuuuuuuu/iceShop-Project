package iceShop.backend.domain;

import java.util.UUID;

import iceShop.backend.Enum.LeaveRequestStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="leave_requests")
@Getter
@Setter
public class LeaveRequest extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String title;
  private String description;
  private String reason;
  private LeaveRequestStatusEnum status;

  @ManyToOne
  @JoinColumn(name="employee_id")
  private Employee employee;
}
