/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevoscarrera;

/**
 *
 * @author Leidy Torres
 */
public class Inicio {
    
        Equipo uno = new Equipo("Verde");
        Equipo dos = new Equipo("Azul");
        Equipo tres = new Equipo("Rojo");
        
        Persona primerCorredor = new Persona ("Corredor1", 0, 33, uno);
        Persona segundoCorredor = new Persona ("Corredor2", 33, 66, uno);
        Persona tercerCorredor = new Persona ("Corredor3", 66, 100, uno);
        
        Persona cuartoCorredor = new Persona ("Corredor4", 0, 33, dos);
        Persona quintoCorredor = new Persona ("Corredor5", 33, 66, dos);
        Persona sextoCorredor = new Persona ("Corredor6", 66, 100, dos);
        
        Persona septimoCorredor = new Persona ("Corredor7", 0, 33, tres);
        Persona octavoCorredor = new Persona ("Corredor8", 33, 66, tres);
        Persona novenoCorredor = new Persona ("Corredor9", 66, 100, tres);
        
        /**
        * Metodo que inicia los hilos de relevos
        */
        public void iniciaCarrera(){
            
            primerCorredor.start();
            segundoCorredor.start();
            tercerCorredor.start();
            
            cuartoCorredor.start();
            quintoCorredor.start();
            sextoCorredor.start();
            
            septimoCorredor.start();
            octavoCorredor.start();
            novenoCorredor.start();
        }
        /**
        * Metodo que dice quien gano
        */
        public void Ganador (String equipo){
            System.out.println("GANADOR: \n");
            System.out.println(" \t\t" +equipo);
            System.exit(0);
        }
}
