package com.tallerwebi.TDD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

import org.junit.jupiter.api.Test;

public class TDDTest {

    @Test
    public void debeDevolverINVALIDA_cuandoLaContraseñaEsNula() {

        String contraseñaDe3Caracteres = "";
        String fortalezaDeLaContraseña = TDD.validarFortaleza(contraseñaDe3Caracteres);

        assertThat(fortalezaDeLaContraseña, equalToIgnoringCase("INVALIDA"));
    }

    @Test
    public void debeDevolverDEBIL_cuandoLaContraseñaTiene8Caracteres() {

        String contraseñaDe8Caracteres = "abcdefgh";
        String fortalezaDeLaContraseña = TDD.validarFortaleza(contraseñaDe8Caracteres);

        assertThat(fortalezaDeLaContraseña, equalToIgnoringCase("DEBIL"));
    }

    @Test
    public void debeDevolverDEBIL_cuandoLaContraseñaTiene4Caracteres() {

        String contraseñaDe4Caracteres = "abcd";
        String fortalezaDeLaContraseña = TDD.validarFortaleza(contraseñaDe4Caracteres);

        assertThat(fortalezaDeLaContraseña, equalToIgnoringCase("DEBIL"));
    }

    @Test
    public void debeDevolverMEDIANA_cuandoLaContraseñaTiene8CaracteresUnNumeroyUnCaracterEspecial(){
        String contraseñaDe8Caracteres = "1abc@dcf";
        String fortalezaDeLaContraseña = TDD.validarFortaleza(contraseñaDe8Caracteres);

        assertThat(fortalezaDeLaContraseña, equalToIgnoringCase("MEDIANA"));
    }
    @Test
    public void debeDevolverFUERTE_cuandoLaContraseñaTiene8CaracteresDosNumerosCincoLetrasDosCaracteresEspeciales(){
        String contraseña = "12abe$!f";
        String fortalezaDeLaContraseña = TDD.validarFortaleza(contraseña);

        assertThat(fortalezaDeLaContraseña, equalToIgnoringCase("FUERTE"));
    }
}
