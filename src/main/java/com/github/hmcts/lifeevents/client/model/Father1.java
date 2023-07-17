package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The father of the child that was born
 */

@Schema(name = "Father_1", description = "The father of the child that was born")
@JsonTypeName("Father_1")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class Father1 {

  private String forenames;

  private String surname;

  private String birthplace;

  private String occupation;

  private Boolean deceased;

  /**
   * Default constructor
   * @deprecated Use {@link Father1#Father1(Boolean)}
   */
  @Deprecated
  public Father1() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Father1(Boolean deceased) {
    this.deceased = deceased;
  }

  public Father1 forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * Forenames of the father
   * @return forenames
  */

  @Schema(name = "forenames", example = "Joan Narcissus Ouroboros", description = "Forenames of the father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("forenames")
  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public Father1 surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the father
   * @return surname
  */

  @Schema(name = "surname", example = "SMITH", description = "Surname of the father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Father1 birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the father
   * @return birthplace
  */

  @Schema(name = "birthplace", example = "Kensington", description = "The birthplace of the father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthplace")
  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Father1 occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the father
   * @return occupation
  */

  @Schema(name = "occupation", example = "Carpenter", description = "The occupation of the father", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("occupation")
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Father1 deceased(Boolean deceased) {
    this.deceased = deceased;
    return this;
  }

  /**
   * Whether the father was deceased at the point of birth
   * @return deceased
  */
  @NotNull
  @Schema(name = "deceased", example = "false", description = "Whether the father was deceased at the point of birth", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deceased")
  public Boolean getDeceased() {
    return deceased;
  }

  public void setDeceased(Boolean deceased) {
    this.deceased = deceased;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Father1 father1 = (Father1) o;
    return Objects.equals(this.forenames, father1.forenames) &&
        Objects.equals(this.surname, father1.surname) &&
        Objects.equals(this.birthplace, father1.birthplace) &&
        Objects.equals(this.occupation, father1.occupation) &&
        Objects.equals(this.deceased, father1.deceased);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forenames, surname, birthplace, occupation, deceased);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Father1 {\n");
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
    sb.append("    deceased: ").append(toIndentedString(deceased)).append("\n");
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

