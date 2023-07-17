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
 * A record of a death (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */

@Schema(name = "v1-Death", description = "A record of a death (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@JsonTypeName("v1-Death")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class V1Death {

  private Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private Deceased deceased;

  private Status2 status;

  /**
   * Default constructor
   * @deprecated Use {@link V1Death#V1Death(Integer, LocalDate, Deceased, Status2)}
   */
  @Deprecated
  public V1Death() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public V1Death(Integer id, LocalDate date, Deceased deceased, Status2 status) {
    this.id = id;
    this.date = date;
    this.deceased = deceased;
    this.status = status;
  }

  public V1Death id(Integer id) {
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

  public V1Death date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date the death was registered
   * @return date
  */
  @NotNull @Valid
  @Schema(name = "date", example = "Tue Aug 09 01:00:00 BST 2011", description = "Date the death was registered", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
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
  @NotNull @Valid
  @Schema(name = "deceased", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deceased")
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

