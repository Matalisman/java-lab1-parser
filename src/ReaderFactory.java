/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateusz
 */
public class ReaderFactory {
    
    String output = "";
    public ReaderFactory (String path){
       
        if(path == null) {
            throw new IllegalArgumentException("Path may not be null");
        }
        if (path.startsWith("http://") || path.startsWith("www")) {
            WebReader webReader = new WebReader(path);
            output = webReader.read();
        }
        else {
            FileReader fileReader = new FileReader(path);
            output = fileReader.read();
        }
    }
    
    public String getOutput()
    {
        return output;
    }
}
