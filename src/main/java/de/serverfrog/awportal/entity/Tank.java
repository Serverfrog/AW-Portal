package de.serverfrog.awportal.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by m-p-h_000 on 18.04.2017.
 */
@Data
@XmlRootElement
@Entity
public class Tank {

    private String tank_key;

    private String title;

    private String dealer;

    private String nation;

    private String vehicle_class;

    private int damageMax;

    @XmlAttribute(name = "PremiumPurchasePrice")
    private int PremiumPurchasePrice;

    private int damage;

    private int rate;

    private double salvoReloadTime;

    @XmlAttribute(name = "ArmorPenFactor")
    private int ArmorPenFactor;

    @XmlAttribute(name = "Tier")
    private int Tier;

    @Id
    private long id;

}
