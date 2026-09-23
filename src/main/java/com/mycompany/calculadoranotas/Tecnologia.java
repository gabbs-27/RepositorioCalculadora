package com.mycompany.calculadoranotas;

/**
 * @author Gabriela Moreno C
 */
public class Tecnologia {

    private Estudiante[] estudiantes;
    private int cantidadRegistrados;

    public Tecnologia(int numeroEstudiantes) {
        estudiantes = new Estudiante[numeroEstudiantes];
        cantidadRegistrados = 0;
    }

    /** Guarda un estudiante en la siguiente posición libre. Retorna false si el arreglo está lleno. */
    public boolean registrarEstudiante(Estudiante e) {
        if (cantidadRegistrados >= estudiantes.length) {
            return false;
        }
        estudiantes[cantidadRegistrados] = e;
        cantidadRegistrados++;
        return true;
    }

    /** Reporte inicial: todos los datos, la definitiva y la aprobación de cada estudiante. */
    public String generarReporte() {
        String reporte = "REPORTE GENERAL\n\n";
        for (int i = 0; i < cantidadRegistrados; i++) {
            Estudiante e = estudiantes[i];
            reporte += "Código: " + e.getCodigo()
                    + "\nNombre: " + e.getNombre()
                    + "\nNota Desarrollo: " + String.format("%.2f", e.getNotaDesarrollo())
                    + "\nNota Matemática: " + String.format("%.2f", e.getNotaMatematica())
                    + "\nDefinitiva: " + String.format("%.2f", e.calcularDefinitiva())
                    + "\nAprobación: " + e.obtenerAprobacion()
                    + "\n-----------------------------\n";
        }
        return reporte;
    }

    /** Modificación 1: código, nombre y definitiva de quienes superan la notaLimite. */
    public String listarSuperioresA(double notaLimite) {
        String lista = "Estudiantes con definitiva superior a " + notaLimite + ":\n\n";
        int encontrados = 0;
        for (int i = 0; i < cantidadRegistrados; i++) {
            Estudiante e = estudiantes[i];
            if (e.calcularDefinitiva() > notaLimite) {
                lista += e.getCodigo() + " - " + e.getNombre()
                        + " - " + String.format("%.2f", e.calcularDefinitiva()) + "\n";
                encontrados++;
            }
        }
        if (encontrados == 0) {
            lista += "Ningún estudiante supera esa nota.";
        }
        return lista;
    }

    /** Modificación 2: incrementa la nota de Desarrollo de todos. No retorna nada (void). */
    public void incrementarNotasDesarrollo(double cifra) {
        for (int i = 0; i < cantidadRegistrados; i++) {
            estudiantes[i].incrementarNotaDesarrollo(cifra);
        }
    }

    public Estudiante[] getEstudiantes() { return estudiantes; }
    public int getCantidadRegistrados() { return cantidadRegistrados; }
}
