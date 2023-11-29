package finalseptiembre23;

/**
 * Superclase de EstaciónPoraño y EstaciónPorMes
 */
public abstract class SistemaEstacion {
    
    private String nombre;
    private Coordenadas coordenadas;
    private double[][] temperaturas;
    private int cantidadAnios, anioInicial;
    
    public SistemaEstacion(String nombre, Coordenadas coordenadas, int cantidadAnios, int anioInicial) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.temperaturas = new double[cantidadAnios][12];
        this.cantidadAnios = cantidadAnios;
        this.anioInicial = anioInicial;
    }
    
    public void registrarTemperatura(double temperatura, int mes, int anio) {
        int anioMatriz = anio - this.anioInicial;
        this.temperaturas[anioMatriz][mes] = temperatura;
    }
    
    public double temperaturaDeLaFecha(int mes, int anio) {
        int anioMatriz = anio - this.anioInicial;
        return this.temperaturas[anioMatriz][mes];
    }
    
    public String maximaTemperatura() {
        int anio, mes, mesMax=-1, anioMax=-1;
        double tempMax = -32000;
        
        for(anio = 0; anio < this.cantidadAnios; anio++) {
            for(mes = 0; mes < 12; mes++) {
                double tempMes = this.temperaturas[anio][mes];
                if(tempMes > tempMax) {
                    tempMax = tempMes;
                    mesMax = mes;
                    anioMax = anio;
                }
            }
        }
        
        anioMax = this.anioInicial + anioMax;
        
        return "La mayor temperatura fue de: " + tempMax +  ". Se registró el " + mesMax + "/" + anioMax + ".";
    }
     
    public abstract String calcularPromedios();
    
    public String promedios() {
        return this.nombre + " (" + this.coordenadas.toString() + ") :" +  this.calcularPromedios();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double[][] getTemperaturas() {
        return temperaturas;
    }
    
    public int getCantAnios() {
        return this.cantidadAnios;
    }

    public int getAnioInicial() {
        return anioInicial;
    }
    
}
