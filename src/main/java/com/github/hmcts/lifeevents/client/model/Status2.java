package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * Status flags associated with this record
 */
@ApiModel(description = "Status flags associated with this record")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Status2   {
  @JsonProperty("blocked")
  private Boolean blocked;

  public Status2 blocked(Boolean blocked) {
    this.blocked = blocked;
    return this;
  }

  /**
   * Indicates if data for this record has been blocked
   * @return blocked
  */
  @ApiModelProperty(required = true, value = "Indicates if data for this record has been blocked")
  @NotNull


  public Boolean getBlocked() {
    return blocked;
  }

  public void setBlocked(Boolean blocked) {
    this.blocked = blocked;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

