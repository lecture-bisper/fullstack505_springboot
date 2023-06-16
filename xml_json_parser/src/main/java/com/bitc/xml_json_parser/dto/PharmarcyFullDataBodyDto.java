package com.bitc.xml_json_parser.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PharmarcyFullDataBodyDto {
  private int numOfRows;
  private int pageNo;
  private int totalCount;
  private PharmarcyFullDataItemsDto items;

  @XmlElement
  public int getNumOfRows() {
    return numOfRows;
  }

  public void setNumOfRows(int numOfRows) {
    this.numOfRows = numOfRows;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  @XmlElement(name = "items")
  public PharmarcyFullDataItemsDto getItems() {
    return items;
  }

  public void setItems(PharmarcyFullDataItemsDto items) {
    this.items = items;
  }
}
