package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.serverfrog.awportal.common.Persistable;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "players"
})
@Data
@Entity
public class Team extends Persistable<Long>{

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("id")
    public int jsonId;

    @JsonProperty("players")
    public List<Player> players = null;

}
