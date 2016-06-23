/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author Evyatar M
 */
public class MainTableHolder implements java.io.Serializable {
    private int id;
    private String url;
    private int targets;
    private boolean scanned;
    
    public MainTableHolder(int id,String url,int targets,boolean scanned){
        this.id=id;
        this.url=url;
        this.targets=targets;
        this.scanned=scanned;
    }
    
    public int getId(){
        return id;
    }
    public String getUrl(){
        return url;
    }
    public int getTargets(){
        return targets;
    }
    public boolean getScanned(){
        return scanned;
    }
    
}


