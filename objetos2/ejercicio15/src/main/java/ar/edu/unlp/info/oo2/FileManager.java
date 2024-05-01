package ar.edu.unlp.info.oo2;


import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<FileComponent> files;
    public FileManager(){
        this.files = new ArrayList<FileComponent>();
    }
    public void addFile(FileComponent file){
        this.files.add(file);
    }
}
