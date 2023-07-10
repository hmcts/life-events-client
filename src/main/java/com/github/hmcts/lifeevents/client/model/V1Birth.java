package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */
@ApiModel(description = "A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class V1Birth   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("child")
  private Child2 child;

  @JsonProperty("mother")
  private Mother1 mother;

  @JsonProperty("father")
  private Father1 father;

  @JsonProperty("status")
  private Status1 status;

  public V1Birth id(Integer id) {
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

  public V1Birth date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date the birth was registered
   * @return date
  */
  @ApiModelProperty(example = "Tue Aug 09 01:00:00 BST 2011", required = true, value = "Date the birth was registered")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public V1Birth child(Child2 child) {
    this.child = child;
    return this;
  }

  /**
   * Get child
   * @return child
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Child2 getChild() {
    return child;
  }

  public void setChild(Child2 child) {
    this.child = child;
  }

  public V1Birth mother(Mother1 mother) {
    this.mother = mother;
    return this;
  }

  /**
   * Get mother
   * @return mother
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Mother1 getMother() {
    return mother;
  }

  public void setMother(Mother1 mother) {
    this.mother = mother;
  }

  public V1Birth father(Father1 father) {
    this.father = father;
    return this;
  }

  /**
   * Get father
   * @return father
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Father1 getFather() {
    return father;
  }

  public void setFather(Father1 father) {
    this.father = father;
  }

  public V1Birth status(Status1 status) {
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

  public Status1 getStatus() {
    return status;
  }

  public void setStatus(Status1 status) {
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
    V1Birth v1Birth = (V1Birth) o;
    return Objects.equals(this.id, v1Birth.id) &&
        Objects.equals(this.date, v1Birth.date) &&
        Objects.equals(this.child, v1Birth.child) &&
        Objects.equals(this.mother, v1Birth.mother) &&
        Objects.equals(this.father, v1Birth.father) &&
        Objects.equals(this.status, v1Birth.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, child, mother, father, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Birth {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    child: ").append(toIndentedString(child)).append("\n");
    sb.append("    mother: ").append(toIndentedString(mother)).append("\n");
    sb.append("    father: ").append(toIndentedString(father)).append("\n");
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

