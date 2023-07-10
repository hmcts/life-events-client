package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * The mother of the child that was born
 */
@ApiModel(description = "The mother of the child that was born")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Mother1   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("maidenSurname")
  private String maidenSurname;

  @JsonProperty("marriageSurname")
  private String marriageSurname;

  @JsonProperty("birthplace")
  private String birthplace;

  @JsonProperty("occupation")
  private String occupation;

  @JsonProperty("address")
  private String address;

  public Mother1 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the mother
   * @return forenames
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", required = true, value = "Forenames of the mother")
  @NotNull


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Mother1 surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the mother
   * @return surname
  */
  @ApiModelProperty(example = "SMITH", required = true, value = "Surname of the mother")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Mother1 maidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
    return this;
  }

  /**
   * Maiden name of the mother
   * @return maidenSurname
  */
  @ApiModelProperty(example = "BLACK", value = "Maiden name of the mother")


  public String getMaidenSurname() {
    return maidenSurname;
  }

  public void setMaidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
  }

  public Mother1 marriageSurname(String marriageSurname) {
    this.marriageSurname = marriageSurname;
    return this;
  }

  /**
   * Surname of the mother at marriage (if different from her maiden name)
   * @return marriageSurname
  */
  @ApiModelProperty(example = "WHITE", value = "Surname of the mother at marriage (if different from her maiden name)")


  public String getMarriageSurname() {
    return marriageSurname;
  }

  public void setMarriageSurname(String marriageSurname) {
    this.marriageSurname = marriageSurname;
  }

  public Mother1 birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the mother
   * @return birthplace
  */
  @ApiModelProperty(example = "Kensington", value = "The birthplace of the mother")


  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Mother1 occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the mother
   * @return occupation
  */
  @ApiModelProperty(example = "Carpenter", value = "The occupation of the mother")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Mother1 address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The mother's usual address (if different from the place of child's birth)
   * @return address
  */
  @ApiModelProperty(example = "34 Matriarchs Place, Mumstown, Mumford", value = "The mother's usual address (if different from the place of child's birth)")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mother1 mother1 = (Mother1) o;
    return Objects.equals(this.forenames, mother1.forenames) &&
        Objects.equals(this.surname, mother1.surname) &&
        Objects.equals(this.maidenSurname, mother1.maidenSurname) &&
        Objects.equals(this.marriageSurname, mother1.marriageSurname) &&
        Objects.equals(this.birthplace, mother1.birthplace) &&
        Objects.equals(this.occupation, mother1.occupation) &&
        Objects.equals(this.address, mother1.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, maidenSurname, marriageSurname, birthplace, occupation, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mother1 {\n");
    
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    maidenSurname: ").append(toIndentedString(maidenSurname)).append("\n");
    sb.append("    marriageSurname: ").append(toIndentedString(marriageSurname)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

