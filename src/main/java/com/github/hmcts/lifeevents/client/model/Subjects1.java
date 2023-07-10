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

public class Subjects1   {
  @JsonProperty("child")
  private Child1 child;

  @JsonProperty("father")
  private Father father;

  @JsonProperty("mother")
  private Mother mother;

  @JsonProperty("informant")
  private Informant informant;

  public Subjects1 child(Child1 child) {
    this.child = child;
    return this;
  }

  /**
   * Get child
   * @return child
  */
  @ApiModelProperty(value = "")

  @Valid

  public Child1 getChild() {
    return child;
  }

  public void setChild(Child1 child) {
    this.child = child;
  }

  public Subjects1 father(Father father) {
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

  public Subjects1 mother(Mother mother) {
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

  public Subjects1 informant(Informant informant) {
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
    Subjects1 subjects1 = (Subjects1) o;
    return Objects.equals(this.child, subjects1.child) &&
        Objects.equals(this.father, subjects1.father) &&
        Objects.equals(this.mother, subjects1.mother) &&
        Objects.equals(this.informant, subjects1.informant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(child, father, mother, informant);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subjects1 {\n");

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

