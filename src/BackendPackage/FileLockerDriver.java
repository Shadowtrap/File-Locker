package BackendPackage;

public class FileLockerDriver{
    
    public static void main(String args[]){
        
        FileInput test = new FileInput(/*test*/);
        
        test.lockFile();
        test.unlockFile();
        
    }
}