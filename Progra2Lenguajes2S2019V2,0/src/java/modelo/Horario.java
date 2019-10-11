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
    private Integer entrada;
    private Integer salida;
    private List<String> diasSemana;

    public Horario() {
    }

    
    public Horario(Integer entrada, Integer salida, List<String> diasSemana) {
        this.entrada = entrada;
        this.salida = salida;
        this.diasSemana = diasSemana;
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
    
    public String getDiasToString() {
        String dias = "";
        
        for(int x = 0; x < this.getDiasSemana().size(); x++){
            dias += this.diasSemana.get(x);
        }
        
        return dias;
    }

    public void setDiasSemana(List<String> diasSemana) {
        this.diasSemana = diasSemana;
    }
    
    @Override
    public String toString(){
        String informe = (Integer.toString(this.entrada) + '|' + Integer.toString(this.salida) +
                '|' + this.getDiasToString());
        
        return informe;
    }
}
