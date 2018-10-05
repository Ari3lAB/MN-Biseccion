package biseccion;

import java.util.Scanner;

/**
 *
 * @author Ariel AB
 */
public class Biseccionador {

    Scanner teclado = new Scanner(System.in);

    public void bisecciona(double limIzq, double limDer, double error) {
        double xI = limIzq;
        double xD = limDer;
        double eMax = error;
        double fxI = f(xI);
        double fxD = f(xD);
        double xM = xMedia(xI, xD);
        double fxM = f(xM);
        short contador = 1;

        if (xI >= xD || xI == xD) {
            System.out.println("Valores de entrada invalidos");
            return;
        }

        System.out.println("Valores iniciales: X izq= " + xI + "  X der= " + xD + " Error: " + eMax);

        while (Math.abs(fxM) >= eMax) {
            System.out.println("\nIteracion #" + contador);
            System.out.println("X media= " + xM);
            System.out.println("F(X) izquierda= " + fxI);
            System.out.println("F(X) derecha= " + fxD);
            System.out.println("F(X) media= " + fxM);
            if (fxM * fxI > 0) {
                xI = xM;
                fxI = f(xI);
                fxD = f(xD);
                xM = xMedia(xI, xD);
                fxM = f(xM);
            } else {
                xD = xM;
                fxI = f(xI);
                fxD = f(xD);
                xM = xMedia(xI, xD);
                fxM = f(xM);
            }

            contador++;
            System.out.println("Nueva X izq= " + xI);
            System.out.println("Nueva X der= " + xD);
        }
        System.out.println("Raiz: " + xM);

    }

    public double f(double x) {
        double fx;
        fx = (double) (-12 * (Math.pow(x, 5))) - (6.4 * (Math.pow(x, 3))) + 12;
        return fx;
    }

    public double xMedia(double x1, double x2) {
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
