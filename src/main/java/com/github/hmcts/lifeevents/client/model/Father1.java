package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * The father of the child that was born
 */
@ApiModel(description = "The father of the child that was born")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Father1   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("birthplace")
  private String birthplace;

  @JsonProperty("occupation")
  private String occupation;

  @JsonProperty("deceased")
  private Boolean deceased;

  public Father1 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the father
   * @return forenames
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", value = "Forenames of the father")


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Father1 surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the father
   * @return surname
  */
  @ApiModelProperty(example = "SMITH", value = "Surname of the father")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Father1 birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the father
   * @return birthplace
  */
  @ApiModelProperty(example = "Kensington", value = "The birthplace of the father")


  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Father1 occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the father
   * @return occupation
  */
  @ApiModelProperty(example = "Carpenter", value = "The occupation of the father")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Father1 deceased(Boolean deceased) {
    this.deceased = deceased;
    return this;
  }

  /**
   * Whether the father was deceased at the point of birth
   * @return deceased
  */
  @ApiModelProperty(example = "false", required = true, value = "Whether the father was deceased at the point of birth")
  @NotNull


  public Boolean getDeceased() {
    return deceased;
  }

  public void setDeceased(Boolean deceased) {
    this.deceased = deceased;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Father1 father1 = (Father1) o;
    return Objects.equals(this.forenames, father1.forenames) &&
        Objects.equals(this.surname, father1.surname) &&
        Objects.equals(this.birthplace, father1.birthplace) &&
        Objects.equals(this.occupation, father1.occupation) &&
        Objects.equals(this.deceased, father1.deceased);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, birthplace, occupation, deceased);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Father1 {\n");
    
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    deceased: ").append(toIndentedString(deceased)).append("\n");
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

