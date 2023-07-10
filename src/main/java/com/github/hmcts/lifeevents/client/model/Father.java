package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * Father
 */
@ApiModel(description = "Father")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Father   {
  @JsonProperty("name")
  private Name name;

  @JsonProperty("birthplace")
  private String birthplace;

  @JsonProperty("occupation")
  private String occupation;

  public Father name(Name name) {
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

  public Father birthplace(String birthplace) {
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

  public Father occupation(String occupation) {
    this.occupation = occupation;
    return this;
  }

  /**
   * The occupation of the parent
   * @return occupation
  */
  @ApiModelProperty(example = "Carpenter", value = "The occupation of the parent")


  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Father father = (Father) o;
    return Objects.equals(this.name, father.name) &&
        Objects.equals(this.birthplace, father.birthplace) &&
        Objects.equals(this.occupation, father.occupation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthplace, occupation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Father {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
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

