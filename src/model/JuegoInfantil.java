package model;

public abstract class JuegoInfantil extends Atraccion{
    private int edadMaxima;
    private boolean tieneSupervisionSiempre;

    public JuegoInfantil (String nombre, String zonaUbicacion, int capacidadMaxima, int edadMinimaAnios, int visitantesPorDia, double precioEntrada, int edadMaxima, boolean  tieneSupervisionSiempre) {
            super(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, visitantesPorDia, precioEntrada);

            this.edadMaxima = edadMaxima;
            this.tieneSupervisionSiempre = tieneSupervisionSiempre;
    
    }
    

    public double calcularIngresoDiario(int visitantesPorDia, double precioEntrada) {
        if (!tieneSupervisionSiempre) {
            return visitantesPorDia * precioEntrada;
        }
        return (visitantesPorDia * precioEntrada) + (visitantesPorDia * 50000);

    }

        public boolean requiereMantenimiento(boolean tieneSupervisionSiempre, int visitantesPorDia, int capacidadMaxima) {
            if(!tieneSupervisionSiempre || visitantesPorDia > capacidadMaxima) {
                return true;
            }
            return false;
        }
}
