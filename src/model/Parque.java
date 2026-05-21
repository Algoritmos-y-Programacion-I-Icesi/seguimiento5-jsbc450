package model;

import java.util.ArrayList;

/**
 * Clase controladora del sistema MagicWorld.
 * Administra la lista de atracciones y centraliza las operaciones
 * que la interfaz de usuario necesita realizar.
 */
public class Parque {

    private String nombre;
    private ArrayList<Atraccion> atracciones;

    /**
     * Constructor del Parque. Inicializa el ArrayList de atracciones.
     */
    public Parque(String nombre) {
        this.nombre = nombre;
        this.atracciones = new ArrayList<>();
    }

    /**
     * Retorna la lista completa de atracciones registradas.
     */
    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    /*
     * Los visitantes se inicializan en 0 y luego pueden registrarse
     * mediante el metodo registrarVisitantes.
     */
    /**
     * Registra una atracción previamente construida en el sistema añadiéndola al contenedor.
     * @pre El parámetro nuevaAtraccion no debe ser nulo.
     * @post La atracción se almacena en la lista del parque, incrementando su tamaño en 1.
     * @param nuevaAtraccion Objeto de tipo Atraccion que se va a registrar.
     */
    public void registrarAtraccion(Atraccion nuevaAtraccion) {
        atracciones.add(nuevaAtraccion); 
    }

    /**
     * Crea e instancia un Simulador de Realidad Virtual y lo registra en el sistema.
     * @pre El nombre y la zonaUbicacion no deben ser nulos. La capacidad, el precio y las estaciones deben ser mayores o iguales a cero.
     * @post Se añade una nueva instancia de SimuladorRealidadVirtual al contenedor del parque.
     * @param nombre El nombre de la atracción.
     * @param zonaUbicacion La zona donde se ubica.
     * @param capacidadMaxima El límite máximo de personas.
     * @param getEdadMinimaAnios La edad mínima requerida.
     * @param precioEntrada El costo de la entrada.
     * @param numeroEstaciones Cantidad de estaciones disponibles.
     * @param requiereGafasEspeciales Indica si exige el uso de visores VR.
     */
    public void registrarAtraccionSimulador(String nombre, String zonaUbicacion, int capacidadMaxima, int getEdadMinimaAnios, double precioEntrada, int numeroEstaciones, boolean requiereGafasEspeciales) {
        Atraccion sim = new SimuladorRealidadVirtual(nombre, zonaUbicacion, capacidadMaxima, getEdadMinimaAnios, precioEntrada, numeroEstaciones, requiereGafasEspeciales);
        registrarAtraccion(sim); 
    }

    /**
     * Crea e instancia un Juego Infantil y lo registra en el sistema.
     * @pre El nombre y la zonaUbicacion no deben ser nulos. La capacidad, el precio y las edades deben ser mayores o iguales a cero.
     * @post Se añade una nueva instancia de JuegoInfantil al contenedor del parque.
     * @param nombre El nombre de la atracción.
     * @param zonaUbicacion La zona donde se ubica.
     * @param capacidadMaxima El límite máximo de personas.
     * @param edadMinimaAnios La edad mínima permitida.
     * @param precioEntrada El costo de la entrada.
     * @param edadMaxima El límite máximo de edad permitido.
     * @param tieneSupervisionSiempre Indica si cuenta con personal de supervisión constante.
     */
    public void registrarAtraccionInfantil(String nombre, String zonaUbicacion, int capacidadMaxima, int edadMinimaAnios, double precioEntrada, int edadMaxima, boolean tieneSupervisionSiempre) {
        Atraccion juego = new JuegoInfantil(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, precioEntrada, edadMaxima, tieneSupervisionSiempre);
        registrarAtraccion(juego);
    }

    /**
     * Crea e instancia un Espectáculo Pirotécnico y lo registra en el sistema.
     * @pre El nombre y la zonaUbicacion no deben ser nulos. La capacidad, el precio y la duración deben ser mayores o iguales a cero.
     * @post Se añade una nueva instancia de EspectaculoPirotecnico al contenedor del parque.
     * @param nombre El nombre del espectáculo.
     * @param zonaUbicacion La zona donde se ubica.
     * @param capacidadMaxima El límite de espectadores.
     * @param edadMinimaAnios La edad mínima permitida.
     * @param precioEntrada El costo de la entrada.
     * @param duracion El tiempo total de duración en minutos.
     * @param tieneMaterialPeligroso Indica si manipula material explosivo categorizado de riesgo.
     */
    public void registrarAtraccionEspectaculo(String nombre, String zonaUbicacion, int capacidadMaxima, int edadMinimaAnios, double precioEntrada, int duracion, boolean tieneMaterialPeligroso) {
        Atraccion show = new EspectaculoPirotecnico(nombre, zonaUbicacion, capacidadMaxima, edadMinimaAnios, precioEntrada, duracion, tieneMaterialPeligroso);
        registrarAtraccion(show);
    }

     /**
     * Busca una atraccion por nombre y registra sus visitantes del dia.
     * @param nombreAtraccion nombre de la atraccion
     * @param visitantesPorDia cantidad de visitantes del dia
     */
    public void registrarVisitantes(String nombreAtraccion, int visitantesPorDia) {
        Atraccion atraccionEncontrada = buscarAtraccionPorNombre(nombreAtraccion);

        if (atraccionEncontrada == null) {
            System.out.println("No se encontro una atraccion con el nombre: " + nombreAtraccion);
        } else {
            atraccionEncontrada.setVisitantesPorDia(visitantesPorDia);
        }
    }

    /**
     * Busca una atraccion por su nombre.
     * 
     * @param nombreAtraccion nombre de la atraccion buscada
     * @return la atraccion encontrada o null si no existe
     */
    public Atraccion buscarAtraccionPorNombre(String nombreAtraccion) {
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getNombre().equalsIgnoreCase(nombreAtraccion)) {
                return atraccion;
            }
        }

        return null;
    }

    // ---------------------------------------------------------------
    // CALCULOS Y REPORTES
    // ---------------------------------------------------------------

    /**
     *
     */
    public double calcularIngresoTotalDiario() {
        //Completar para cumplir con el requerimiento
        return 0;
    }

    /**
     *
     */
    public void mostrarIngresosDiarios() {
        //Completar para cumplir con el requerimiento
    }

    /**
     */
    public void generarReporteOperaciones() {
        //Completar para cumplir con el requerimiento
    }

    public void mostrarAtraccionesClasifRiesgo(){
        //Completar para cumplir con el requerimiento
    }
    public void generarReporteAlertasCapacidad(){
        //Completar para cumplir con el requerimiento
    }
}