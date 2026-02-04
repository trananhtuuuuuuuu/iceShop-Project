package iceShop.backend.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class User extends BaseEntity {
  private String fullName;
  private String phone;
  private String address;
  private String gender;
  public User(String fullName,
   String phone,
   String address,
   String gender){
    this.fullName = fullName;
    this.phone = phone;
    this.address = address;
    this.gender = gender;
  }
}
