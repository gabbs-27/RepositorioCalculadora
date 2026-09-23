package com.mycompany.calculadoranotas;

/**
 * @author Gabriela Moreno C
 */
public class Estudiante {

    private static final double PORC_DESARROLLO = 0.6;
    private static final double PORC_MATEMATICA = 0.4;
    private static final double NOTA_APROBACION = 3.5;
    private static final double NOTA_MAXIMA = 5.0;

    private int codigo;
    private String nombre;
    private double notaDesarrollo;
    private double notaMatematica;

    public Estudiante(int codigo, String nombre, double notaDesarrollo, double notaMatematica) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notaDesarrollo = notaDesarrollo;
        this.notaMatematica = notaMatematica;
    }

    public double calcularDefinitiva() {
        return notaDesarrollo * PORC_DESARROLLO + notaMatematica * PORC_MATEMATICA;
    }

    public String obtenerAprobacion() {
        return calcularDefinitiva() < NOTA_APROBACION ? "NO APRUEBA" : "SI APRUEBA";
    }


    public void incrementarNotaDesarrollo(double cifra) {
        notaDesarrollo = Math.min(notaDesarrollo + cifra, NOTA_MAXIMA);
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getNotaDesarrollo() { return notaDesarrollo; }
    public void setNotaDesarrollo(double notaDesarrollo) { this.notaDesarrollo = notaDesarrollo; }

    public double getNotaMatematica() { return notaMatematica; }
    public void setNotaMatematica(double notaMatematica) { this.notaMatematica = notaMatematica; }
}
