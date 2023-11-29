package finalseptiembre23;


public class SistemaEstacionAnual extends SistemaEstacion {
    
    public SistemaEstacionAnual(String nombre, Coordenadas coordenadas, int cantidadAnios, int anioInicial) {
        super(nombre, coordenadas, cantidadAnios, anioInicial);
    }
    
    @Override
    public String calcularPromedios() {
        String informacion = "";
     
        for (int anio = 0; anio < this.getCantAnios(); anio ++) {
            double totalTemp = 0;
            for(int mes = 0; mes < 12; mes++) {
                totalTemp += this.getTemperaturas()[anio][mes];
            }
            double promedio = totalTemp / 12;
            int anioReal = anio + this.getAnioInicial();
            informacion += "Año " + anioReal + ": " + promedio +" ºC";
        }
        
        return informacion;
    }
}
