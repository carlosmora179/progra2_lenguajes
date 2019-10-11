/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author alece
 */
public class Horario {

   
    private Integer idHorario;
    private Integer entrada;
    private Integer salida;
    private List<String> diasSemana;

    public Horario() {
    }

    
    public Horario(Integer id ,Integer entrada, Integer salida, List<String> diasSemana) {
        this.idHorario = id;
        this.entrada = entrada;
        this.salida = salida;
        this.diasSemana = diasSemana;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }
    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Integer getSalida() {
        return salida;
    }

    public void setSalida(Integer salida) {
        this.salida = salida;
    }

    public List<String> getDiasSemana() {
        return diasSemana;
    }
    public  String getDiasSemanatoString() {
        String dias = "";
        
       for(int x=0; x<this.diasSemana.size();x++){
           if(x==(this.diasSemana.size()-1)){
              dias += this.diasSemana.get(x); 
           }
           else{
               dias += this.diasSemana.get(x) + ',';
           }
           
           
       }
       
       return dias;
    }

    public void setDiasSemana(List<String> diasSemana) {
        this.diasSemana = diasSemana;
    }
    @Override
    public String toString(){
        String resultado = this.idHorario+"-"+this.entrada+"-"+this.salida+"-"+getDiasSemanatoString();
        return resultado;
    }
}
