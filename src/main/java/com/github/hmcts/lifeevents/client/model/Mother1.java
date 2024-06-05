package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * The mother of the child that was born
 */

@Schema(name = "Mother_1", description = "The mother of the child that was born")
@JsonTypeName("Mother_1")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Mother1 {

  private String forenames;

  private String surname;

  private String maidenSurname;

  private String marriageSurname;

  private String birthplace;

  private String occupation;

  private String address;

  /**
   * Default constructor
   * @deprecated Use {@link Mother1#Mother1(String, String)}
   */
  @Deprecated
  public Mother1() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Mother1(String forenames, String surname) {
    this.forenames = forenames;
    this.surname = surname;
  }

  public Mother1 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the mother
   * @return forenames
  */
  @NotNull
  @Schema(name = "forenames", example = "Joan Narcissus Ouroboros", description = "Forenames of the mother", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("forenames")
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
  @NotNull
  @Schema(name = "surname", example = "SMITH", description = "Surname of the mother", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
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

  @Schema(name = "maidenSurname", example = "BLACK", description = "Maiden name of the mother", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maidenSurname")
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

  @Schema(name = "marriageSurname", example = "WHITE", description = "Surname of the mother at marriage (if different from her maiden name)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("marriageSurname")
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

  @Schema(name = "birthplace", example = "Kensington", description = "The birthplace of the mother", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthplace")
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

  @Schema(name = "occupation", example = "Carpenter", description = "The occupation of the mother", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
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

  @Schema(name = "address", example = "34 Matriarchs Place, Mumstown, Mumford", description = "The mother's usual address (if different from the place of child's birth)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

