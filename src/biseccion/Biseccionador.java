package biseccion;
import java.util.Scanner;
/**
 *
 * @author Ariel AB
 */
public class Biseccionador {
    
    private float limIzq = 0;
    private float limDer = 0;
    private float error = 0;
    Scanner teclado = new Scanner(System.in);
    public void bisecciona(float limIzq, float limDer, float error){
        float fxI=f(limIzq);
        float fxD=f(limDer);
        float xM=xMedia(limIzq,limDer);
        short contador = 1;
        boolean izqNeg = true;
        if (limIzq >= limDer || limIzq == limDer) {
            System.out.println("Valores de entrada invalidos");
            return;
        }
        
        if (fxI>0) {
            izqNeg= false;
        }
        
        if( (fxI>0 && fxD>0) && (fxI<0 && fxD<0)){
            System.out.println("No hay raices en el itervalo");
            return;
        }else{
            System.out.println("Valores iniciales: X izq= " + limIzq + "  X der= " + limDer + "Error: " + error);
        }        
        while(error > Math.abs(f(xM))|| Math.abs(f(xM))==0 ){
            System.out.println("\nIteracion #" + contador);
            System.out.println("X media= " + xM);
            System.out.println("F(X) izquierda= " + fxI);
            System.out.println("F(X) derecha= " + fxD);
            System.out.println("F(X) media= " + f(xM));
            if(f(xM) < 0 && izqNeg == true){
                limIzq=xM;
            } else{
                limDer=xM;
            }
            
            xM=xMedia(limIzq,limDer);
            fxI=f(limIzq);
            fxD=f(limDer);            
            contador++;
            
            System.out.println("Nueva X izq= " + limIzq);
            System.out.println("Nueva X der= " + limDer);
        }
        
        System.out.println("Raiz: " + xM);
        
    }
    public float f(float x){
        float fx;
        fx= (float) (((-12 * (Math.pow(x, 5))) - (6.4 * (Math.pow(x, 3))) + 12));
        return fx;
    }
    
    public float xMedia(float x1, float x2){
        return ((x1 + x2) / 2);
    }
    
    public void main(){
        System.out.println("Ingrese el limite izquierdo:");
        this.limIzq = teclado.nextFloat();
        System.out.println("Ingrese el limite derecho:");
        this.limDer = teclado.nextFloat();
        System.out.println("Ingrese el error máximo:");
        this.error = teclado.nextFloat();
        bisecciona(limIzq, limDer, error);
    }
}
