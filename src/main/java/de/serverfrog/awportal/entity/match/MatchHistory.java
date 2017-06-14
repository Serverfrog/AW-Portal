package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.serverfrog.awportal.common.Persistable;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Serverfrog on 05.06.17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "matchhistory"
})
@ToString
@Getter
@Entity
public class MatchHistory extends Persistable<Long>{

    @JsonProperty("matchhistory")
    @OneToMany
    private List<MatchEntry> matchEntries = null;

    @Id
    @GeneratedValue
    @Getter
    private Long id;
}
