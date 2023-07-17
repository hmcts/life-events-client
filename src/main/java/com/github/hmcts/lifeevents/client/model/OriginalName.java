package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The name originally given to the person
 */

@Schema(name = "Original_name", description = "The name originally given to the person")
@JsonTypeName("Original_name")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class OriginalName {

  private String givenName;

  private String surname;

  private String fullName;

  private String qualifier;

  public OriginalName givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * Given name of the person
   * @return givenName
  */

  @Schema(name = "givenName", example = "Joan Narcissus Ouroboros", description = "Given name of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("givenName")
  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public OriginalName surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */

  @Schema(name = "surname", example = "Smith", description = "Surname of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public OriginalName fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name of the person
   * @return fullName
  */

  @Schema(name = "fullName", example = "Joan Narcissus Ouroboros Smith", description = "Full name of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public OriginalName qualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  /**
   * Details about how the full name was made
   * @return qualifier
  */

  @Schema(name = "qualifier", example = "generated from prepending forename to surname", description = "Details about how the full name was made", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("qualifier")
  public String getQualifier() {
    return qualifier;
  }

  public void setQualifier(String qualifier) {
    this.qualifier = qualifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginalName originalName = (OriginalName) o;
    return Objects.equals(this.givenName, originalName.givenName) &&
        Objects.equals(this.surname, originalName.surname) &&
        Objects.equals(this.fullName, originalName.fullName) &&
        Objects.equals(this.qualifier, originalName.qualifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, surname, fullName, qualifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OriginalName {\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    qualifier: ").append(toIndentedString(qualifier)).append("\n");
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

