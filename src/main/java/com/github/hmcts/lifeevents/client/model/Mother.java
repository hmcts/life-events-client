package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Mother
 */

@Schema(name = "Mother", description = "Mother")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Mother {

  private Name name;

  private String birthplace;

  private String occupation;

  private String maidenSurname;

  private String marriageSurname;

  private String usualAddress;

  public Mother name(Name name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @Valid
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Mother birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the person
   * @return birthplace
  */

  @Schema(name = "birthplace", example = "Kensington", description = "The birthplace of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthplace")
  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Mother occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the parent
   * @return occupation
  */

  @Schema(name = "occupation", example = "Carpenter", description = "The occupation of the parent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Mother maidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
    return this;
  }

  /**
   * Maiden surname
   * @return maidenSurname
  */

  @Schema(name = "maidenSurname", example = "Black", description = "Maiden surname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maidenSurname")
  public String getMaidenSurname() {
    return maidenSurname;
  }

  public void setMaidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
  }

  public Mother marriageSurname(String marriageSurname) {
    this.marriageSurname = marriageSurname;
    return this;
  }

  /**
   * Surname at marriage if different from maiden surname
   * @return marriageSurname
  */

  @Schema(name = "marriageSurname", example = "White", description = "Surname at marriage if different from maiden surname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("marriageSurname")
  public String getMarriageSurname() {
    return marriageSurname;
  }

  public void setMarriageSurname(String marriageSurname) {
    this.marriageSurname = marriageSurname;
  }

  public Mother usualAddress(String usualAddress) {
    this.usualAddress = usualAddress;
    return this;
  }

  /**
   * Usual address (if different from the place of child's birth)
   * @return usualAddress
  */

  @Schema(name = "usualAddress", example = "34 Matriarchs Place, Mumstown, Mumford", description = "Usual address (if different from the place of child's birth)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usualAddress")
  public String getUsualAddress() {
    return usualAddress;
  }

  public void setUsualAddress(String usualAddress) {
    this.usualAddress = usualAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mother mother = (Mother) o;
    return Objects.equals(this.name, mother.name) &&
        Objects.equals(this.birthplace, mother.birthplace) &&
        Objects.equals(this.occupation, mother.occupation) &&
        Objects.equals(this.maidenSurname, mother.maidenSurname) &&
        Objects.equals(this.marriageSurname, mother.marriageSurname) &&
        Objects.equals(this.usualAddress, mother.usualAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthplace, occupation, maidenSurname, marriageSurname, usualAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mother {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    maidenSurname: ").append(toIndentedString(maidenSurname)).append("\n");
    sb.append("    marriageSurname: ").append(toIndentedString(marriageSurname)).append("\n");
    sb.append("    usualAddress: ").append(toIndentedString(usualAddress)).append("\n");
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

