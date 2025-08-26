package com.tallerwebi.TDD;

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
}
