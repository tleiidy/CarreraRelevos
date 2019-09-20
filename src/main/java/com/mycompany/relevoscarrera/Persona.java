/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leidy Torres
 */
public class Persona extends Thread {
    Equipo equipo;
    private String nombreCorredor;
    private int inicio;
    private int fin;
    private String equipoUno;
    private String equipoDos;
    private String equipoTres;
    
    /**
     *Constructor que inicializa las varibles
     * @param nombreCorredor
     * @param inicio
     * @param fin
     * @param equipo 
     */
    public Persona ( String nombreCorredor, int inicio, int fin, Equipo equipo ){
        
        this.fin = fin;
        this.inicio = inicio;
        this.nombreCorredor = nombreCorredor;
        this.equipo = equipo;
    }

    @Override
    public void run() {
        if (inicio == 0){
            personaUno();}
        else{
            esperar();}
        if (inicio == 33){
            personaDos();}
        else{
            esperar();}
        if (inicio == 66){
            personaTres();}
        else{
            esperar();}
    }

    
    /**
    *  Metodo que inicia al corredor uno
    */
    public void personaUno(){
        while (true){
            int posicionActual = avanzar(1);
            if (posicionActual >= 33 ){
                equipo.setPosicionCorredorUno(33);
                synchronized (equipo){
                    equipo.notifyAll();
                    inicio = 33;
                }break;
            }
        }
    }

    /**
    *  Metodo que inicia al corredor dos
    */
    public void personaDos(){
        while (true){
            int posicionActual = avanzar(2);
            if ( posicionActual >= 66 ){
                equipo.setPosicionCorredorDos(66);
                synchronized (equipo){
                    equipo.notify();
                    
                }break;
            }
        }
    }

    /**
    *  Metodo que inicia al corredor tres y evalua colores
    */
    public void personaTres(){
        while (true){
            int posicionActual = avanzar(3);
            if ( posicionActual >= 100 ){
                equipo.setPosicionCorredorTres(100);
                if (equipo.getNombre().equals("Verde")){
                    equipo.setNombre("VERDE");
                }else if(equipo.getNombre().equals("Azul")){
                    equipo.setNombre("AZUL");
                }else if(equipo.getNombre().equals("Rojo")){
                    equipo.setNombre("ROJO");
                }
                Inicio inicio = new Inicio();
                inicio.Ganador(equipo.getNombre());
                break;
            }
        }
    }

    /**
    *  Metodo que sincroniza y espera
    */
    public void esperar(){
        synchronized (equipo){
            try{
                equipo.wait();
            }catch (InterruptedException ex){
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
   *  Metodo que hace avanzar a cada jugador
   */
    public int avanzar (int numCorredor){
        try{
            Thread.sleep(300);
        }
        catch (InterruptedException ex){
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avanzando = Utilitario.random();
        if ( numCorredor == 1 ){
            equipo.setPosicionCorredorUno(equipo.getPosicionCorredorUno()+avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorUno();
        }
        if ( numCorredor == 2 ){
            equipo.setPosicionCorredorDos(equipo.getPosicionCorredorDos()+avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorDos();
        }
        if ( numCorredor == 3 ){
            equipo.setPosicionCorredorTres(equipo.getPosicionCorredorTres()+avanzando);
            validarEquipo();
            return equipo.getPosicionCorredorTres();
        }
        return 0;
    }

   /**
   *  Metodo que evalua el equipo de corredores
   */
    private void validarEquipo() {
        if (equipo.mostrarPosicion().contains("Verde")){
            equipoUno = equipo.mostrarPosicion();
            if (equipoUno != null){
                System.out.println(equipoUno);
            }
        }else if (equipo.mostrarPosicion().contains("Azul")){
            equipoDos = equipo.mostrarPosicion();
            if (equipoDos != null){
                System.out.println(equipoDos);
            }
        }else if (equipo.mostrarPosicion().contains("Rojo")){
            equipoTres = equipo.mostrarPosicion();
            if (equipoTres != null){
                System.out.println(equipoTres);
            }
        }
        
    }
}