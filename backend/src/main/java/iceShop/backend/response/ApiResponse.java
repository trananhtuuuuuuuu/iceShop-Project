package iceShop.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
  private String message;
  private int statusCode;
  private String error;
  private Long totalObjects;
  private Object data;
}
