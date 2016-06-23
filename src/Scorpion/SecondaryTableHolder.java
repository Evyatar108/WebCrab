/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scorpion;

/**
 *
 * @author Evyatar M
 */
public class SecondaryTableHolder implements java.io.Serializable {

    private String ids;
    private String target;
    private int sum;
    
    public SecondaryTableHolder(String target,String ids,int sum){
        this.ids=ids;
        this.sum=sum;
        this.target=target;
    }
    
    public String getIds(){
        return ids;
    }
    public String getTarget(){
        return target;
    }
    public int getSum(){
        return sum;
    }
    
}

    
