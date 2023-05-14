package tictactoe;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        main.juego();
    }

    static Scanner input = new Scanner(System.in);
    final static char[] posDefecto = {'0','1','2','3','4','5','6','7','8','9'};
    static char[] posN;

    final static boolean[] cambiosDefecto = {true,true,true,true,true,true,true,true,true};

    static boolean[] cambiosN;

    static int posicion = 0;


    public static void nuevoTablero(){
        posN = posDefecto;
        cambiosN=cambiosDefecto;

    }
    public static void layaout (char [] pos){
        System.out.println( "\n\n" );
        System.out.println(  "\n\n" );
        System.out.println(  "\n\n\t\t" + pos [1] + "   | " +pos [2]+ "  | " +pos [3]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +pos [4]+ "   | " +pos [5]+ "  | " +pos [6]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t ___|____|___ " );
        System.out.println(  "\n\n\t\t" +pos [7]+ "   | " +pos [8]+ "  | " +pos [9]);
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  " \t\t    |    |   " );
        System.out.println(  "\n\n" );
    }

    public static void juego(){

        int contador = 0;
        int opcion;
        boolean loop = true;
        do{
            if(contador == 0){
                main.nuevoTablero();
            }
            main.turno('X');
            contador++;

            
            // S: una funcion solo se encarga de una cosa
            //coger bloque de codigo y hacerla funcion
            if (contador > 8){
                System.out.println("Quiere jugar otravez? 0 = no. 1 = sí.");
                opcion = input.nextInt();
                if (opcion == 1){
                    contador =0;
                } else if (opcion == 0) {
                    System.out.println("adios");
                    loop =false;
                }
            }

            main.turno('Y');
            contador++;

        }while(loop);

    }




    /**
     *
     * @param lBool , esta sera la posicion de bool en su lista, con la que vamos a determinar si esa
     *               posicion esta seleccionada o no
     * @param lChar , esta sera la posicion del caracter por el que vamos a poner X o Y
     * @param valor , este sera el caracter X o Y
     */
    public static boolean cambiarChar(int lBool, int lChar, char valor){


            if(cambiosN[lBool]){
                posN[lChar]=valor;
                cambiosN[lBool] = false;
                return false;
            }else{
                System.out.println("Este caracter ya esta seleccionado");
                return true;
            }

    }

    /**
     *
     * @param turno , el caracter que indicara el turno X o Y
     *
     * @see nextInt() , capturaremos la posicion donde quiere poner ficha el usuario
     * @see selec(int poscicion, char turno), para pasar la posicion seleccionada
     * @see layaout(char[] array) para poder visualizar el tablero tras cada turno
     */
    public static void turno(char turno){
        boolean loop = false;
        main.layaout(posN);
        do{
            System.out.print("Turno "+turno+ " selecciona una posicion para poner ficha: ");
            posicion = input.nextInt();
            loop=selec(posicion, turno);
            System.out.println(" ");
            main.layaout(posN);
        }while(loop);

    }
    /**
     *
     * @param seleccion , sera el int que nos mandara el usuario para determinar la posicion sobre
     *                  la que quiere escribir
     * @param turno , aqui vamos a introducir X o Y dependiendo de quien sea el turno
     */
    public static boolean selec(int seleccion, char turno){

        switch (seleccion){
            case 1:

                return cambiarChar(0,1,turno);

            case 2:
                return cambiarChar(1,2,turno);

            case 3:
                return cambiarChar(2,3,turno);

            case 4:
                return cambiarChar(3,4,turno);

            case 5:
                return cambiarChar(4,5,turno);

            case 6:
                return cambiarChar(5,6,turno);

            case 7:
                return cambiarChar(6,7,turno);

            case 8:
                return cambiarChar(7,8,turno);

            case 9:
                return cambiarChar(8,9,turno);

            default:
                System.out.println("Numero no contemplado");
                return false;

        }


    }

}


