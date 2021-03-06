/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadernillorubio;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class CuadernilloRubio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion=EntradaSalida.mostrarMenu();
        String nombre_usuario="";
        if (opcion!=4)
        {
        nombre_usuario=EntradaSalida.preguntarNombre();
        }
        //Menu: 1-Sumas 2-Restas 3-Multiplicaciones 4 Ver rasnking 5-Salir
          
        while(opcion!=5)
        {
           int operaciones_correctas=0;
           int numero_operaciones_pedidas=0;
            //Aqui
            if(opcion!=4)
            {
              numero_operaciones_pedidas=EntradaSalida.preguntarCuantas();//Este metodo pregunta cuantas operaciones quiere hacer
            }
             int operaciones_hechas=0;
            
            switch (opcion)
            {
                        case 1:
                            while(operaciones_hechas<numero_operaciones_pedidas)
                            {
                            Operacion o=Operacion.obtenerSuma();//Este metodo devuelve un objeto Operacion, que tiene como propiedades los 2 sumandos, el resultado y el signo + y e
                            int respuesta_usuario=EntradaSalida.mostrarOperacion(o,nombre_usuario );
                            if(respuestaCorrecta(o, respuesta_usuario)==true)
                                {
                                    operaciones_correctas++;
                                    EntradaSalida.darEnhorabuena();
                                }
                            operaciones_hechas++;
                            }  
                            
                            break;
                        case 2:
                           while(operaciones_hechas<numero_operaciones_pedidas)
                            {
                            Operacion o=Operacion.obtenerResta();//Este metodo devuelve un objeto Operacion, que tiene como propiedades los 2 sumandos, el resultado y el signo + y e
                            int respuesta_usuario=EntradaSalida.mostrarOperacion(o,nombre_usuario );
                            if(respuestaCorrecta(o, respuesta_usuario)==true)
                                {
                                    operaciones_correctas++;
                                    EntradaSalida.darEnhorabuena();
                                }
                            operaciones_hechas++;
                            }
                           
                            break;
                        case 3:
                            //Lo mismo pero con resta
                            break;
                        case 4:
                            ArrayList<Puntuacion> lista_puntuaciones=AccesoFichero.obtenerPuntuaciones();
                            EntradaSalida.mostrarPuntuaciones(lista_puntuaciones);
                            break;
            }//Fin del switch. Ya tengo los aciertos, el total y el nombre
            //Grabar nombre,respuestas_correctas,operaciones_totales
            //Puntuacion con propiedades nombre, aciertos, total
            if (opcion!=4)
            {
                Puntuacion p=new Puntuacion(nombre_usuario, operaciones_correctas, operaciones_hechas);
                AccesoFichero.grabarPuntuacion(p);
            }
            opcion=EntradaSalida.mostrarMenu();
        }
    }

    private static boolean respuestaCorrecta(Operacion o, int respuesta_usuario) {
     
        int respuesta_ok=o.getResultado();
        if(respuesta_ok==respuesta_usuario)
        {
            return true;
        }
        return false;
        //return (respuesta_ok==resp_usr);
    
    }
    
    
}
