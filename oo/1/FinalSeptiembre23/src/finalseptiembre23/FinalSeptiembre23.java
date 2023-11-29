package finalseptiembre23;

import java.util.Random;

public class FinalSeptiembre23 {

    public static void main(String[] args) {
        SistemaEstacion sistemaMes, sistemaAnio;
     
        sistemaMes = new SistemaEstacionMensual("Rawson", new Coordenadas(12,15, 'O', 'N'), 3, 2020);
        sistemaAnio = new SistemaEstacionAnual("Tulum",  new Coordenadas(12,233, 'E', 'S'),3,2020);
        
        Random generadorAl = new Random(123);
        
        for (int i = 0; i < 3; i++) {
            for(int anio = 2020; anio < 2023; anio++) {
                for(int mes = 0; mes < 12; mes++) {
                    sistemaMes.registrarTemperatura(generadorAl.nextDouble() * 20 - 10, mes, anio);
                    sistemaAnio.registrarTemperatura(generadorAl.nextDouble() * 40, mes, anio);   
                }
            }
        } 
         // Nota: la consigna pedía cargarle a uno 3 años y al otro 4 -no lo hice-
        System.out.println(sistemaMes.promedios());
        System.out.println(sistemaAnio.promedios());
        System.out.println(sistemaMes.maximaTemperatura());
        System.out.println(sistemaAnio.maximaTemperatura());
        
    }
    
}
