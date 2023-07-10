package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A record of a birth (Note: You will only receive the fields you are authorized to view, otherwise &#x60;null&#x60;)
 */
@ApiModel(description = "A record of a birth (Note: You will only receive the fields you are authorized to view, otherwise `null`)")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class V01Birth   {
  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("location")
  private Location location;

  @JsonProperty("registrarSignature")
  private String registrarSignature;

  @JsonProperty("type")
  private String type;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("subjects")
  private Subjects1 subjects;

  @JsonProperty("systemNumber")
  private Integer systemNumber;

  @JsonProperty("status")
  private Status status;

  @JsonProperty("previousRegistration")
  private PreviousRegistration previousRegistration;

  public V01Birth date(LocalDate date) {
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

  public V01Birth location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public V01Birth registrarSignature(String registrarSignature) {
    this.registrarSignature = registrarSignature;
    return this;
  }

  /**
   * Signature of registrar
   * @return registrarSignature
  */
  @ApiModelProperty(example = "J. Smith", value = "Signature of registrar")


  public String getRegistrarSignature() {
    return registrarSignature;
  }

  public void setRegistrarSignature(String registrarSignature) {
    this.registrarSignature = registrarSignature;
  }

  public V01Birth type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the event
   * @return type
  */
  @ApiModelProperty(example = "birth", value = "Type of the event")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public V01Birth id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID for this event
   * @return id
  */
  @ApiModelProperty(required = true, value = "Unique ID for this event")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public V01Birth subjects(Subjects1 subjects) {
    this.subjects = subjects;
    return this;
  }

  /**
   * Get subjects
   * @return subjects
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Subjects1 getSubjects() {
    return subjects;
  }

  public void setSubjects(Subjects1 subjects) {
    this.subjects = subjects;
  }

  public V01Birth systemNumber(Integer systemNumber) {
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

  public V01Birth status(Status status) {
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

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public V01Birth previousRegistration(PreviousRegistration previousRegistration) {
    this.previousRegistration = previousRegistration;
    return this;
  }

  /**
   * Get previousRegistration
   * @return previousRegistration
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PreviousRegistration getPreviousRegistration() {
    return previousRegistration;
  }

  public void setPreviousRegistration(PreviousRegistration previousRegistration) {
    this.previousRegistration = previousRegistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V01Birth v01Birth = (V01Birth) o;
    return Objects.equals(this.date, v01Birth.date) &&
        Objects.equals(this.location, v01Birth.location) &&
        Objects.equals(this.registrarSignature, v01Birth.registrarSignature) &&
        Objects.equals(this.type, v01Birth.type) &&
        Objects.equals(this.id, v01Birth.id) &&
        Objects.equals(this.subjects, v01Birth.subjects) &&
        Objects.equals(this.systemNumber, v01Birth.systemNumber) &&
        Objects.equals(this.status, v01Birth.status) &&
        Objects.equals(this.previousRegistration, v01Birth.previousRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, location, registrarSignature, type, id, subjects, systemNumber, status, previousRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V01Birth {\n");

    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    registrarSignature: ").append(toIndentedString(registrarSignature)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
    sb.append("    systemNumber: ").append(toIndentedString(systemNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    previousRegistration: ").append(toIndentedString(previousRegistration)).append("\n");
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

