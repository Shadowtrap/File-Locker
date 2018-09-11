package BackendPackage;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;


public class FileInput {
    private String path;
    private boolean fileLock;
    private String password;
    
    public FileInput(){
        this.path = "na";
        this.fileLock = false;
        this.password = "";
    }
    
    public FileInput(String path){
        this.path = path;
        this.fileLock = false;
        this.password = "";
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    private void setFileLock(boolean fileLock){
        this.fileLock = fileLock;
    }
    
    private void setPassword(String path){
        this.password = password;
    }
    
    public String getPath(){
        return this.path;
    }
    public boolean getFileLock(){
        return this.fileLock;
    }
    private String getPassword(String path){
        return this.password;
    }
    
    @Override
    public String toString(){
        return "The path of the file is " + this.path;
    }
  //To the next Comment I have no idea what i did  
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
    //The next comment
    public void password(){
        String password = JOptionPane.showInputDialog("Input a password for file.");
        String password2 = "&!" + password + "&!";
        this.password = password2;
    }
    
    public void lockFile(){
        File file = new File(this.path);
        password();
        this.fileLock = true;
        int dot = this.path.indexOf(".");
        String noExt = this.path.substring(0, dot);
        File newFile = new File(noExt + ".jet");
        file.renameTo(newFile);
    }
    
    public void unlockFile(){
        if(this.fileLock == true){
            String userEntered = JOptionPane.showInputDialog("Input the password for the file");
            int passwordLen = this.password.length();
            String actualPassword = this.password.substring(2,passwordLen-2);
            if(actualPassword.equals(userEntered)){
                this.fileLock = false;
                int dot = this.path.indexOf(".");
                String origExt = this.path.substring(dot);
                String pathNoExt = this.path.substring(0,dot);
                File oldFile = new File(pathNoExt + ".jet");
                File newFile = new File (pathNoExt + origExt);
                oldFile.renameTo(newFile);
                
                
                
                
            }
        }
        
    }
}
