package Backend;

public class FileLockerDriver{
    
    public static void main(String args[]){
        
        FileInput test = new FileInput("C:\\Users\\Arnav\\Desktop\\Test.Test2\\test1.txt");
        
        test.lockFile();
        test.unlockFile();
        
    }
}
