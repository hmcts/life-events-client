package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The groom (or first partner)
 */

@Schema(name = "Groom", description = "The groom (or first partner)")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class Groom {

  private String forenames;

  private String surname;

  private Integer age;

  private String occupation;

  private Boolean retired;

  private String address;

  private String condition;

  private String signature;

  /**
   * Default constructor
   * @deprecated Use {@link Groom#Groom(String, String, String)}
   */
  @Deprecated
  public Groom() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Groom(String forenames, String surname, String condition) {
    this.forenames = forenames;
    this.surname = surname;
    this.condition = condition;
  }

  public Groom forenames(String forenames) {
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

  public Groom surname(String surname) {
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

  public Groom age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Age of the person when they got married
   * @return age
  */

  @Schema(name = "age", description = "Age of the person when they got married", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("age")
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

  @Schema(name = "occupation", example = "Unemployed", description = "The occupation of the person", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
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

  @Schema(name = "retired", example = "false", description = "Whether the person was retired", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("retired")
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

  @Schema(name = "address", example = "888 Groom House, 8 Groom grove, Wedford, Wedfordshire, GR0 0M", description = "The person's address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
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
  @NotNull
  @Schema(name = "condition", example = "Single", description = "Whether the person was single, divorced, widowed etc.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("condition")
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

