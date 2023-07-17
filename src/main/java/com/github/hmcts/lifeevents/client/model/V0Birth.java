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
 * A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)
 */

@Schema(name = "v0-Birth", description = "A record of a birth (Note: You will only receive the fields you are authorized to view, regardless of whether we hold them on file)")
@JsonTypeName("v0-Birth")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class V0Birth {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private Location location;

  private String registrarSignature;

  private String type;

  private Integer id;

  private Subjects subjects;

  private Integer systemNumber;

  private Status status;

  private PreviousRegistration previousRegistration;

  /**
   * Default constructor
   * @deprecated Use {@link V0Birth#V0Birth(Location, Integer, Subjects, Status, PreviousRegistration)}
   */
  @Deprecated
  public V0Birth() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public V0Birth(Location location, Integer id, Subjects subjects, Status status, PreviousRegistration previousRegistration) {
    this.location = location;
    this.id = id;
    this.subjects = subjects;
    this.status = status;
    this.previousRegistration = previousRegistration;
  }

  public V0Birth date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date of the event
   * @return date
  */
  @Valid
  @Schema(name = "date", example = "Tue Aug 09 01:00:00 BST 2011", description = "Date of the event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public V0Birth location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @NotNull @Valid
  @Schema(name = "location", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public V0Birth registrarSignature(String registrarSignature) {
    this.registrarSignature = registrarSignature;
    return this;
  }

  /**
   * Signature of registrar
   * @return registrarSignature
  */

  @Schema(name = "registrarSignature", example = "J. Smith", description = "Signature of registrar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("registrarSignature")
  public String getRegistrarSignature() {
    return registrarSignature;
  }

  public void setRegistrarSignature(String registrarSignature) {
    this.registrarSignature = registrarSignature;
  }

  public V0Birth type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the event
   * @return type
  */

  @Schema(name = "type", example = "birth", description = "Type of the event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public V0Birth id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID for this event
   * @return id
  */
  @NotNull
  @Schema(name = "id", description = "Unique ID for this event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public V0Birth subjects(Subjects subjects) {
    this.subjects = subjects;
    return this;
  }

  /**
   * Get subjects
   * @return subjects
  */
  @NotNull @Valid
  @Schema(name = "subjects", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subjects")
  public Subjects getSubjects() {
    return subjects;
  }

  public void setSubjects(Subjects subjects) {
    this.subjects = subjects;
  }

  public V0Birth systemNumber(Integer systemNumber) {
    this.systemNumber = systemNumber;
    return this;
  }

  /**
   * System number for this event
   * @return systemNumber
  */

  @Schema(name = "systemNumber", description = "System number for this event", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("systemNumber")
  public Integer getSystemNumber() {
    return systemNumber;
  }

  public void setSystemNumber(Integer systemNumber) {
    this.systemNumber = systemNumber;
  }

  public V0Birth status(Status status) {
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
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public V0Birth previousRegistration(PreviousRegistration previousRegistration) {
    this.previousRegistration = previousRegistration;
    return this;
  }

  /**
   * Get previousRegistration
   * @return previousRegistration
  */
  @NotNull @Valid
  @Schema(name = "previousRegistration", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("previousRegistration")
  public PreviousRegistration getPreviousRegistration() {
    return previousRegistration;
  }

  public void setPreviousRegistration(PreviousRegistration previousRegistration) {
    this.previousRegistration = previousRegistration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V0Birth v0Birth = (V0Birth) o;
    return Objects.equals(this.date, v0Birth.date) &&
        Objects.equals(this.location, v0Birth.location) &&
        Objects.equals(this.registrarSignature, v0Birth.registrarSignature) &&
        Objects.equals(this.type, v0Birth.type) &&
        Objects.equals(this.id, v0Birth.id) &&
        Objects.equals(this.subjects, v0Birth.subjects) &&
        Objects.equals(this.systemNumber, v0Birth.systemNumber) &&
        Objects.equals(this.status, v0Birth.status) &&
        Objects.equals(this.previousRegistration, v0Birth.previousRegistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, location, registrarSignature, type, id, subjects, systemNumber, status, previousRegistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V0Birth {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    registrarSignature: ").append(toIndentedString(registrarSignature)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
    sb.append("    systemNumber: ").append(toIndentedString(systemNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    previousRegistration: ").append(toIndentedString(previousRegistration)).append("\n");
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

