package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Informant
 */

@Schema(name = "Informant", description = "Informant")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Informant {

  private Name name;

  private String usualAddress;

  private String qualification;

  private String signature;

  public Informant name(Name name) {
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

  public Informant usualAddress(String usualAddress) {
    this.usualAddress = usualAddress;
    return this;
  }

  /**
   * The usual address of the person, if different from the mother's
   * @return usualAddress
  */

  @Schema(name = "usualAddress", example = "34 Matriarchs Place, Mumstown, Mumford", description = "The usual address of the person, if different from the mother's", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usualAddress")
  public String getUsualAddress() {
    return usualAddress;
  }

  public void setUsualAddress(String usualAddress) {
    this.usualAddress = usualAddress;
  }

  public Informant qualification(String qualification) {
    this.qualification = qualification;
    return this;
  }

  /**
   * The qualification of the informant
   * @return qualification
  */

  @Schema(name = "qualification", example = "Mother", description = "The qualification of the informant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("qualification")
  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  public Informant signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * The signature of the informant
   * @return signature
  */

  @Schema(name = "signature", example = "J. Smith", description = "The signature of the informant", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("signature")
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Informant informant = (Informant) o;
    return Objects.equals(this.name, informant.name) &&
        Objects.equals(this.usualAddress, informant.usualAddress) &&
        Objects.equals(this.qualification, informant.qualification) &&
        Objects.equals(this.signature, informant.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, usualAddress, qualification, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Informant {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    usualAddress: ").append(toIndentedString(usualAddress)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
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

