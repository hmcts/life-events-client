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
 * A record of a marriage (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */

@Schema(name = "v1-Marriage", description = "A record of a marriage (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@JsonTypeName("v1-Marriage")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class V1Marriage {

  private Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dateOfMarriage;

  private Groom groom;

  private Bride bride;

  private Status2 status;

  /**
   * Default constructor
   * @deprecated Use {@link V1Marriage#V1Marriage(Integer, LocalDate, Groom, Bride, Status2)}
   */
  @Deprecated
  public V1Marriage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public V1Marriage(Integer id, LocalDate dateOfMarriage, Groom groom, Bride bride, Status2 status) {
    this.id = id;
    this.dateOfMarriage = dateOfMarriage;
    this.groom = groom;
    this.bride = bride;
    this.status = status;
  }

  public V1Marriage id(Integer id) {
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

  public V1Marriage dateOfMarriage(LocalDate dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
    return this;
  }

  /**
   * Date of the marriage
   * @return dateOfMarriage
  */
  @NotNull @Valid
  @Schema(name = "dateOfMarriage", example = "Fri Aug 08 01:00:00 BST 2008", description = "Date of the marriage", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dateOfMarriage")
  public LocalDate getDateOfMarriage() {
    return dateOfMarriage;
  }

  public void setDateOfMarriage(LocalDate dateOfMarriage) {
    this.dateOfMarriage = dateOfMarriage;
  }

  public V1Marriage groom(Groom groom) {
    this.groom = groom;
    return this;
  }

  /**
   * Get groom
   * @return groom
  */
  @NotNull @Valid
  @Schema(name = "groom", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("groom")
  public Groom getGroom() {
    return groom;
  }

  public void setGroom(Groom groom) {
    this.groom = groom;
  }

  public V1Marriage bride(Bride bride) {
    this.bride = bride;
    return this;
  }

  /**
   * Get bride
   * @return bride
  */
  @NotNull @Valid
  @Schema(name = "bride", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bride")
  public Bride getBride() {
    return bride;
  }

  public void setBride(Bride bride) {
    this.bride = bride;
  }

  public V1Marriage status(Status2 status) {
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
    V1Marriage v1Marriage = (V1Marriage) o;
    return Objects.equals(this.id, v1Marriage.id) &&
        Objects.equals(this.dateOfMarriage, v1Marriage.dateOfMarriage) &&
        Objects.equals(this.groom, v1Marriage.groom) &&
        Objects.equals(this.bride, v1Marriage.bride) &&
        Objects.equals(this.status, v1Marriage.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateOfMarriage, groom, bride, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Marriage {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateOfMarriage: ").append(toIndentedString(dateOfMarriage)).append("\n");
    sb.append("    groom: ").append(toIndentedString(groom)).append("\n");
    sb.append("    bride: ").append(toIndentedString(bride)).append("\n");
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

