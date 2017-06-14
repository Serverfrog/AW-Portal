package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.serverfrog.awportal.common.Persistable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "battalionTag",
        "connectTime",
        "disconnectTime",
        "tankId",
        "shotsFired",
        "totalBattleTimeSec",
        "totalTimeToDestructionSec",
        "assists",
        "modulesDestroyed",
        "crewKills",
        "platoonIndex",
        "damages"
})
@Data
@Entity
public class Player extends Persistable<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("battalionTag")
    public String battalionTag;

    @JsonProperty("connectTime")
    public int connectTime;

    @JsonProperty("disconnectTime")
    public int disconnectTime;

    @JsonProperty("tankId")
    public int tankId;

    @JsonProperty("shotsFired")
    public int shotsFired;

    @JsonProperty("totalBattleTimeSec")
    public int totalBattleTimeSec;

    @JsonProperty("totalTimeToDestructionSec")
    public int totalTimeToDestructionSec;

    @JsonProperty("assists")
    public int assists;

    @JsonProperty("modulesDestroyed")
    public int modulesDestroyed;

    @JsonProperty("crewKills")
    public int crewKills;

    @JsonProperty("platoonIndex")
    public int platoonIndex;

    @JsonProperty("damages")
    @OneToMany
    public List<Damage> damages;

    @Getter
    @Setter
    @ManyToOne
    private Team team;

}
