package iceShop.backend.domain;


import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ices")
@Getter
@Setter
@NoArgsConstructor
public class IceProduct{
  @Id
  private UUID id;
  
  @OneToOne(cascade = CascadeType.ALL)
  @MapsId
  @JoinColumn(name = "id")
  private Product product;

  private String iceType;
}
