package finalseptiembre23;


public class SistemaEstacionMensual extends SistemaEstacion {
    
    public SistemaEstacionMensual(String nombre, Coordenadas coordenadas, int cantidadAnios, int anioInicial) {
        super(nombre, coordenadas, cantidadAnios, anioInicial);
    }
    
    @Override
    public String calcularPromedios() {
        double[] promedios = new double[12];
        
        for(int mes = 0; mes < 12; mes++) {
            double total = 0;
            for(int anio = 0; anio < this.getCantAnios(); anio++) {
                total += this.getTemperaturas()[anio][mes];
            }
            promedios[mes] = total / this.getCantAnios();
        }
        
        return "Enero: " + promedios[0] + "; " +
                 "Febrero: " + promedios[1] + "; " +
                 "Marzo: " + promedios[2] + "; " +
                 "Abril: " + promedios[3] + "; " +
                 "Mayo: " + promedios[4] + "; " +
                 "Junio: " + promedios[5] + "; " +
                 "Julio: " + promedios[6] + "; " +
                 "Agosto: " + promedios[7] + "; " +
                 "Septiembre: " + promedios[8] + "; " +
                 "Octubre: " + promedios[9] + "; " +
                 "Noviembre: " + promedios[10] + "; " +
                 "Diciembre: " + promedios[11] + "; "
                ;
    }
    
}
