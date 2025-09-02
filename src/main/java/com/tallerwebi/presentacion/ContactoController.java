package com.tallerwebi.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tallerwebi.dominio.Contacto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactoController {
    @GetMapping ("/contacto")    
    public ModelAndView mostrarFormulario(){
        ModelAndView model = new ModelAndView("contacto");
        model.addObject("contacto", new Contacto());
        return model;
    }
    @PostMapping("/contacto")
    public ModelAndView procesarFormulario(@ModelAttribute Contacto contacto) {
        ModelAndView model = new ModelAndView("confirmacion");
        model.addObject("contacto", contacto);
        return model;
    }
    
}
