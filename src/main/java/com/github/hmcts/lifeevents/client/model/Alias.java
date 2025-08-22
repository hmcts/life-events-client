package com.github.hmcts.lifeevents.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Alias details of the deceased individual")
public class Alias {

  @JsonProperty("type")
  @Schema(description = "Type of alias, e.g., 'formerly known as', 'otherwise'", example = "formerly known as")
  private String type;

  @JsonProperty("prefix")
  @Schema(description = "Prefix of the alias, e.g., Mr, Mrs, Dr", example = "Dr")
  private String prefix;

  @JsonProperty("forenames")
  @Schema(description = "Forenames of the alias", example = "Joan Narcissus Ouroboros")
  private String forenames;

  @JsonProperty("surname")
  @Schema(description = "Surname of the alias", example = "WHITE")
  private String surname;

  @JsonProperty("suffix")
  @Schema(description = "Suffix of the alias, e.g., Jr., Sr.", example = "Jr.")
  private String suffix;

  // Getters and Setters
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}