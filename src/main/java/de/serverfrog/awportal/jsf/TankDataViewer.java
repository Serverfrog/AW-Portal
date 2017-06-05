package de.serverfrog.awportal.jsf;

import de.serverfrog.awportal.entity.Tank;
import de.serverfrog.awportal.misc.JaxbMarschaller;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by m-p-h_000 on 18.04.2017.
 */
@SessionScoped
@ManagedBean
public class TankDataViewer implements Serializable {

    @Getter
    private List<ViewTank> tanks;
    private List<ViewTank> compareTanks;
    @Getter
    private ViewTank maxtank;

    @PostConstruct
    public void init() {

        InputStream resource = getClass().getResourceAsStream("/tanks.json");
        StringWriter sw = new StringWriter();
        try {
            IOUtils.copy(resource, sw, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tank[] unmarshal = JaxbMarschaller.unmarshal(Tank[].class, sw.toString());
        tanks = Arrays.stream(unmarshal).map(ViewTank::map).collect(Collectors.toList());




    }


    public void compare(ActionEvent actionEvent) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", true);
        options.put("height", "50%");
        options.put("width", "50%");
        options.put("top", 75);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        compareTanks = null;
        RequestContext.getCurrentInstance().openDialog("compare", options, null);
        System.out.println(tanks.stream().filter(ViewTank::isSelected).map(ViewTank::getTitle).collect(Collectors.toList()));
    }

    public List<ViewTank> getCompareTanks() {
        if (compareTanks != null) return compareTanks;
        compareTanks = tanks.stream().filter(ViewTank::isSelected).collect(Collectors.toList());
        if (compareTanks.isEmpty()) return new ArrayList<>();
        ViewTank.ViewTankBuilder b = ViewTank.builder();

        b.damage(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getDamage)).get().getDamage());
        b.damageMax(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getDamageMax)).get().getDamageMax());
        b.premiumPurchasePrice(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getPremiumPurchasePrice)).get().getPremiumPurchasePrice());
        b.rate(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getRate)).get().getRate());
        b.salvoReloadTime(compareTanks.stream().max(Comparator.comparingDouble(ViewTank::getSalvoReloadTime)).get().getSalvoReloadTime());
        b.armorPenFactor(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getArmorPenFactor)).get().getArmorPenFactor());
        b.tier(compareTanks.stream().max(Comparator.comparingInt(ViewTank::getTier)).get().getTier());

        maxtank = b.build();


        return compareTanks;
    }

}
