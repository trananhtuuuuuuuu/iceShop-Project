package iceShop.backend.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class User extends BaseEntity {
  private String fullName;
  private String phone;
  private String address;
  private String gender;
}
