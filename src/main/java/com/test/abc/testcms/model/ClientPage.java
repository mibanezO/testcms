package com.test.abc.testcms.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.model.ClientAgeStats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ClientPage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-01T23:04:49.901173-05:00[America/Lima]", comments = "Generator version: 7.8.0")
public class ClientPage {

  private Long count;

  private Long limit;

  private Long offset;

  private ClientAgeStats ageStats;

  @Valid
  private List<@Valid Client> items = new ArrayList<>();

  public ClientPage count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   */
  
  @Schema(name = "count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public ClientPage limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
   */
  
  @Schema(name = "limit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("limit")
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public ClientPage offset(Long offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  
  @Schema(name = "offset", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("offset")
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public ClientPage ageStats(ClientAgeStats ageStats) {
    this.ageStats = ageStats;
    return this;
  }

  /**
   * Get ageStats
   * @return ageStats
   */
  @Valid 
  @Schema(name = "ageStats", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ageStats")
  public ClientAgeStats getAgeStats() {
    return ageStats;
  }

  public void setAgeStats(ClientAgeStats ageStats) {
    this.ageStats = ageStats;
  }

  public ClientPage items(List<@Valid Client> items) {
    this.items = items;
    return this;
  }

  public ClientPage addItemsItem(Client itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  public List<@Valid Client> getItems() {
    return items;
  }

  public void setItems(List<@Valid Client> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientPage clientPage = (ClientPage) o;
    return Objects.equals(this.count, clientPage.count) &&
        Objects.equals(this.limit, clientPage.limit) &&
        Objects.equals(this.offset, clientPage.offset) &&
        Objects.equals(this.ageStats, clientPage.ageStats) &&
        Objects.equals(this.items, clientPage.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, limit, offset, ageStats, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientPage {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    ageStats: ").append(toIndentedString(ageStats)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

