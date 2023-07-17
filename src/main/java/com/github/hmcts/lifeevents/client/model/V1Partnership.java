package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A record of a civil partnership (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */

@Schema(name = "v1-Partnership", description = "A record of a civil partnership (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@JsonTypeName("v1-Partnership")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class V1Partnership {

  private Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfPartnership;

  private FirstPartner partner1;

  private SecondPartner partner2;

  private Status2 status;

  /**
   * Default constructor
   * @deprecated Use {@link V1Partnership#V1Partnership(Integer, LocalDate, FirstPartner, SecondPartner, Status2)}
   */
  @Deprecated
  public V1Partnership() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public V1Partnership(Integer id, LocalDate dateOfPartnership, FirstPartner partner1, SecondPartner partner2, Status2 status) {
    this.id = id;
    this.dateOfPartnership = dateOfPartnership;
    this.partner1 = partner1;
    this.partner2 = partner2;
    this.status = status;
  }

  public V1Partnership id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * System number for this event
   * @return id
  */
  @NotNull
  @Schema(name = "id", description = "System number for this event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public V1Partnership dateOfPartnership(LocalDate dateOfPartnership) {
    this.dateOfPartnership = dateOfPartnership;
    return this;
  }

  /**
   * Date of the civil partnership
   * @return dateOfPartnership
  */
  @NotNull @Valid
  @Schema(name = "dateOfPartnership", example = "Fri Aug 08 01:00:00 BST 2008", description = "Date of the civil partnership", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateOfPartnership")
  public LocalDate getDateOfPartnership() {
    return dateOfPartnership;
  }

  public void setDateOfPartnership(LocalDate dateOfPartnership) {
    this.dateOfPartnership = dateOfPartnership;
  }

  public V1Partnership partner1(FirstPartner partner1) {
    this.partner1 = partner1;
    return this;
  }

  /**
   * Get partner1
   * @return partner1
  */
  @NotNull @Valid
  @Schema(name = "partner1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("partner1")
  public FirstPartner getPartner1() {
    return partner1;
  }

  public void setPartner1(FirstPartner partner1) {
    this.partner1 = partner1;
  }

  public V1Partnership partner2(SecondPartner partner2) {
    this.partner2 = partner2;
    return this;
  }

  /**
   * Get partner2
   * @return partner2
  */
  @NotNull @Valid
  @Schema(name = "partner2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("partner2")
  public SecondPartner getPartner2() {
    return partner2;
  }

  public void setPartner2(SecondPartner partner2) {
    this.partner2 = partner2;
  }

  public V1Partnership status(Status2 status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Status2 getStatus() {
    return status;
  }

  public void setStatus(Status2 status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Partnership v1Partnership = (V1Partnership) o;
    return Objects.equals(this.id, v1Partnership.id) &&
        Objects.equals(this.dateOfPartnership, v1Partnership.dateOfPartnership) &&
        Objects.equals(this.partner1, v1Partnership.partner1) &&
        Objects.equals(this.partner2, v1Partnership.partner2) &&
        Objects.equals(this.status, v1Partnership.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateOfPartnership, partner1, partner2, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Partnership {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateOfPartnership: ").append(toIndentedString(dateOfPartnership)).append("\n");
    sb.append("    partner1: ").append(toIndentedString(partner1)).append("\n");
    sb.append("    partner2: ").append(toIndentedString(partner2)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

