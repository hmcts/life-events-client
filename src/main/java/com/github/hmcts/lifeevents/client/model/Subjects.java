package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * People involved, may have keys parent1,parent2,child
 */

@Schema(name = "Subjects", description = "People involved, may have keys parent1,parent2,child")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class Subjects {

  private Child child;

  private Father father;

  private Mother mother;

  private Informant informant;

  public Subjects child(Child child) {
    this.child = child;
    return this;
  }

  /**
   * Get child
   * @return child
  */
  @Valid
  @Schema(name = "child", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("child")
  public Child getChild() {
    return child;
  }

  public void setChild(Child child) {
    this.child = child;
  }

  public Subjects father(Father father) {
    this.father = father;
    return this;
  }

  /**
   * Get father
   * @return father
  */
  @Valid
  @Schema(name = "father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("father")
  public Father getFather() {
    return father;
  }

  public void setFather(Father father) {
    this.father = father;
  }

  public Subjects mother(Mother mother) {
    this.mother = mother;
    return this;
  }

  /**
   * Get mother
   * @return mother
  */
  @Valid
  @Schema(name = "mother", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mother")
  public Mother getMother() {
    return mother;
  }

  public void setMother(Mother mother) {
    this.mother = mother;
  }

  public Subjects informant(Informant informant) {
    this.informant = informant;
    return this;
  }

  /**
   * Get informant
   * @return informant
  */
  @Valid
  @Schema(name = "informant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("informant")
  public Informant getInformant() {
    return informant;
  }

  public void setInformant(Informant informant) {
    this.informant = informant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subjects subjects = (Subjects) o;
    return Objects.equals(this.child, subjects.child) &&
        Objects.equals(this.father, subjects.father) &&
        Objects.equals(this.mother, subjects.mother) &&
        Objects.equals(this.informant, subjects.informant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(child, father, mother, informant);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subjects {\n");
    sb.append("    child: ").append(toIndentedString(child)).append("\n");
    sb.append("    father: ").append(toIndentedString(father)).append("\n");
    sb.append("    mother: ").append(toIndentedString(mother)).append("\n");
    sb.append("    informant: ").append(toIndentedString(informant)).append("\n");
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

