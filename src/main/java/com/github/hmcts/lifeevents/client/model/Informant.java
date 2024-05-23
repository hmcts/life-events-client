package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * Informant
 */
@ApiModel(description = "Informant")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Informant   {
  @JsonProperty("name")
  private Name name;

  @JsonProperty("usualAddress")
  private String usualAddress;

  @JsonProperty("qualification")
  private String qualification;

  @JsonProperty("signature")
  private String signature;

  public Informant name(Name name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")

  @Valid

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
  @ApiModelProperty(example = "34 Matriarchs Place, Mumstown, Mumford", value = "The usual address of the person, if different from the mother's")


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
  @ApiModelProperty(example = "Mother", value = "The qualification of the informant")


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
  @ApiModelProperty(example = "J. Smith", value = "The signature of the informant")


  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

