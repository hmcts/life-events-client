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
 * The person that died
 */
@ApiModel(description = "The person that died")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Deceased   {
  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("dateOfBirth")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  @JsonProperty("dateOfDeath")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfDeath;

  /**
   * Sex of the deceased
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

  @JsonProperty("deathplace")
  private String deathplace;

  @JsonProperty("occupation")
  private String occupation;

  @JsonProperty("address")
  private String address;

  @JsonProperty("retired")
  private Boolean retired;

  @JsonProperty("maidenSurname")
  private String maidenSurname;

  public Deceased forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the deceased
   * @return forenames
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", required = true, value = "Forenames of the deceased")
  @NotNull


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Deceased surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the deceased
   * @return surname
  */
  @ApiModelProperty(example = "SMITH", required = true, value = "Surname of the deceased")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Deceased dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date the deceased was born
   * @return dateOfBirth
  */
  @ApiModelProperty(example = "Mon Aug 08 01:00:00 BST 2011", value = "Date the deceased was born")

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Deceased dateOfDeath(LocalDate dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
    return this;
  }

  /**
   * Date the person died
   * @return dateOfDeath
  */
  @ApiModelProperty(example = "Mon Aug 08 01:00:00 BST 2011", required = true, value = "Date the person died")
  @NotNull

  @Valid

  public LocalDate getDateOfDeath() {
    return dateOfDeath;
  }

  public void setDateOfDeath(LocalDate dateOfDeath) {
    this.dateOfDeath = dateOfDeath;
  }

  public Deceased sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Sex of the deceased
   * @return sex
  */
  @ApiModelProperty(example = "Indeterminate", required = true, value = "Sex of the deceased")
  @NotNull


  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Deceased birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the deceased
   * @return birthplace
  */
  @ApiModelProperty(example = "Kensington", value = "The birthplace of the deceased")


  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Deceased deathplace(String deathplace) {
    this.deathplace = deathplace;
    return this;
  }

  /**
   * The place the person died
   * @return deathplace
  */
  @ApiModelProperty(example = "Kensington", value = "The place the person died")


  public String getDeathplace() {
    return deathplace;
  }

  public void setDeathplace(String deathplace) {
    this.deathplace = deathplace;
  }

  public Deceased occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the deceased
   * @return occupation
  */
  @ApiModelProperty(example = "Unemployed", value = "The occupation of the deceased")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Deceased address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The deceased's address
   * @return address
  */
  @ApiModelProperty(example = "888 Death House, 8 Death lane, Deadington, Deadshire", value = "The deceased's address")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Deceased retired(Boolean retired) {
    this.retired = retired;
    return this;
  }

  /**
   * Whether the deceased was retired
   * @return retired
  */
  @ApiModelProperty(example = "true", value = "Whether the deceased was retired")


  public Boolean getRetired() {
    return retired;
  }

  public void setRetired(Boolean retired) {
    this.retired = retired;
  }

  public Deceased maidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
    return this;
  }

  /**
   * Maiden name of the deceased
   * @return maidenSurname
  */
  @ApiModelProperty(example = "BLACK", value = "Maiden name of the deceased")


  public String getMaidenSurname() {
    return maidenSurname;
  }

  public void setMaidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deceased deceased = (Deceased) o;
    return Objects.equals(this.forenames, deceased.forenames) &&
        Objects.equals(this.surname, deceased.surname) &&
        Objects.equals(this.dateOfBirth, deceased.dateOfBirth) &&
        Objects.equals(this.dateOfDeath, deceased.dateOfDeath) &&
        Objects.equals(this.sex, deceased.sex) &&
        Objects.equals(this.birthplace, deceased.birthplace) &&
        Objects.equals(this.deathplace, deceased.deathplace) &&
        Objects.equals(this.occupation, deceased.occupation) &&
        Objects.equals(this.address, deceased.address) &&
        Objects.equals(this.retired, deceased.retired) &&
        Objects.equals(this.maidenSurname, deceased.maidenSurname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, dateOfBirth, dateOfDeath, sex, birthplace, deathplace, occupation, address, retired, maidenSurname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Deceased {\n");

    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    dateOfDeath: ").append(toIndentedString(dateOfDeath)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    deathplace: ").append(toIndentedString(deathplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    retired: ").append(toIndentedString(retired)).append("\n");
    sb.append("    maidenSurname: ").append(toIndentedString(maidenSurname)).append("\n");
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

