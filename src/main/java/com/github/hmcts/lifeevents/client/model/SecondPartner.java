package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The second partner
 */
@ApiModel(description = "The second partner")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class SecondPartner   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("dateOfBirth")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  /**
   * Sex of the person
   */
  public enum SexEnum {
    MALE("Male"),
    
    FEMALE("Female"),
    
    INDETERMINATE("Indeterminate");

    private String value;

    SexEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("sex")
  private SexEnum sex;

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

  public SecondPartner forenames(String forenames) {
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

  public SecondPartner surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */
  @ApiModelProperty(example = "BLACK", required = true, value = "Surname of the person")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public SecondPartner dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date the person was born
   * @return dateOfBirth
  */
  @ApiModelProperty(example = "Mon Aug 08 01:00:00 BST 2011", value = "Date the person was born")

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public SecondPartner sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Sex of the person
   * @return sex
  */
  @ApiModelProperty(example = "Indeterminate", value = "Sex of the person")


  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public SecondPartner occupation(String occupation) {
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

  public SecondPartner retired(Boolean retired) {
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

  public SecondPartner address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The person's address
   * @return address
  */
  @ApiModelProperty(example = "888 Bride House, 8 Bride grove, Wedford, Wedfordshire, BR1 2E", value = "The person's address")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SecondPartner condition(String condition) {
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

  public SecondPartner signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * A digital representation of the person's signature
   * @return signature
  */
  @ApiModelProperty(example = "J.N.O. Black", value = "A digital representation of the person's signature")


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
    SecondPartner secondPartner = (SecondPartner) o;
    return Objects.equals(this.forenames, secondPartner.forenames) &&
        Objects.equals(this.surname, secondPartner.surname) &&
        Objects.equals(this.dateOfBirth, secondPartner.dateOfBirth) &&
        Objects.equals(this.sex, secondPartner.sex) &&
        Objects.equals(this.occupation, secondPartner.occupation) &&
        Objects.equals(this.retired, secondPartner.retired) &&
        Objects.equals(this.address, secondPartner.address) &&
        Objects.equals(this.condition, secondPartner.condition) &&
        Objects.equals(this.signature, secondPartner.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, dateOfBirth, sex, occupation, retired, address, condition, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecondPartner {\n");
    
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
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

