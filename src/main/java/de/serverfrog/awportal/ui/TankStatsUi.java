package de.serverfrog.awportal.ui;

import de.serverfrog.awportal.eao.TankEao;
import de.serverfrog.awportal.entity.Tank;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Serverfrog on 16.07.17.
 */

@Controller
@RequestMapping("/tanks")
@Log4j
public class TankStatsUi  {


    @Autowired
    private final TankEao tankEao;

    public TankStatsUi(TankEao tankEao) {
        this.tankEao = tankEao;
    }

    @GetMapping
    public ModelAndView list() {
        Iterable<Tank> tanks = this.tankEao.findAll();
        return new ModelAndView("tanks/list", "messages", tanks);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Tank tank) {
        return new ModelAndView("tanks/view", "tank", tank);
    }

    @GetMapping(params = "form")
    public String createForm(@ModelAttribute Tank message) {
        return "tanks/form";
    }

    @PostMapping
    public ModelAndView create(@Valid Tank message, BindingResult result,
                               RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("tanks/form", "formErrors", result.getAllErrors());
        }
        message = this.tankEao.save(message);
        redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
        return new ModelAndView("redirect:/{tank.id}", "tank.id", message.getId());
    }


    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Tank tank) {
        return new ModelAndView("tanks/form", "tank", tank);
    }



    @Bean
    public Converter<String, Tank> tankConverter() {
        return new Converter<String, Tank>() {
            @Override
            public Tank convert(String id) {
                return tankEao.findOne(Long.valueOf(id));
            }
        };
    }

}
