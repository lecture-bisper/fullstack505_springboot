package com.bitc.board3.dto;

import lombok.Data;

@Data
public class AddressDto {
  private int addressId;
  private String address;
  private String address2;
  private String district;
  private int cityId;
  private String postalCode;
  private String phone;
  private String lastUpdate;
}
