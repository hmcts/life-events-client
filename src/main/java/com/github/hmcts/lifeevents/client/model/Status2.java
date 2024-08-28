package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Status flags associated with this record
 */

@Schema(name = "Status_2", description = "Status flags associated with this record")
@JsonTypeName("Status_2")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Status2 {

  private Boolean blocked;

  /**
   * Default constructor
   * @deprecated Use {@link Status2#Status2(Boolean)}
   */
  @Deprecated
  public Status2() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Status2(Boolean blocked) {
    this.blocked = blocked;
  }

  public Status2 blocked(Boolean blocked) {
    this.blocked = blocked;
    return this;
  }

  /**
   * Indicates if data for this record has been blocked
   * @return blocked
  */
  @NotNull
  @Schema(name = "blocked", description = "Indicates if data for this record has been blocked", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("blocked")
  public Boolean getBlocked() {
    return blocked;
  }

  public void setBlocked(Boolean blocked) {
    this.blocked = blocked;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status2 status2 = (Status2) o;
    return Objects.equals(this.blocked, status2.blocked);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blocked);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status2 {\n");
    sb.append("    blocked: ").append(toIndentedString(blocked)).append("\n");
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

