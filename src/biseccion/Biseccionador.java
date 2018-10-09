package biseccion;

import java.util.Scanner;

/**
 *
 * @author Ariel AB
 */
public class Biseccionador {

    Scanner teclado = new Scanner(System.in);

    private void bisecciona(double limIzq, double limDer, double error) {
        double xI = limIzq;
        double xD = limDer;
        double eMax = error;
        double fxI = f(xI);
        double fxD = f(xD);
        double xM = xMedia(xI, xD);
        double fxM = f(xM);
        short contador = 1;

        if ((fxI > 0 && fxD > 0) || ((fxI < 0 && fxD < 0))) {                    //Verifica si existe raiz entre xi y xd
            System.out.println("Sin raíces en este intervalo");
            return;
        }

        System.out.println("Valores iniciales: X izq= " + xI + "  X der= " + xD
                + " Error: " + eMax);

        while (Math.abs(fxM) >= eMax) {
            System.out.println("\n\nIteracion #" + contador);
            System.out.print("X media= ");
            System.out.printf("%06f", xM);
            System.out.print("\nF(X) izquierda= ");
            System.out.printf("%06f", fxI);
            System.out.print("\nF(X) derecha= ");
            System.out.printf("%06f", fxD);
            System.out.print("\nF(X) media= ");
            System.out.printf("%06f", fxM);

            if (fxM * fxI > 0) {
                xI = xM;
            } else {
                xD = xM;
            }

            fxI = f(xI);
            fxD = f(xD);
            xM = xMedia(xI, xD);
            fxM = f(xM);

            contador++;
            System.out.print("\nNueva X izq= ");
            System.out.printf("%06f", xI);
            System.out.print("\nNueva X der= ");
            System.out.printf("%06f", xD);

        }
        System.out.print("\n\nRaiz: ");
        System.out.printf("%06f", xM);
        System.out.print("\nF(X) media= ");
        System.out.printf("%06f", fxM);

    }

    private double f(double x) {
        double fx;
        fx = (double) (-12 * (Math.pow(x, 5))) - (6.4 * (Math.pow(x, 3))) + 12; //metodo para calcular F(x)
        return fx;
    }

    private double xMedia(double x1, double x2) {                                //metodo para calcular xM (en biseccion)
        return ((x1 + x2) / 2);
    }

    public void main() {
        double limIzq;
        double limDer;
        double error;
        System.out.println("Ingrese el limite izquierdo:");
        limIzq = teclado.nextDouble();
        System.out.println("Ingrese el limite derecho:");
        limDer = teclado.nextDouble();
        System.out.println("Ingrese el error máximo:");
        error = teclado.nextDouble();
        bisecciona(limIzq, limDer, error);
    }
}
