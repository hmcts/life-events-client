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
 * The second partner
 */

@Schema(name = "Second_partner", description = "The second partner")
@JsonTypeName("Second_partner")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class SecondPartner {

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
   * @deprecated Use {@link SecondPartner#SecondPartner(String, String, String)}
   */
  @Deprecated
  public SecondPartner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SecondPartner(String forenames, String surname, String condition) {
    this.forenames = forenames;
    this.surname = surname;
    this.condition = condition;
  }

  public SecondPartner forenames(String forenames) {
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

  public SecondPartner surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */
  @NotNull
  @Schema(name = "surname", example = "BLACK", description = "Surname of the person", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surname")
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
  @Valid
  @Schema(name = "dateOfBirth", example = "Mon Aug 08 01:00:00 BST 2011", description = "Date the person was born", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateOfBirth")
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

  @Schema(name = "sex", example = "Indeterminate", description = "Sex of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sex")
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

  @Schema(name = "occupation", example = "Unemployed", description = "The occupation of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
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

  @Schema(name = "retired", example = "false", description = "Whether the person was retired", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("retired")
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

  @Schema(name = "address", example = "888 Bride House, 8 Bride grove, Wedford, Wedfordshire, BR1 2E", description = "The person's address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
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
  @NotNull
  @Schema(name = "condition", example = "Single", description = "Whether the person was single, divorced, widowed etc.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("condition")
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

  @Schema(name = "signature", example = "J.N.O. Black", description = "A digital representation of the person's signature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

