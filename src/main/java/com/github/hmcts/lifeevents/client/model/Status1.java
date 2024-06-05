package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Status flags associated with this record
 */

@Schema(name = "Status_1", description = "Status flags associated with this record")
@JsonTypeName("Status_1")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
public class Status1 {

  private Boolean blocked;

  private Boolean cancelled;

  /**
   * Indicates if there has been a correction to this record
   */
  public enum CorrectionEnum {
    TYPOGRAPHICAL("Typographical"),

    SIMPLE_CLERICAL("Simple clerical"),

    COMPLEX_CLERICAL("Complex clerical"),

    ERROR_OF_FACT("Error of fact"),

    NONE("None");

    private String value;

    CorrectionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CorrectionEnum fromValue(String value) {
      for (CorrectionEnum b : CorrectionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CorrectionEnum correction;

  /**
   * Gives additional notes on a record
   */
  public enum MarginalNoteEnum {
    RE_REGISTERED("Re-registered"),

    COURT_ORDER_IN_PLACE("Court order in place"),

    COURT_ORDER_REVOKED("Court order revoked"),

    OTHER("Other"),

    NONE("None");

    private String value;

    MarginalNoteEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MarginalNoteEnum fromValue(String value) {
      for (MarginalNoteEnum b : MarginalNoteEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private MarginalNoteEnum marginalNote;

  private Boolean potentiallyFictitiousBirth;

  /**
   * Describes if this is a reregistration and why it was needed
   */
  public enum ReregistrationEnum {
    NONE("None"),

    FATHER_MODIFIED("Father modified"),

    FATHER_ADDED("Father added"),

    REPLACEMENT_REGISTRATION("Replacement registration"),

    OTHER("Other"),

    SUBSEQUENTLY_MARRIED("Subsequently married");

    private String value;

    ReregistrationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ReregistrationEnum fromValue(String value) {
      for (ReregistrationEnum b : ReregistrationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ReregistrationEnum reregistration;

  /**
   * Default constructor
   * @deprecated Use {@link Status1#Status1(Boolean)}
   */
  @Deprecated
  public Status1() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Status1(Boolean blocked) {
    this.blocked = blocked;
  }

  public Status1 blocked(Boolean blocked) {
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

  public Status1 cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return this;
  }

  /**
   * Indicates if record was cancelled
   * @return cancelled
  */

  @Schema(name = "cancelled", description = "Indicates if record was cancelled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cancelled")
  public Boolean getCancelled() {
    return cancelled;
  }

  public void setCancelled(Boolean cancelled) {
    this.cancelled = cancelled;
  }

  public Status1 correction(CorrectionEnum correction) {
    this.correction = correction;
    return this;
  }

  /**
   * Indicates if there has been a correction to this record
   * @return correction
  */

  @Schema(name = "correction", description = "Indicates if there has been a correction to this record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("correction")
  public CorrectionEnum getCorrection() {
    return correction;
  }

  public void setCorrection(CorrectionEnum correction) {
    this.correction = correction;
  }

  public Status1 marginalNote(MarginalNoteEnum marginalNote) {
    this.marginalNote = marginalNote;
    return this;
  }

  /**
   * Gives additional notes on a record
   * @return marginalNote
  */

  @Schema(name = "marginalNote", description = "Gives additional notes on a record", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("marginalNote")
  public MarginalNoteEnum getMarginalNote() {
    return marginalNote;
  }

  public void setMarginalNote(MarginalNoteEnum marginalNote) {
    this.marginalNote = marginalNote;
  }

  public Status1 potentiallyFictitiousBirth(Boolean potentiallyFictitiousBirth) {
    this.potentiallyFictitiousBirth = potentiallyFictitiousBirth;
    return this;
  }

  /**
   * Indicates if a birth may be fictitious
   * @return potentiallyFictitiousBirth
  */

  @Schema(name = "potentiallyFictitiousBirth", description = "Indicates if a birth may be fictitious", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("potentiallyFictitiousBirth")
  public Boolean getPotentiallyFictitiousBirth() {
    return potentiallyFictitiousBirth;
  }

  public void setPotentiallyFictitiousBirth(Boolean potentiallyFictitiousBirth) {
    this.potentiallyFictitiousBirth = potentiallyFictitiousBirth;
  }

  public Status1 reregistration(ReregistrationEnum reregistration) {
    this.reregistration = reregistration;
    return this;
  }

  /**
   * Describes if this is a reregistration and why it was needed
   * @return reregistration
  */

  @Schema(name = "reregistration", description = "Describes if this is a reregistration and why it was needed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reregistration")
  public ReregistrationEnum getReregistration() {
    return reregistration;
  }

  public void setReregistration(ReregistrationEnum reregistration) {
    this.reregistration = reregistration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status1 status1 = (Status1) o;
    return Objects.equals(this.blocked, status1.blocked) &&
        Objects.equals(this.cancelled, status1.cancelled) &&
        Objects.equals(this.correction, status1.correction) &&
        Objects.equals(this.marginalNote, status1.marginalNote) &&
        Objects.equals(this.potentiallyFictitiousBirth, status1.potentiallyFictitiousBirth) &&
        Objects.equals(this.reregistration, status1.reregistration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blocked, cancelled, correction, marginalNote, potentiallyFictitiousBirth, reregistration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status1 {\n");
    sb.append("    blocked: ").append(toIndentedString(blocked)).append("\n");
    sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
    sb.append("    correction: ").append(toIndentedString(correction)).append("\n");
    sb.append("    marginalNote: ").append(toIndentedString(marginalNote)).append("\n");
    sb.append("    potentiallyFictitiousBirth: ").append(toIndentedString(potentiallyFictitiousBirth)).append("\n");
    sb.append("    reregistration: ").append(toIndentedString(reregistration)).append("\n");
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

