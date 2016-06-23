/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Evyatar M
 */
public class WebContent {
    private String pattern ;
  private  int CountLinks;
  private  int CountTargets;
   private Set<String> TargetSet;
   private Set<String> LinkSet;
    
    public WebContent(String pattern){
        this.pattern=pattern;
        CountLinks=0;
        CountTargets=0;
    }
    
    public String getPattern(){
        return pattern;
    }
    
     public void setPattern(String pattern){
        this.pattern=pattern;
    }
    
    
    public int getCountTargets(){
        return CountTargets;
    }
    public int getCountLinks(){
        return CountLinks;
    }
    public Set<String> getTargetSet(){
        return TargetSet;
    }
     public Set<String> getLinkSet(){
        return LinkSet;
    }
     
     private void addLink(String link)
     {
        if(LinkSet.add(link))
         CountLinks++;            //we count it here instead of the built in countgroup method to ignore duplicates
     }
      private void addTarget(String target)
     {
        if (TargetSet.add(target))     //we count it here instead of the built in countgroup method to ignore duplicates
         CountTargets++;
     }
      
      
      
      public boolean Extract(String url){
        TargetSet = new HashSet<String>();
        LinkSet = new HashSet<String>();
        CountLinks=0;
        CountTargets=0;
          try { 
             //trying to connect to a webpage
             Document doc = Jsoup.connect(url).ignoreContentType(true).get();  
             Elements links = doc.select("a[href]");
        
             for (Element link : links) {
                 ;
                 addLink(sanatizelink(link.attr("abs:href")));
             }
             
             Pattern p = Pattern.compile(pattern);
             Matcher matcher = p.matcher(doc.text());
             while (matcher.find())
             {
                 addTarget(matcher.group());

             }
             
             return true;
          }
          
          catch (IOException exc){
              System.out.println(exc);
              return false;
          }
          catch(IllegalArgumentException exc){
              System.out.println(exc);
              return false;
          }
      }

    public static String sanatizelink(String attr) {
      
        if (attr.indexOf('#')!=-1){
            attr= attr.substring(0,attr.indexOf('#'));
        }
        if (attr.indexOf('?')!=-1){
            attr= attr.substring(0,attr.indexOf('?'));
        }
        if (attr.length()>0){
        if((attr.charAt(attr.length()-1))=='/'){
            attr=attr.substring(0,attr.length()-1);
        }
        }
        return attr;
    }

      
}
