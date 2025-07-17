package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * The person that died
 */

@Schema(name = "Deceased", description = "The person that died")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Deceased {

  private String forenames;

  private String surname;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SexEnum sex;

  private String birthplace;

  private String deathplace;

  private String occupation;

  private String address;

  private Boolean retired;

  private String maidenSurname;

  /**
   * Default constructor
   * @deprecated Use {@link Deceased#Deceased(String, String, LocalDate, SexEnum)}
   */
  @Deprecated
  public Deceased() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Deceased(String forenames, String surname, LocalDate dateOfDeath, SexEnum sex) {
    this.forenames = forenames;
    this.surname = surname;
    this.dateOfDeath = dateOfDeath;
    this.sex = sex;
  }

  public Deceased forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the deceased
   * @return forenames
  */
  @NotNull
  @Schema(name = "forenames", example = "Joan Narcissus Ouroboros", description = "Forenames of the deceased", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("forenames")
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
  @NotNull
  @Schema(name = "surname", example = "SMITH", description = "Surname of the deceased", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
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
  @Valid
  @Schema(name = "dateOfBirth", example = "Mon Aug 08 01:00:00 BST 2011", description = "Date the deceased was born", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOfBirth")
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
  @NotNull @Valid
  @Schema(name = "dateOfDeath", example = "Mon Aug 08 01:00:00 BST 2011", description = "Date the person died", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateOfDeath")
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
  @NotNull
  @Schema(name = "sex", example = "Indeterminate", description = "Sex of the deceased", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sex")
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

  @Schema(name = "birthplace", example = "Kensington", description = "The birthplace of the deceased", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthplace")
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

  @Schema(name = "deathplace", example = "Kensington", description = "The place the person died", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deathplace")
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

  @Schema(name = "occupation", example = "Unemployed", description = "The occupation of the deceased", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
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

  @Schema(name = "address", example = "888 Death House, 8 Death lane, Deadington, Deadshire", description = "The deceased's address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
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

  @Schema(name = "retired", example = "true", description = "Whether the deceased was retired", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("retired")
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

  @Schema(name = "maidenSurname", example = "BLACK", description = "Maiden name of the deceased", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maidenSurname")
  public String getMaidenSurname() {
    return maidenSurname;
  }

  public void setMaidenSurname(String maidenSurname) {
    this.maidenSurname = maidenSurname;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

