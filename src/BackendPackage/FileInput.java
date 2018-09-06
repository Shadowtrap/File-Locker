package BackendPackage;

import java.awt.Desktop;
import java.io.File;


public class FileInput {
    private String path;
    
    public FileInput(){
        this.path = "na";
    }
    
    public FileInput(String path){
        this.path = path;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public String toString(){
        return "The path of the file is " + this.path;
    }
    
    public void openFile(){
        File file = new File(this.path);
        Desktop desk = Desktop.getDesktop();
        if(file.exists()){
            try{
                desk.open(file);
            }
            catch(Exception e){
                
            }
        }
    }
}
