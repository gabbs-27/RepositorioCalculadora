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


    public boolean registrarEstudiante(Estudiante e) {
        if (cantidadRegistrados >= estudiantes.length) {
            return false;
        }
        estudiantes[cantidadRegistrados] = e;
        cantidadRegistrados++;
        return true;
    }


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
            lista += "No hay un estudiante que supere esa nota.";
        }
        return lista;
    }


    public void incrementarNotasDesarrollo(double cifra) {
        for (int i = 0; i < cantidadRegistrados; i++) {
            estudiantes[i].incrementarNotaDesarrollo(cifra);
        }
    }

    public Estudiante[] getEstudiantes() { return estudiantes; }
    public int getCantidadRegistrados() { return cantidadRegistrados; }
}
