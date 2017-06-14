package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import de.serverfrog.awportal.common.Persistable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
public class MatchEntry extends Persistable<String>{

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

    @JsonProperty("teams")
    @OneToMany
    public List<Team> teams;

    @Getter
    @Setter
    @ManyToOne
    private MatchHistory matchHistory;

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
