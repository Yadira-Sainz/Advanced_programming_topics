/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abecedariohilos;

/**
 *
 * @author yadira
 */
public class AbecedarioHilos {

    public static void main(String[] args) {
        
        Runnable mayusculasRunnable = new ImprimirAbc('A', 'Z');
        Runnable minusculasRunnable = new ImprimirAbc('a', 'z');

        Thread hiloMayusculas = new Thread(mayusculasRunnable);
        Thread hiloMinusculas = new Thread(minusculasRunnable);

        hiloMayusculas.start();
        hiloMinusculas.start();        
    }
}

class ImprimirAbc implements Runnable {
    private char inicio;
    private char fin;

    public ImprimirAbc(char inicio, char fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run() {
        for (char letra = inicio; letra <= fin; letra++) {
             System.out.print(letra + " ");
        }
    }    
}
