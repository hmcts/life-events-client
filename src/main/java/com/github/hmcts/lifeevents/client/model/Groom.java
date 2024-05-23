package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * The groom (or first partner)
 */
@ApiModel(description = "The groom (or first partner)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Groom   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("occupation")
  private String occupation;

  @JsonProperty("retired")
  private Boolean retired;

  @JsonProperty("address")
  private String address;

  @JsonProperty("condition")
  private String condition;

  @JsonProperty("signature")
  private String signature;

  public Groom forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the person
   * @return forenames
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", required = true, value = "Forenames of the person")
  @NotNull


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Groom surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */
  @ApiModelProperty(example = "SMITH", required = true, value = "Surname of the person")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Groom age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Age of the person when they got married
   * @return age
  */
  @ApiModelProperty(value = "Age of the person when they got married")


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Groom occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the person
   * @return occupation
  */
  @ApiModelProperty(example = "Unemployed", value = "The occupation of the person")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Groom retired(Boolean retired) {
    this.retired = retired;
    return this;
  }

  /**
   * Whether the person was retired
   * @return retired
  */
  @ApiModelProperty(example = "false", value = "Whether the person was retired")


  public Boolean getRetired() {
    return retired;
  }

  public void setRetired(Boolean retired) {
    this.retired = retired;
  }

  public Groom address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The person's address
   * @return address
  */
  @ApiModelProperty(example = "888 Groom House, 8 Groom grove, Wedford, Wedfordshire, GR0 0M", value = "The person's address")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Groom condition(String condition) {
    this.condition = condition;
    return this;
  }

  /**
   * Whether the person was single, divorced, widowed etc.
   * @return condition
  */
  @ApiModelProperty(example = "Single", required = true, value = "Whether the person was single, divorced, widowed etc.")
  @NotNull


  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public Groom signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * A digital representation of the person's signature
   * @return signature
  */
  @ApiModelProperty(example = "J.N.O. Smith", value = "A digital representation of the person's signature")


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
    Groom groom = (Groom) o;
    return Objects.equals(this.forenames, groom.forenames) &&
        Objects.equals(this.surname, groom.surname) &&
        Objects.equals(this.age, groom.age) &&
        Objects.equals(this.occupation, groom.occupation) &&
        Objects.equals(this.retired, groom.retired) &&
        Objects.equals(this.address, groom.address) &&
        Objects.equals(this.condition, groom.condition) &&
        Objects.equals(this.signature, groom.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, age, occupation, retired, address, condition, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Groom {\n");
    
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    retired: ").append(toIndentedString(retired)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
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

