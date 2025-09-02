package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Contacto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;



public class ContactoControllerTest {
   
    @Test
    void debeMostrarFormularioDeContacto() {
        ContactoController controller = new ContactoController();
        ModelAndView model = controller.mostrarFormulario();
        assertThat(model.getViewName(), equalTo("contacto"));
    }

    @Test
    void debeProcesarFormularioYMostrarConfirmacion() {
        ContactoController controller = new ContactoController();
        Contacto contacto = new Contacto();
        contacto.setNombre("Danilo");
        contacto.setEmail("Danilo@ejemplo.com");
        contacto.setMensaje("hola");
        ModelAndView model = controller.procesarFormulario(contacto);
        assertThat(model.getViewName(), equalTo("confirmacion"));
        assertThat(model.getModel().get("contacto"), equalTo(contacto));
    }
}