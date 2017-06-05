package de.serverfrog.awportal.entity;

import de.serverfrog.awportal.common.Persistable;
import de.serverfrog.awportal.entity.match.Match;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Serverfrog on 05.06.17.
 */
@Entity
@Data
public class UniquePlayer extends Persistable<Long>{

    @Id
    private Long id;

    private List<Match> matches;
}
