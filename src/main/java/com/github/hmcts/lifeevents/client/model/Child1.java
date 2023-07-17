package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The child that was born
 */

@Schema(name = "Child_1", description = "The child that was born")
@JsonTypeName("Child_1")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class Child1 {

  private String forenames;

  private String originalForenames;

  private String surname;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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

  private SexEnum sex;

  private String birthplace;

  /**
   * Default constructor
   * @deprecated Use {@link Child1#Child1(String, String, LocalDate, SexEnum)}
   */
  @Deprecated
  public Child1() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Child1(String forenames, String surname, LocalDate dateOfBirth, SexEnum sex) {
    this.forenames = forenames;
    this.surname = surname;
    this.dateOfBirth = dateOfBirth;
    this.sex = sex;
  }

  public Child1 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the child
   * @return forenames
  */
  @NotNull
  @Schema(name = "forenames", example = "Joan Narcissus Ouroboros", description = "Forenames of the child", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("forenames")
  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Child1 originalForenames(String originalForenames) {
    this.originalForenames = originalForenames;
    return this;
  }

  /**
   * The forenames originally given to the child before they were changed
   * @return originalForenames
  */

  @Schema(name = "originalForenames", example = "John Narcissus Ouroboros", description = "The forenames originally given to the child before they were changed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("originalForenames")
  public String getOriginalForenames() {
    return originalForenames;
  }

  public void setOriginalForenames(String originalForenames) {
    this.originalForenames = originalForenames;
  }

  public Child1 surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the child
   * @return surname
  */
  @NotNull
  @Schema(name = "surname", example = "SMITH", description = "Surname of the child", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Child1 dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date of birth of the child
   * @return dateOfBirth
  */
  @NotNull @Valid
  @Schema(name = "dateOfBirth", example = "Mon Aug 08 01:00:00 BST 2011", description = "Date of birth of the child", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateOfBirth")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Child1 sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Sex of the child
   * @return sex
  */
  @NotNull
  @Schema(name = "sex", example = "Indeterminate", description = "Sex of the child", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sex")
  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Child1 birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the child
   * @return birthplace
  */

  @Schema(name = "birthplace", example = "Kensington", description = "The birthplace of the child", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthplace")
  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Child1 child1 = (Child1) o;
    return Objects.equals(this.forenames, child1.forenames) &&
        Objects.equals(this.originalForenames, child1.originalForenames) &&
        Objects.equals(this.surname, child1.surname) &&
        Objects.equals(this.dateOfBirth, child1.dateOfBirth) &&
        Objects.equals(this.sex, child1.sex) &&
        Objects.equals(this.birthplace, child1.birthplace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, originalForenames, surname, dateOfBirth, sex, birthplace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Child1 {\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

