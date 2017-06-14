package de.serverfrog.awportal.entity;

import de.serverfrog.awportal.common.Persistable;
import de.serverfrog.awportal.entity.match.MatchEntry;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Serverfrog on 05.06.17.
 */
@Entity
@Data
public class UniquePlayer extends Persistable<Long> {

    @Id
    private Long id;

    @OneToMany
    private List<MatchEntry> matchEntries;
}
