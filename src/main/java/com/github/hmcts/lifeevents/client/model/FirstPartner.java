package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * The first partner
 */

@Schema(name = "First_partner", description = "The first partner")
@JsonTypeName("First_partner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class FirstPartner {

  private String forenames;

  private String surname;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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

  private SexEnum sex;

  private String occupation;

  private Boolean retired;

  private String address;

  private String condition;

  private String signature;

  /**
   * Default constructor
   * @deprecated Use {@link FirstPartner#FirstPartner(String, String, String)}
   */
  @Deprecated
  public FirstPartner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FirstPartner(String forenames, String surname, String condition) {
    this.forenames = forenames;
    this.surname = surname;
    this.condition = condition;
  }

  public FirstPartner forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the person
   * @return forenames
  */
  @NotNull
  @Schema(name = "forenames", example = "Joan Narcissus Ouroboros", description = "Forenames of the person", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("forenames")
  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public FirstPartner surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */
  @NotNull
  @Schema(name = "surname", example = "SMITH", description = "Surname of the person", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public FirstPartner dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date the person was born
   * @return dateOfBirth
  */
  @Valid
  @Schema(name = "dateOfBirth", example = "Mon Aug 08 01:00:00 BST 2011", description = "Date the person was born", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOfBirth")
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public FirstPartner sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Sex of the person
   * @return sex
  */

  @Schema(name = "sex", example = "Indeterminate", description = "Sex of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sex")
  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public FirstPartner occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the person
   * @return occupation
  */

  @Schema(name = "occupation", example = "Unemployed", description = "The occupation of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public FirstPartner retired(Boolean retired) {
    this.retired = retired;
    return this;
  }

  /**
   * Whether the person was retired
   * @return retired
  */

  @Schema(name = "retired", example = "false", description = "Whether the person was retired", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("retired")
  public Boolean getRetired() {
    return retired;
  }

  public void setRetired(Boolean retired) {
    this.retired = retired;
  }

  public FirstPartner address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The person's address
   * @return address
  */

  @Schema(name = "address", example = "888 Groom House, 8 Groom grove, Wedford, Wedfordshire, GR0 0M", description = "The person's address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public FirstPartner condition(String condition) {
    this.condition = condition;
    return this;
  }

  /**
   * Whether the person was single, divorced, widowed etc.
   * @return condition
  */
  @NotNull
  @Schema(name = "condition", example = "Single", description = "Whether the person was single, divorced, widowed etc.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("condition")
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public FirstPartner signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * A digital representation of the person's signature
   * @return signature
  */

  @Schema(name = "signature", example = "J.N.O. Smith", description = "A digital representation of the person's signature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FirstPartner firstPartner = (FirstPartner) o;
    return Objects.equals(this.forenames, firstPartner.forenames) &&
        Objects.equals(this.surname, firstPartner.surname) &&
        Objects.equals(this.dateOfBirth, firstPartner.dateOfBirth) &&
        Objects.equals(this.sex, firstPartner.sex) &&
        Objects.equals(this.occupation, firstPartner.occupation) &&
        Objects.equals(this.retired, firstPartner.retired) &&
        Objects.equals(this.address, firstPartner.address) &&
        Objects.equals(this.condition, firstPartner.condition) &&
        Objects.equals(this.signature, firstPartner.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, dateOfBirth, sex, occupation, retired, address, condition, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FirstPartner {\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

