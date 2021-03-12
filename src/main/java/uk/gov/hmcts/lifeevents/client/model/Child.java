package uk.gov.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import uk.gov.hmcts.lifeevents.client.model.Name;
import uk.gov.hmcts.lifeevents.client.model.OriginalName;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Child
 */
@ApiModel(description = "Child")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Child   {
  @JsonProperty("name")
  private Name name;

  @JsonProperty("birthplace")
  private String birthplace;

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

  @JsonProperty("originalName")
  private OriginalName originalName;

  public Child name(Name name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")

  @Valid

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Child birthplace(String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * The birthplace of the person
   * @return birthplace
  */
  @ApiModelProperty(example = "Kensington", value = "The birthplace of the person")


  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public Child dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Date of birth of the person
   * @return dateOfBirth
  */
  @ApiModelProperty(example = "Mon Aug 08 01:00:00 BST 2011", value = "Date of birth of the person")

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Child sex(SexEnum sex) {
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

  public Child originalName(OriginalName originalName) {
    this.originalName = originalName;
    return this;
  }

  /**
   * Get originalName
   * @return originalName
  */
  @ApiModelProperty(value = "")

  @Valid

  public OriginalName getOriginalName() {
    return originalName;
  }

  public void setOriginalName(OriginalName originalName) {
    this.originalName = originalName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Child child = (Child) o;
    return Objects.equals(this.name, child.name) &&
        Objects.equals(this.birthplace, child.birthplace) &&
        Objects.equals(this.dateOfBirth, child.dateOfBirth) &&
        Objects.equals(this.sex, child.sex) &&
        Objects.equals(this.originalName, child.originalName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthplace, dateOfBirth, sex, originalName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Child {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    originalName: ").append(toIndentedString(originalName)).append("\n");
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

