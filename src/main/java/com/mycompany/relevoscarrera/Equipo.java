/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevoscarrera;


import java.util.Date;

/**
 *
 * @author Leidy Torres
 */
public class Equipo {
    
    private String nombreEquipo;
    private Date finaliza;
    private int posicion;
    private int posicionCorredorUno;
    private int posicionCorredorDos;
    private int posicionCorredorTres;
    

    /**
     * Constructor de la clase
     * @param nombreEquipo 
     */
    public Equipo ( String nombreEquipo ){
        
        this.nombreEquipo = nombreEquipo;
        this.posicionCorredorUno = 0;
        this.posicionCorredorDos = 33;
        this.posicionCorredorTres = 66;
        finaliza = null;
    }
    
    String rojo ="\033[31m";
    String verde ="\033[32m"; 
    String azul ="\033[34m";
    
    /**
     * Metodo que me devuelve la posicion
     */
    public synchronized String mostrarPosicion(){
        String posicion ="";
        ///posicion = "Equipo:  "+nombreEquipo+" ";
        
        if(nombreEquipo.equals("Verde")){
            posicion = "  "+verde+nombreEquipo+" ";
        }
        if(nombreEquipo.equals("Azul")){
            posicion = "  "+azul+nombreEquipo+" ";
        }
        if(nombreEquipo.equals("Rojo")){
            posicion = "  "+rojo+nombreEquipo+" ";
        }
        
        for(int i = 0; i<= 100; i++){
            if(i == posicionCorredorUno){
                posicion += "1";                
            }else if (i == posicionCorredorDos){
                posicion += "2";
            }else if (i == posicionCorredorTres){
                posicion += "3";
            }else{
                posicion += "_";
            }
        }
    return posicion;}

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo
     
     */
    public void setNombre(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * 
     * @return  finaliza
     */
    public Date getFinaliza() {
        return finaliza;
    }

    /**
     * 
     * @param finaliza 
     */
    public void setFinaliza(Date finaliza) {
        this.finaliza = finaliza;
    }

   

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
        
    }

    /**
     * @return the posicionCorredorUno
     */
    public int getPosicionCorredorUno() {
        return posicionCorredorUno;
    }

    /**
     * @param posicionCorredorUno the posicionCorredorUno to set
     */
    public void setPosicionCorredorUno(int posicionCorredorUno) {
        this.posicionCorredorUno = posicionCorredorUno;
    }

    /**
     * @return the posicionCorredorDos
     */
    public int getPosicionCorredorDos() {
        return posicionCorredorDos;
    }

    /**
     * @param posicionCorredorDos the posicionCorredorDos to set
     */
    public void setPosicionCorredorDos(int posicionCorredorDos) {
        this.posicionCorredorDos = posicionCorredorDos;
    }

    /**
     * @return the posicionCorredorTres
     */
    public int getPosicionCorredorTres() {
        return posicionCorredorTres;
    }

    /**
     * @param posicionCorredorTres the posicionCorredorTres to set
     */
    public void setPosicionCorredorTres(int posicionCorredorTres) {
        this.posicionCorredorTres = posicionCorredorTres;
    }
    
    
}
