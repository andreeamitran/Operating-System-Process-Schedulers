/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tema;

public class ProcessStructure {
    
    private String type;
    private int weight;
    
    public ProcessStructure(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
    
    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
