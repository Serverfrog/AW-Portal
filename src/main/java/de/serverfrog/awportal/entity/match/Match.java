package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.serverfrog.awportal.common.Persistable;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version",
        "matchId",
        "mapId",
        "gameType",
        "startTime",
        "endTime",
        "winningTeamId",
        "teams"
})
@Data
@Entity
public class Match extends Persistable<String>{

    @JsonProperty("version")
    public int version;

    @Id
    @JsonProperty("matchId")
    public String matchId;

    @JsonProperty("mapId")
    public int mapId;

    @JsonProperty("gameType")
    public int gameType;

    @JsonProperty("startTime")
    public int startTime;

    @JsonProperty("endTime")
    public int endTime;

    @JsonProperty("winningTeamId")
    public int winningTeamId;

    @ElementCollection
    @JsonProperty("teams")
    public List<Team> teams;

    public LocalDateTime getStart() {
        return LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.UTC);
    }

    public LocalDateTime getEnd() {
        return LocalDateTime.ofEpochSecond(endTime, 0, ZoneOffset.UTC);
    }

    @Override
    public String getId() {
        return matchId;
    }
}
