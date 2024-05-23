package com.github.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

/**
 * Status flags associated with this birth
 */
@ApiModel(description = "Status flags associated with this birth")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Status   {
  @JsonProperty("blockedRegistration")
  private Boolean blockedRegistration;

  @JsonProperty("cancelled")
  private Boolean cancelled;

  @JsonProperty("potentiallyFictitiousBirth")
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

  @JsonProperty("reRegistered")
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

  public Status blockedRegistration(Boolean blockedRegistration) {
    this.blockedRegistration = blockedRegistration;
    return this;
  }

  /**
   * Indicates if data for this record has been blocked
   * @return blockedRegistration
  */
  @ApiModelProperty(required = true, value = "Indicates if data for this record has been blocked")
  @NotNull


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
  @ApiModelProperty(value = "Indicates if record was cancelled")


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
  @ApiModelProperty(value = "Indicates if a birth may be fictitious")


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
  @ApiModelProperty(value = "Describes if this is a re-registration and why it was needed")


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
  @ApiModelProperty(value = "Indicates if there has been a correction to this record")


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
  @ApiModelProperty(value = "Gives additional notes on a record")


  public MarginalNoteEnum getMarginalNote() {
    return marginalNote;
  }

  public void setMarginalNote(MarginalNoteEnum marginalNote) {
    this.marginalNote = marginalNote;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

