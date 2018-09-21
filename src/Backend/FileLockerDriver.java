package Backend;

public class FileLockerDriver{
    
    public static void main(String args[]){
        
        FileInput test = new FileInput();
        
        test.lockFile();
        test.unlockFile();
        
    }
}
