/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tema;

import java.util.ArrayList;

public class ProblemData {

    private String cacheType;
    private int cacheCapacity;
    private String schedulerType;
    private ProcessStructure[] processes;
    private int[] numbersToBeProcessed;
    
    public ProblemData(String cacheType, int cacheCapacity, String schedulerType, ProcessStructure[] processes, int[] numbersToBeProcessed) {
        this.cacheType = cacheType;
        this.cacheCapacity = cacheCapacity;
        this.schedulerType = schedulerType;
        this.processes = processes;
        this.numbersToBeProcessed = numbersToBeProcessed;
    }
    
    public String getCacheType() {
        return cacheType;
    }

    public int getCacheCapacity() {
        return cacheCapacity;
    }

    public String getSchedulerType() {
        return schedulerType;
    }

    public ProcessStructure[] getProcesses() {
        return processes;
    }

    public int[] getNumbersToBeProcessed() {
        return numbersToBeProcessed;
    }    
}
