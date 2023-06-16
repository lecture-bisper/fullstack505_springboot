package com.bitc.xml_json_parser.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

// @XmlRootElement : xml 데이터에서 부모가 되는 태그를 뜻하는 어노테이션
// @XmlElement : xml 데이터에서 실제 데이터가 들어있는 태그를 뜻하는 어노테이션
// @XmlAttribute : xml 데이터에서 지정한 태그의 속성을 뜻함
@XmlRootElement(name = "response")
public class PharmarcyFullDataDto {
  private PharmarcyFullDataHeaderDto header;
  private PharmarcyFullDataBodyDto body;

  @XmlElement(name = "header")
  public PharmarcyFullDataHeaderDto getHeader() {
    return header;
  }

  public void setHeader(PharmarcyFullDataHeaderDto header) {
    this.header = header;
  }

  @XmlElement(name = "body")
  public PharmarcyFullDataBodyDto getBody() {
    return body;
  }

  public void setBody(PharmarcyFullDataBodyDto body) {
    this.body = body;
  }
}
