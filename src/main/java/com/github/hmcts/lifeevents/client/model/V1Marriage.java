package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A record of a marriage (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */
@ApiModel(description = "A record of a marriage (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class V1Marriage   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("dateOfMarriage")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfMarriage;

  @JsonProperty("groom")
  private Groom groom;

  @JsonProperty("bride")
  private Bride bride;

  @JsonProperty("status")
  private Status2 status;

  public V1Marriage id(Integer id) {
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

  public V1Marriage dateOfMarriage(LocalDate dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
    return this;
  }

  /**
   * Date of the marriage
   * @return dateOfMarriage
  */
  @ApiModelProperty(example = "Fri Aug 08 01:00:00 BST 2008", required = true, value = "Date of the marriage")
  @NotNull

  @Valid

  public LocalDate getDateOfMarriage() {
    return dateOfMarriage;
  }

  public void setDateOfMarriage(LocalDate dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
  }

  public V1Marriage groom(Groom groom) {
    this.groom = groom;
    return this;
  }

  /**
   * Get groom
   * @return groom
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Groom getGroom() {
    return groom;
  }

  public void setGroom(Groom groom) {
    this.groom = groom;
  }

  public V1Marriage bride(Bride bride) {
    this.bride = bride;
    return this;
  }

  /**
   * Get bride
   * @return bride
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Bride getBride() {
    return bride;
  }

  public void setBride(Bride bride) {
    this.bride = bride;
  }

  public V1Marriage status(Status2 status) {
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
    V1Marriage v1Marriage = (V1Marriage) o;
    return Objects.equals(this.id, v1Marriage.id) &&
        Objects.equals(this.dateOfMarriage, v1Marriage.dateOfMarriage) &&
        Objects.equals(this.groom, v1Marriage.groom) &&
        Objects.equals(this.bride, v1Marriage.bride) &&
        Objects.equals(this.status, v1Marriage.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateOfMarriage, groom, bride, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Marriage {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateOfMarriage: ").append(toIndentedString(dateOfMarriage)).append("\n");
    sb.append("    groom: ").append(toIndentedString(groom)).append("\n");
    sb.append("    bride: ").append(toIndentedString(bride)).append("\n");
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

