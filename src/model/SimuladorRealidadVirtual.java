package model;

public abstract class SimuladorRealidadVirtual extends Atraccion implements ClasificableRiesgo {
    private int numeroEstaciones;
    private boolean requiereGafasEspeciales;


    public SimuladorRealidadVirtual(String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada, int numeroEstaciones, boolean requiereGafasEspeciales) {
                        super( nombre,  zonaUbicacion, capacidadMaxima,edadMinimaAnios, visitantesPorDia,  precioEntrada);
                        this.numeroEstaciones = numeroEstaciones;
                        this.requiereGafasEspeciales = requiereGafasEspeciales;
                     }
    
      public double calcularIngresoDiario(int visitantesPorDia, double precioEntrada) {
        if(requiereGafasEspeciales) {
          return visitantesPorDia * precioEntrada;
        }

        return visitantesPorDia * precioEntrada * 0.9;
      }

      public String determinarRiesgo(boolean requiereGafasEspeciales, int numeroEstaciones) {
        if(requiereGafasEspeciales && numeroEstaciones >= 20) {
          return "ALTO";
        }
        else if (requiereGafasEspeciales || numeroEstaciones >= 20) {
          return "MEDIO";
        }
        
      return "BAJO";
      }

      public boolean requiereMantenimiento(int numeroEstaciones, int visitantesPorDia, int capacidadMaxima) {
        if(numeroEstaciones > 20 || visitantesPorDia > capacidadMaxima) {
          return true;
        }
        return false;
      }

}