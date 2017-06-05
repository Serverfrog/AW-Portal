package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.ToString;

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
public class MatchHistory {

    @JsonProperty("matchhistory")
    private List<Match> matches = null;
}
