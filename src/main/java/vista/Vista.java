package vista;

import javax.swing.JOptionPane;
import com.mycompany.calculadoranotas.Estudiante;
import com.mycompany.calculadoranotas.Tecnologia;

/**
 *
 * @author Gabriela Moreno C
 */
public class Vista {

    public static void main(String[] args) {
        int n = leerEntero("Ingrese cantidad de estudiantes:", 1, Integer.MAX_VALUE);
        Tecnologia tecnologia = new Tecnologia(n);


        for (int i = 1; i <= n; i++) {
            int codigo = leerEntero("Estudiante " + i + "\nIngrese el código (mayor a 21000):",
                    21001, Integer.MAX_VALUE);
            String nombre = leerTexto("Estudiante " + i + "\nIngrese el nombre:");
            double notaDes = leerDouble("Nota de Desarrollo de " + nombre + " (0.0 - 5.0):", 0.0, 5.0);
            double notaMat = leerDouble("Nota de Matemática de " + nombre + " (0.0 - 5.0):", 0.0, 5.0);
            tecnologia.registrarEstudiante(new Estudiante(codigo, nombre, notaDes, notaMat));
        }

        // Reporte inicial
        JOptionPane.showMessageDialog(null, tecnologia.generarReporte());

        // Modificación 1
        double notaLimite = leerDouble("Ingrese la nota límite (0.0 - 4.9):", 0.0, 4.9);
        JOptionPane.showMessageDialog(null, tecnologia.listarSuperioresA(notaLimite));

        // Modificación 2
        double cifra = leerDouble("Ingrese la cifra de incremento para Desarrollo (0.0 - 0.5):", 0.0, 0.5);
        tecnologia.incrementarNotasDesarrollo(cifra);
        JOptionPane.showMessageDialog(null, "Notas actualizadas.\n\n" + tecnologia.generarReporte());
    }



    private static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) System.exit(0); 
            try {
                int valor = Integer.parseInt(entrada.trim());
                if (valor >= min && valor <= max) return valor;
            } catch (NumberFormatException ex) {

            }
            JOptionPane.showMessageDialog(null, "Error, ingrese otro valor:");
        }
    }

    private static double leerDouble(String mensaje, double min, double max) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) System.exit(0);
            try {
                double valor = Double.parseDouble(entrada.trim().replace(',', '.'));
                if (valor >= min && valor <= max) return valor;
            } catch (NumberFormatException ex) {
                // se vuelve a pedir
            }
            JOptionPane.showMessageDialog(null, "Valor inválido, debe estar entre " + min + " y " + max + ".");
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) System.exit(0);
            if (!entrada.trim().isEmpty()) return entrada.trim();
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
        }
    }
}
