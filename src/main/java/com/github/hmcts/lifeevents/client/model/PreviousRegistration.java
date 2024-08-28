package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Details of the previous record, where one exists
 */

@Schema(name = "Previous_registration", description = "Details of the previous record, where one exists")
@JsonTypeName("Previous_registration")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class PreviousRegistration {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private Integer systemNumber;

  public PreviousRegistration date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the event
   * @return date
  */
  @Valid
  @Schema(name = "date", example = "Tue Aug 09 01:00:00 BST 2011", description = "Date of the event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
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

  @Schema(name = "systemNumber", description = "System number for this event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("systemNumber")
  public Integer getSystemNumber() {
    return systemNumber;
  }

  public void setSystemNumber(Integer systemNumber) {
    this.systemNumber = systemNumber;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

