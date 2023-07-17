package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Status flags associated with this birth
 */

@Schema(name = "Status", description = "Status flags associated with this birth")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-17T08:55:08.360589+01:00[Europe/London]")
public class Status {

  private Boolean blockedRegistration;

  private Boolean cancelled;

  private Boolean potentiallyFictitiousBirth;

  /**
   * Describes if this is a re-registration and why it was needed
   */
  public enum ReRegisteredEnum {
    NONE("None"),

    FATHER_MODIFIED("Father modified"),

    FATHER_ADDED("Father added"),

    REPLACEMENT_REGISTRATION("Replacement registration"),

    OTHER("Other"),

    SUBSEQUENTLY_MARRIED("Subsequently married");

    private String value;

    ReRegisteredEnum(String value) {
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
    public static ReRegisteredEnum fromValue(String value) {
      for (ReRegisteredEnum b : ReRegisteredEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ReRegisteredEnum reRegistered;

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

  /**
   * Default constructor
   * @deprecated Use {@link Status#Status(Boolean)}
   */
  @Deprecated
  public Status() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Status(Boolean blockedRegistration) {
    this.blockedRegistration = blockedRegistration;
  }

  public Status blockedRegistration(Boolean blockedRegistration) {
    this.blockedRegistration = blockedRegistration;
    return this;
  }

  /**
   * Indicates if data for this record has been blocked
   * @return blockedRegistration
  */
  @NotNull
  @Schema(name = "blockedRegistration", description = "Indicates if data for this record has been blocked", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("blockedRegistration")
  public Boolean getBlockedRegistration() {
    return blockedRegistration;
  }

  public void setBlockedRegistration(Boolean blockedRegistration) {
    this.blockedRegistration = blockedRegistration;
  }

  public Status cancelled(Boolean cancelled) {
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

  public Status potentiallyFictitiousBirth(Boolean potentiallyFictitiousBirth) {
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

  public Status reRegistered(ReRegisteredEnum reRegistered) {
    this.reRegistered = reRegistered;
    return this;
  }

  /**
   * Describes if this is a re-registration and why it was needed
   * @return reRegistered
  */

  @Schema(name = "reRegistered", description = "Describes if this is a re-registration and why it was needed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reRegistered")
  public ReRegisteredEnum getReRegistered() {
    return reRegistered;
  }

  public void setReRegistered(ReRegisteredEnum reRegistered) {
    this.reRegistered = reRegistered;
  }

  public Status correction(CorrectionEnum correction) {
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

  public Status marginalNote(MarginalNoteEnum marginalNote) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(this.blockedRegistration, status.blockedRegistration) &&
        Objects.equals(this.cancelled, status.cancelled) &&
        Objects.equals(this.potentiallyFictitiousBirth, status.potentiallyFictitiousBirth) &&
        Objects.equals(this.reRegistered, status.reRegistered) &&
        Objects.equals(this.correction, status.correction) &&
        Objects.equals(this.marginalNote, status.marginalNote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockedRegistration, cancelled, potentiallyFictitiousBirth, reRegistered, correction, marginalNote);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    sb.append("    blockedRegistration: ").append(toIndentedString(blockedRegistration)).append("\n");
    sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
    sb.append("    potentiallyFictitiousBirth: ").append(toIndentedString(potentiallyFictitiousBirth)).append("\n");
    sb.append("    reRegistered: ").append(toIndentedString(reRegistered)).append("\n");
    sb.append("    correction: ").append(toIndentedString(correction)).append("\n");
    sb.append("    marginalNote: ").append(toIndentedString(marginalNote)).append("\n");
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

