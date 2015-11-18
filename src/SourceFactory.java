/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karola
 */
public class SourceFactory {
     String output = "";
    public SourceFactory (String path){
       
        if(path == null) {
            throw new IllegalArgumentException("Path may not be null");
        }
        if (path.startsWith("http://") || path.startsWith("www")) {
            WebReader webReader = new WebReader(path);
            output = webReader.readSource();
        }
        else {
            FileReader fileReader = new FileReader(path);
            output = fileReader.readSource();
        }
    }
    
    public String getOutput()
    {
        return output;
    }
}


