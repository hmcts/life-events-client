package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import javax.validation.Valid;

/**
 * Details of the previous record, where one exists
 */
@ApiModel(description = "Details of the previous record, where one exists")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class PreviousRegistration   {
  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("systemNumber")
  private Integer systemNumber;

  public PreviousRegistration date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the event
   * @return date
  */
  @ApiModelProperty(example = "Tue Aug 09 01:00:00 BST 2011", value = "Date of the event")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PreviousRegistration systemNumber(Integer systemNumber) {
    this.systemNumber = systemNumber;
    return this;
  }

  /**
   * System number for this event
   * @return systemNumber
  */
  @ApiModelProperty(value = "System number for this event")


  public Integer getSystemNumber() {
    return systemNumber;
  }

  public void setSystemNumber(Integer systemNumber) {
    this.systemNumber = systemNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreviousRegistration previousRegistration = (PreviousRegistration) o;
    return Objects.equals(this.date, previousRegistration.date) &&
        Objects.equals(this.systemNumber, previousRegistration.systemNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, systemNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviousRegistration {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    systemNumber: ").append(toIndentedString(systemNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

