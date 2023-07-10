package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A record of a death (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */
@ApiModel(description = "A record of a death (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class V1Death   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("deceased")
  private Deceased deceased;

  @JsonProperty("status")
  private Status2 status;

  public V1Death id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * System number for this event
   * @return id
  */
  @ApiModelProperty(required = true, value = "System number for this event")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public V1Death date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date the death was registered
   * @return date
  */
  @ApiModelProperty(example = "Tue Aug 09 01:00:00 BST 2011", required = true, value = "Date the death was registered")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public V1Death deceased(Deceased deceased) {
    this.deceased = deceased;
    return this;
  }

  /**
   * Get deceased
   * @return deceased
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Deceased getDeceased() {
    return deceased;
  }

  public void setDeceased(Deceased deceased) {
    this.deceased = deceased;
  }

  public V1Death status(Status2 status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Status2 getStatus() {
    return status;
  }

  public void setStatus(Status2 status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Death v1Death = (V1Death) o;
    return Objects.equals(this.id, v1Death.id) &&
        Objects.equals(this.date, v1Death.date) &&
        Objects.equals(this.deceased, v1Death.deceased) &&
        Objects.equals(this.status, v1Death.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, date, deceased, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Death {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    deceased: ").append(toIndentedString(deceased)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

