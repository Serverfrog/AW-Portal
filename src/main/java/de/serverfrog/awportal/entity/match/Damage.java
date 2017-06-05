package de.serverfrog.awportal.entity.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.serverfrog.awportal.common.Persistable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "victimTankId",
        "damage",
        "spots",
        "spotsDamage",
        "shotsHit",
        "shotsDirectHit",
        "shotsSplashHit",
        "receivedHits",
        "receivedDamage",
        "assistedDamage",
        "designatedDamage",
        "potentialDamage",
        "potentialDamage_Dealt",
        "potentialDamage_Ricochet",
        "potentialDamage_NoPen",
        "potentialDamage_ERA",
        "potentialDamage_APS",
        "wildCard_NumDeployed",
        "wildCard_NumKills",
        "wildCard_NumSpotted",
        "killedTime"
})
@Data
@Entity
public class Damage extends Persistable<Long>{


    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("victimTankId")
    public int victimTankId;

    @JsonProperty("damage")
    public int damage;

    @JsonProperty("spots")
    public int spots;

    @JsonProperty("spotsDamage")
    public int spotsDamage;

    @JsonProperty("shotsHit")
    public int shotsHit;

    @JsonProperty("shotsDirectHit")
    public int shotsDirectHit;

    @JsonProperty("shotsSplashHit")
    public int shotsSplashHit;

    @JsonProperty("receivedHits")
    public int receivedHits;

    @JsonProperty("receivedDamage")
    public int receivedDamage;

    @JsonProperty("assistedDamage")
    public int assistedDamage;

    @JsonProperty("designatedDamage")
    public int designatedDamage;

    @JsonProperty("potentialDamage")
    public int potentialDamage;

    @JsonProperty("potentialDamage_Dealt")
    public int potentialDamageDealt;

    @JsonProperty("potentialDamage_Ricochet")
    public int potentialDamageRicochet;

    @JsonProperty("potentialDamage_NoPen")
    public int potentialDamageNoPen;

    @JsonProperty("potentialDamage_ERA")
    public int potentialDamageERA;

    @JsonProperty("potentialDamage_APS")
    public int potentialDamageAPS;

    @JsonProperty("wildCard_NumDeployed")
    public int wildCardNumDeployed;

    @JsonProperty("wildCard_NumKills")
    public int wildCardNumKills;

    @JsonProperty("wildCard_NumSpotted")
    public int wildCardNumSpotted;

    @JsonProperty("killedTime")
    public int killedTime;

}
