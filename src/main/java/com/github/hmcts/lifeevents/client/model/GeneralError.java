package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * An error
 */

@Schema(name = "generalError", description = "An error")
@JsonTypeName("generalError")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class GeneralError {

  private String code;

  private String message;

  /**
   * Default constructor
   * @deprecated Use {@link GeneralError#GeneralError(String, String)}
   */
  @Deprecated
  public GeneralError() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GeneralError(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public GeneralError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The type of error
   * @return code
  */
  @NotNull
  @Schema(name = "code", example = "BadRequest", description = "The type of error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
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
  @NotNull
  @Schema(name = "message", example = "Must provide the dateOfBirth parameter", description = "The error message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

