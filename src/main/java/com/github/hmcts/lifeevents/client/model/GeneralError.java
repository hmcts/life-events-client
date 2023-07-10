package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * An error
 */
@ApiModel(description = "An error")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class GeneralError   {
  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public GeneralError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The type of error
   * @return code
  */
  @ApiModelProperty(example = "BadRequest", required = true, value = "The type of error")
  @NotNull


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GeneralError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The error message
   * @return message
  */
  @ApiModelProperty(example = "Must provide the dateOfBirth parameter", required = true, value = "The error message")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneralError generalError = (GeneralError) o;
    return Objects.equals(this.code, generalError.code) &&
        Objects.equals(this.message, generalError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

