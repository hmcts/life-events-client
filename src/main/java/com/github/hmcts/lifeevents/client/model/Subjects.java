package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import jakarta.validation.Valid;

/**
 * People involved, may have keys parent1,parent2,child
 */
@ApiModel(description = "People involved, may have keys parent1,parent2,child")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Subjects   {
  @JsonProperty("child")
  private Child child;

  @JsonProperty("father")
  private Father father;

  @JsonProperty("mother")
  private Mother mother;

  @JsonProperty("informant")
  private Informant informant;

  public Subjects child(Child child) {
    this.child = child;
    return this;
  }

  /**
   * Get child
   * @return child
  */
  @ApiModelProperty(value = "")

  @Valid

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
  @ApiModelProperty(value = "")

  @Valid

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
  @ApiModelProperty(value = "")

  @Valid

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
  @ApiModelProperty(value = "")

  @Valid

  public Informant getInformant() {
    return informant;
  }

  public void setInformant(Informant informant) {
    this.informant = informant;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

