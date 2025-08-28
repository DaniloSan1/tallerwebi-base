package com.tallerwebi.TDD;

import java.util.HashMap;
import java.util.Map;

public class TDD {

    public static String validarFortaleza(String contraseña) {
        String msj = "";
        if (contraseña.length()>1 && contraseña.length()<=8 && contarNumeros(contraseña)<=0) {
            msj = "DEBIL";    
        }else if (contraseña.length()>= 8 && contarNumeros(contraseña) == 1 && contarCaracterEspecial(contraseña) == 1 ){
            msj = "MEDIANA";
        }else if(contraseña.length()>= 8 && contarLetras(contraseña) >= 4 && contarNumeros(contraseña) >= 2 && contarCaracterEspecial(contraseña) >= 2 ){
            msj  = "FUERTE";
        }else{
            msj = "INVALIDA";
        }
        return msj;
    }
    public static int contarNumeros(String c){
        int count = 0;
        for (char ch : c.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }
    public static int contarCaracterEspecial(String c){
        Integer count = 0;
        for (Character ch : c.toCharArray()){
            if (!Character.isLetterOrDigit(ch)) {
                count++;
            }
        }
        return count;
    }
    public static int contarLetras(String c){
        Integer count = 0;
        for (char ch : c.toCharArray()){
            if (Character.isLetter(ch)) {
               count++; 
            }
        }
        return count;
    }
    public static String clasificarTemperatura(Integer temperatura, String unidad) {
        String msj = "";
        String unidadN = String.valueOf(unidad.trim().toLowerCase().charAt(0));
            if (!unidadN.equals("c") && !unidadN.equals("f")) {
                msj = "Unidad no valida";
            }
        Double temperaturaEnC = 0.0;
            if (unidadN.equals("f")) {
                temperaturaEnC = (temperatura - 32) * 5.0 / 9.0;
            }else{
                temperaturaEnC = temperatura.doubleValue();
            }
    if (temperaturaEnC <= 0) {
        msj= "CONGELANTE";
    } else if (temperaturaEnC <= 15) {
        msj = "FRÍA";
    } else if (temperaturaEnC <= 25) {
        msj = "TEMPLADA";
    } else if (temperaturaEnC <= 35) {
        msj = "CALUROSA";
    } else {
        msj = "PELIGROSA";
    }

        return msj;
    }
    public static Integer romanoAEntero (String numero) throws CombinacionRomanaInvalidaException{
        Map <Character, Integer> valor = new HashMap<>();
        valor.put('I', 1);
        valor.put('V', 5);
        valor.put('X', 10);
        valor.put('L', 50);
        valor.put('C', 100);
        
        if (numero == null || numero.isEmpty()) {
        throw new CombinacionRomanaInvalidaException("Entrada vacía");
    }

    int repeticiones = 1;
    int total = 0;
    int valorPrevio = 0;

    for (int i = numero.length() - 1; i >= 0; i--) {
        char c = numero.charAt(i);
        Integer val = valor.get(c);
        if (val == null) throw new CombinacionRomanaInvalidaException("Símbolo inválido");

       
        if (i < numero.length() - 1 && numero.charAt(i) == numero.charAt(i + 1)) {
            repeticiones++;
            if ((c == 'V' || c == 'L') || repeticiones > 3) {
                throw new CombinacionRomanaInvalidaException("Repetición inválida de " + c);
            }
        } else {
            repeticiones = 1;
        }

        
        if (val < valorPrevio) {
            if (!((c == 'I' && (valorPrevio == 5 || valorPrevio == 10)) ||
                  (c == 'X' && (valorPrevio == 50 || valorPrevio == 100)))) {
                throw new CombinacionRomanaInvalidaException("Sustracción inválida: " + c + " antes de " + numero.charAt(i + 1));
            }
            total -= val;
        } else {
            total += val;
        }

        valorPrevio = val;
    }

    if (total < 1 || total > 100) {
        throw new CombinacionRomanaInvalidaException("Número fuera de rango");
    }

    return total;

    }
}
