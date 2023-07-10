package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * The child that was born
 */
@ApiModel(description = "The child that was born")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Child2   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("originalForenames")
  private String originalForenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("dateOfBirth")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  /**
   * Sex of the child
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

  @JsonProperty("birthplace")
  private String birthplace;

  public Child2 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the child
   * @return forenames
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", required = true, value = "Forenames of the child")
  @NotNull


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Child2 originalForenames(String originalForenames) {
    this.originalForenames = originalForenames;
    return this;
  }

  /**
   * The forenames originally given to the child before they were changed
   * @return originalForenames
  */
  @ApiModelProperty(example = "John Narcissus Ouroboros", value = "The forenames originally given to the child before they were changed")


  public String getOriginalForenames() {
    return originalForenames;
  }

  public void setOriginalForenames(String originalForenames) {
    this.originalForenames = originalForenames;
  }

  public Child2 surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the child
   * @return surname
  */
  @ApiModelProperty(example = "SMITH", required = true, value = "Surname of the child")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Child2 dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date of birth of the child
   * @return dateOfBirth
  */
  @ApiModelProperty(example = "Mon Aug 08 01:00:00 BST 2011", required = true, value = "Date of birth of the child")
  @NotNull

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Child2 sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Sex of the child
   * @return sex
  */
  @ApiModelProperty(example = "Indeterminate", required = true, value = "Sex of the child")
  @NotNull


  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Child2 birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the child
   * @return birthplace
  */
  @ApiModelProperty(example = "Kensington", value = "The birthplace of the child")


  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Child2 child2 = (Child2) o;
    return Objects.equals(this.forenames, child2.forenames) &&
        Objects.equals(this.originalForenames, child2.originalForenames) &&
        Objects.equals(this.surname, child2.surname) &&
        Objects.equals(this.dateOfBirth, child2.dateOfBirth) &&
        Objects.equals(this.sex, child2.sex) &&
        Objects.equals(this.birthplace, child2.birthplace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, originalForenames, surname, dateOfBirth, sex, birthplace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Child2 {\n");

    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    originalForenames: ").append(toIndentedString(originalForenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
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

