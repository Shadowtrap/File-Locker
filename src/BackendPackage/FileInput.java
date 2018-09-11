package BackendPackage;

import java.io.File;
import javax.swing.JOptionPane;

public class FileInput {
    private String path;
    private boolean fileLock;
    private String password;
    private String origExt;
    
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
    
    private void setPassword(String password){
        this.password = password;
    }
    
    private void setOrigExt(String origExt){
        this.origExt = origExt;
    }
    
    public String getPath(){
        return this.path;
    }
    public boolean getFileLock(){
        return this.fileLock;
    }
    private String getPassword(){
        return this.password;
    }
    private String getOrigExt(){
        return this.origExt;
    }
    
    @Override
    public String toString(){
        return "The path of the file is " + this.path;
    }
    
    public void password(){
        String password = JOptionPane.showInputDialog("Input a password for file.");
        this.password = password;
    }
    
    public void lockFile(){
        File file = new File(this.path);
        password();
        this.fileLock = true;
        int dot = this.path.indexOf(".");
        origExt = this.path.substring(dot + 1);
        String noExt = this.path.substring(0, dot);
        File newFile = new File(noExt + ".jet");
        file.renameTo(newFile);
        this.path = newFile.getPath();
    }
    
    public void unlockFile(){
        int dot = this.path.indexOf(".");
        System.out.println(this.path);
        String ext = this.path.substring(dot + 1);
        System.out.println(ext);
        if(ext.equals("jet")){
            String userEntered = JOptionPane.showInputDialog("Input the password for the file");;
            if(this.password.equals(userEntered)){
                this.fileLock = false;
                String pathNoExt = this.path.substring(0,dot);
                File oldFile = new File(pathNoExt + ".jet");
                File newFile = new File (pathNoExt + "." + origExt);
                oldFile.renameTo(newFile);
            }
        }  
    }
}
