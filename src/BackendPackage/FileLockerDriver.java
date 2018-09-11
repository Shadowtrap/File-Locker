package BackendPackage;

public class FileLockerDriver{
    
    public static void main(String args[]){
        
        FileInput test = new FileInput(/*some path*/);
        
        test.lockFile();
        test.unlockFile();
        
    }
    
}