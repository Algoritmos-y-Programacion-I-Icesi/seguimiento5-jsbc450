package model;

public class EspectaculoPirotecnico extends Atraccion implements ClasificableRiesgo {

    private int duracion;
    private boolean tieneMaterialPeligroso;
    public EspectaculoPirotecnico (String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada, int duracion, boolean tieneMaterialPeligroso) {
                        super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);

                        this.duracion = duracion;
                        this.tieneMaterialPeligroso = tieneMaterialPeligroso;
                     }
    public double calcularIngresoDiario(int visitantesPorDia, double precioEntrada) {
        if (!tieneMaterialPeligroso) {
            return visitantesPorDia * precioEntrada;
        }
        return (visitantesPorDia * precioEntrada) + (visitantesPorDia * precioEntrada * 0.20);
    }

    public String determinarRiesgo(boolean tieneMaterialPeligroso, int duracion) {
        if(tieneMaterialPeligroso) {
            return "ALTO";
        } 
        else if (duracion >= 60) {
            return "MEDIO";
        }
        return "BAJO";
    }

    public boolean requiereMantenimiento(boolean tieneMaterialPeligroso, int duracion) {
        if(tieneMaterialPeligroso || duracion > 60) {
            return true;
        }
        return false;
    }
}
