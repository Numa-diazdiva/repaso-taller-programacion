package finalseptiembre23;

/**
 * Clase para representar las coordenadas de la estación modelada por un SistemaEstación
 */
public class Coordenadas {
    private double latitud, longitud;
    private char orientacionLatitud, orientacionLongitud;


    public Coordenadas(double latitud, double longitud, char  orientacionLatitud, char orientacionLongitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.orientacionLatitud = orientacionLatitud;
        this.orientacionLongitud = orientacionLongitud;
    }
    
    @Override
    public String toString() {
        return this.latitud + " " +  this.orientacionLatitud +  " - " + this.longitud + " " + this.orientacionLatitud;
    }
    
}
