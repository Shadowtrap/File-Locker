package Backend;

import java.io.File;
import java.io.IOException;

public class TestFileCreator {

    public static void main(String args[]){
        int twen = 1;
        while(twen < 21){
            String fileNames = "test" + twen + ".txt";
            File tests = new File("C:\\Users\\Arnav\\Desktop\\Test.Test2\\" + fileNames);
            try{
                tests.createNewFile();
            }
            catch(IOException e){

            }
            twen+=1;
        }
    }

}
