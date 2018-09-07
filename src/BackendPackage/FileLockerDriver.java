package BackendPackage;

public class FileLockerDriver{
    
    public static void main(String args[]){
        
        FileInput test = new FileInput(/*file path*/);
        test.openFile();
        test.lockFile();
        test.unlockFile();
        
    }
    
}