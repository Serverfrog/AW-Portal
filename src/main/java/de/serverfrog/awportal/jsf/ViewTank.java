package de.serverfrog.awportal.jsf;

import de.serverfrog.awportal.entity.Tank;
import lombok.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by m-p-h_000 on 23.04.2017.
 */
@Data
@Builder
public class ViewTank {

    private long id;

    private String key;

    private String title;

    private Dealer dealer;

    private Nation nation;

    private Class clazz;

    private int damage;

    private int damageMax;

    private int premiumPurchasePrice;

    private int rate;

    private double salvoReloadTime;

    private int armorPenFactor;

    private int tier;

    private boolean premium;

    private boolean selected;


    static ViewTank map(@NonNull Tank t) {
        ViewTankBuilder b = ViewTank.builder();
        return b.id(t.getId())
                .key(t.getTank_key())
                .title(t.getTitle())
                .dealer(Dealer.map(t.getDealer()))
                .nation(Nation.map(t.getNation()))
                .clazz(Class.map(t.getVehicle_class()))
                .damage(t.getDamage())
                .damageMax(t.getDamageMax())
                .premiumPurchasePrice(t.getPremiumPurchasePrice())
                .premium(t.getPremiumPurchasePrice() > 0)
                .rate(t.getRate())
                .salvoReloadTime(t.getSalvoReloadTime())
                .armorPenFactor(t.getArmorPenFactor())
                .tier(t.getTier())
                .build();
    }

    @RequiredArgsConstructor
    @Getter
    public enum Nation {
        CHINA("China", "", "china"),
        FRANCE("France", "", "fr"),
        GERMANY("Germany", "", "de"),
        ITALY("Italy", "", "ita"),
        UK("UK", "", "uk"),
        USA("USA", "", "usa"),
        USSR("USSR", "", "ussr"),
        POLAND("Poland", "", "pol"),
        SWITZERLAND("Switzerland", "", "swi"),
        ISRAEL("Israel", "", "israel"),
        JORDAN("Jordan", "", "jordan"),
        UNMAPPED("Unmapped", "", "");

        private final String name;
        private final String image;
        private final String jsonKey;

        public static Nation map(String key) {
            Optional<Nation> first = Arrays.stream(Nation.values()).filter(n -> n.getJsonKey().equalsIgnoreCase(key)).findFirst();
            return first.orElse(UNMAPPED);
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum Class {
        MBT("Main Battle Tank", "", "i"),
        LT("Light Tank", "", "g"),
        TD("Tank Destroyer", "", "a"),
        AFV("Armored Fighting Vehicle", "", "m"),
        SPG("Self-Propelled Guns", "", "l"),
        UNMAPPED("Unmapped", "", "");

        private final String name;
        private final String image;
        private final String jsonKey;

        public static Class map(String key) {
            Optional<Class> first = Arrays.stream(Class.values()).filter(n -> n.getJsonKey().equalsIgnoreCase(key)).findFirst();
            return first.orElse(UNMAPPED);
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum Dealer {
        SOPHIE_WOELFLI("Sophie Wölfli", "", "k"),
        MARAT_SHISHKIN("Marat Shishkin", "", "h"),
        ZHAN_FENG("Zhang Feng", "", "z"),
        EXCLUSIVE("Exclusive", "", "d"),
        UNMAPPED("UNMAPPED", "", "");

        private final String name;
        private final String image;
        private final String jsonKey;

        public static Dealer map(String key) {
            Optional<Dealer> first = Arrays.stream(Dealer.values()).filter(n -> n.getJsonKey().equalsIgnoreCase(key)).findFirst();
            return first.orElse(UNMAPPED);
        }
    }
}
