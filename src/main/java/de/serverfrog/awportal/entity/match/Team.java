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
        "id",
        "players"
})
@Data
@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long databaseId;

    @JsonProperty("id")
    public int id;

    @JsonProperty("players")
    @OneToMany(mappedBy = "team")
    public List<Player> players;

    @Getter
    @Setter
    @ManyToOne
    private MatchEntry matchEntry;

}
