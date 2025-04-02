package com.test.abc.testcms.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ClientAgeStats
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-01T23:04:49.901173-05:00[America/Lima]", comments = "Generator version: 7.8.0")
public class ClientAgeStats {

  private BigDecimal mean;

  private BigDecimal max;

  private BigDecimal min;

  private BigDecimal std;

  public ClientAgeStats mean(BigDecimal mean) {
    this.mean = mean;
    return this;
  }

  /**
   * Get mean
   * @return mean
   */
  @Valid 
  @Schema(name = "mean", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mean")
  public BigDecimal getMean() {
    return mean;
  }

  public void setMean(BigDecimal mean) {
    this.mean = mean;
  }

  public ClientAgeStats max(BigDecimal max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
   */
  @Valid 
  @Schema(name = "max", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max")
  public BigDecimal getMax() {
    return max;
  }

  public void setMax(BigDecimal max) {
    this.max = max;
  }

  public ClientAgeStats min(BigDecimal min) {
    this.min = min;
    return this;
  }

  /**
   * Get min
   * @return min
   */
  @Valid 
  @Schema(name = "min", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("min")
  public BigDecimal getMin() {
    return min;
  }

  public void setMin(BigDecimal min) {
    this.min = min;
  }

  public ClientAgeStats std(BigDecimal std) {
    this.std = std;
    return this;
  }

  /**
   * Get std
   * @return std
   */
  @Valid 
  @Schema(name = "std", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("std")
  public BigDecimal getStd() {
    return std;
  }

  public void setStd(BigDecimal std) {
    this.std = std;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientAgeStats clientAgeStats = (ClientAgeStats) o;
    return Objects.equals(this.mean, clientAgeStats.mean) &&
        Objects.equals(this.max, clientAgeStats.max) &&
        Objects.equals(this.min, clientAgeStats.min) &&
        Objects.equals(this.std, clientAgeStats.std);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mean, max, min, std);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientAgeStats {\n");
    sb.append("    mean: ").append(toIndentedString(mean)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    std: ").append(toIndentedString(std)).append("\n");
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

