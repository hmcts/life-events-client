package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */

@Schema(name = "v1-Birth", description = "A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@JsonTypeName("v1-Birth")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class V1Birth {

  private Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private Child1 child;

  private Mother1 mother;

  private Father1 father;

  private Status1 status;

  /**
   * Default constructor
   * @deprecated Use {@link V1Birth#V1Birth(Integer, LocalDate, Child1, Mother1, Father1, Status1)}
   */
  @Deprecated
  public V1Birth() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public V1Birth(Integer id, LocalDate date, Child1 child, Mother1 mother, Father1 father, Status1 status) {
    this.id = id;
    this.date = date;
    this.child = child;
    this.mother = mother;
    this.father = father;
    this.status = status;
  }

  public V1Birth id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * System number for this event
   * @return id
  */
  @NotNull
  @Schema(name = "id", description = "System number for this event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
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
  @NotNull @Valid
  @Schema(name = "date", example = "Tue Aug 09 01:00:00 BST 2011", description = "Date the birth was registered", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public V1Birth child(Child1 child) {
    this.child = child;
    return this;
  }

  /**
   * Get child
   * @return child
  */
  @NotNull @Valid
  @Schema(name = "child", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("child")
  public Child1 getChild() {
    return child;
  }

  public void setChild(Child1 child) {
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
  @NotNull @Valid
  @Schema(name = "mother", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mother")
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
  @NotNull @Valid
  @Schema(name = "father", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("father")
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
  @NotNull @Valid
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Status1 getStatus() {
    return status;
  }

  public void setStatus(Status1 status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

