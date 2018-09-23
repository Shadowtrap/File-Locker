package Backend;

import javax.swing.*;
import java.io.File;

public class FileInput {
    private String path;
    private boolean fileLock;
    private String password;
    private String origExt;

    public FileInput() {
        this.path = "na";
        this.fileLock = false;
        this.password = "";
    }

    public FileInput(String path) {
        this.path = path;
        this.fileLock = false;
        this.password = "";
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean getFileLock() {
        return this.fileLock;
    }

    private void setFileLock(boolean fileLock) {
        this.fileLock = fileLock;
    }

    private String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getOrigExt() {
        return this.origExt;
    }

    private void setOrigExt(String origExt) {
        this.origExt = origExt;
    }

    @Override
    public String toString() {
        return "The path of the file is " + this.path;
    }

    public void password() {
        String password = JOptionPane.showInputDialog("Input a password for file.");
        this.password = password;
    }

    public void systemFileSecure(){
        String windows = "C:\\Windows";
        String programFiles1 = "C:\\Program Files (x86)";
        String programFiles2 = "C:\\Program Files";
        String perfLogs = "C:\\PerfLogs";
        int indW = this.path.indexOf(windows);
        int indPF1 = this.path.indexOf(programFiles1);
        int indPF2 = this.path.indexOf(programFiles2);
        int indPL = this.path.indexOf(perfLogs);
        System.out.println(indW);
        if(indW == 0 || indPF1 == 0 || indPF2 == 0 || indPL == 0){
            JOptionPane.showMessageDialog(null, "You are not allowed to modify this file.");
            this.path = null;
        }
    }

    public void lockFile() {
        systemFileSecure();
        File oldFile = new File(this.path);
        password();
        this.fileLock = true;
        for(int i = this.path.length() - 1; i > this.path.length() - 7; i-=1) {
            char dot = this.path.charAt(i);
            if (dot == '.'){
                origExt = this.path.substring(i + 1);
                String noExt = this.path.substring(0, i + 1);
                File newFile = new File(noExt + "jet");
                oldFile.renameTo(newFile);
                this.path = newFile.getPath();
            }
        }
    }

        public void unlockFile() {
            systemFileSecure();
            for(int i = this.path.length() - 1; i > this.path.length() - 6; i-=1) {
                char dot = this.path.charAt(i);
                if (dot == '.') {
                    String ext = this.path.substring(i + 1);
                    if (ext.equals("jet")) {
                        String userEntered = JOptionPane.showInputDialog("Input the password for the file");
                        if (this.password.equals(userEntered)) {
                            this.fileLock = false;
                            String pathNoExt = this.path.substring(0, i);
                            File oldFile = new File(pathNoExt + ".jet");
                            File newFile = new File(pathNoExt + "." + origExt);
                            oldFile.renameTo(newFile);
                        }
                    }
                }
            }
        }
    }


//Could put security on system file that should not be touched WHATSOEVER
    //Index of C:/ProgramFiles,ProgramFiles(x86),Windows,PerfLogs
    //If equal to 1 give message not allowed to lock and ofc NOT LOCK