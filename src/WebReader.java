/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Mateusz
 */
public class WebReader implements AbstractReaderInterface {

    private String path;

    WebReader(String path) {
        System.out.println("Webreader");
        this.path = path;
    }

    /**
     *
     * @return
     */
    @Override
    public String read() {
       String content = null;
           
        System.out.println("Funkcja read())");
        String output ="";
       
            content = this.readSource();
       
        
            String[] slowa = null;
            String regex = "((https?|http?):((//)|(.))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)|((www.)+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        
        try {
            
            slowa = content.split("=\"|\\s+|>|\"|'");
            
            for (int i=1; i<slowa.length; i++){
                System.out.println(slowa[i]);
            }
            
            for (int i=0; i<slowa.length; i++) {
            if (slowa[i].matches(regex)) { // matches uses regex
               
            System.out.println("Match " + slowa[i]);
            output = output + slowa[i] + " ";
        }
            }}  catch(NullPointerException e){}
        
        return output;
        }

    String readSource() {
        String content = null;
        Scanner scanner = null;
        try {
            URL url = new URL(path);
            scanner = new Scanner(url.openStream());
            }
        catch (Exception e) {
            System.out.println("Can not read URL");
            e.printStackTrace();
            }
            
        
        while(scanner.hasNext())
            {    
            content += scanner.nextLine();
            }
            System.out.println(content);
        
        return content;    
    }
}