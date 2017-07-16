package de.serverfrog.awportal.eao;

import de.serverfrog.awportal.entity.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Serverfrog on 16.07.17.
 */
public interface TankEao extends JpaRepository<Tank, Long> {

}
