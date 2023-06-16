package com.bitc.xml_json_parser.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class PharmarcyFullDataItemsDto {
  private List<PharmarcyFullDataItemDto> itemList;

  @XmlElement(name = "item")
  public List<PharmarcyFullDataItemDto> getItemList() {
    return itemList;
  }

  public void setItemList(List<PharmarcyFullDataItemDto> itemList) {
    this.itemList = itemList;
  }
}
