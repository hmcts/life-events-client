package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import jakarta.validation.constraints.*;

/**
 * Status flags associated with this record
 */
@ApiModel(description = "Status flags associated with this record")
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Status1   {
  @JsonProperty("blocked")
  private Boolean blocked;

  @JsonProperty("cancelled")
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

  @JsonProperty("correction")
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

  @JsonProperty("marginalNote")
  private MarginalNoteEnum marginalNote;

  @JsonProperty("potentiallyFictitiousBirth")
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

  @JsonProperty("reregistration")
  private ReregistrationEnum reregistration;

  public Status1 blocked(Boolean blocked) {
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

  public Status1 cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return this;
  }

  /**
   * Indicates if record was cancelled
   * @return cancelled
  */
  @ApiModelProperty(value = "Indicates if record was cancelled")


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
  @ApiModelProperty(value = "Indicates if there has been a correction to this record")


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
  @ApiModelProperty(value = "Gives additional notes on a record")


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
  @ApiModelProperty(value = "Indicates if a birth may be fictitious")


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
  @ApiModelProperty(value = "Describes if this is a reregistration and why it was needed")


  public ReregistrationEnum getReregistration() {
    return reregistration;
  }

  public void setReregistration(ReregistrationEnum reregistration) {
    this.reregistration = reregistration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

