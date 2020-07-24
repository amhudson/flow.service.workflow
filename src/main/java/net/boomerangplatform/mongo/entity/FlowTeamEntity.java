package net.boomerangplatform.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import net.boomerangplatform.mongo.model.Settings;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Document(collection = "flow_teams")
public class FlowTeamEntity {

  private String higherLevelGroupId;

  @Id
  private String id;
  private Boolean isActive;

  private String name;

  private Settings settings;

  public String getHigherLevelGroupId() {
    return higherLevelGroupId;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setHigherLevelGroupId(String higherLevelGroupId) {
    this.higherLevelGroupId = higherLevelGroupId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public Settings getSettings() {
    return settings;
  }

  public void setSettings(Settings settings) {
    this.settings = settings;
  }
}
