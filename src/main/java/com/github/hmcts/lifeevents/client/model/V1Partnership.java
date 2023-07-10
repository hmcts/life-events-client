package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A record of a civil partnership (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */
@ApiModel(description = "A record of a civil partnership (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class V1Partnership   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("dateOfPartnership")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfPartnership;

  @JsonProperty("partner1")
  private FirstPartner partner1;

  @JsonProperty("partner2")
  private SecondPartner partner2;

  @JsonProperty("status")
  private Status2 status;

  public V1Partnership id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * System number for this event
   * @return id
  */
  @ApiModelProperty(required = true, value = "System number for this event")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public V1Partnership dateOfPartnership(LocalDate dateOfPartnership) {
    this.dateOfPartnership = dateOfPartnership;
    return this;
  }

  /**
   * Date of the civil partnership
   * @return dateOfPartnership
  */
  @ApiModelProperty(example = "Fri Aug 08 01:00:00 BST 2008", required = true, value = "Date of the civil partnership")
  @NotNull

  @Valid

  public LocalDate getDateOfPartnership() {
    return dateOfPartnership;
  }

  public void setDateOfPartnership(LocalDate dateOfPartnership) {
    this.dateOfPartnership = dateOfPartnership;
  }

  public V1Partnership partner1(FirstPartner partner1) {
    this.partner1 = partner1;
    return this;
  }

  /**
   * Get partner1
   * @return partner1
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public FirstPartner getPartner1() {
    return partner1;
  }

  public void setPartner1(FirstPartner partner1) {
    this.partner1 = partner1;
  }

  public V1Partnership partner2(SecondPartner partner2) {
    this.partner2 = partner2;
    return this;
  }

  /**
   * Get partner2
   * @return partner2
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SecondPartner getPartner2() {
    return partner2;
  }

  public void setPartner2(SecondPartner partner2) {
    this.partner2 = partner2;
  }

  public V1Partnership status(Status2 status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Status2 getStatus() {
    return status;
  }

  public void setStatus(Status2 status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Partnership v1Partnership = (V1Partnership) o;
    return Objects.equals(this.id, v1Partnership.id) &&
        Objects.equals(this.dateOfPartnership, v1Partnership.dateOfPartnership) &&
        Objects.equals(this.partner1, v1Partnership.partner1) &&
        Objects.equals(this.partner2, v1Partnership.partner2) &&
        Objects.equals(this.status, v1Partnership.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateOfPartnership, partner1, partner2, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Partnership {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateOfPartnership: ").append(toIndentedString(dateOfPartnership)).append("\n");
    sb.append("    partner1: ").append(toIndentedString(partner1)).append("\n");
    sb.append("    partner2: ").append(toIndentedString(partner2)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

