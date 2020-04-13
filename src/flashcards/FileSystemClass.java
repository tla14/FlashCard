/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

/**
 *
 * @author derek
 */
public class FileSystemClass {
    private int Id;
    private String term;
    private String def;
    

    public FileSystemClass() {
    }

    public FileSystemClass(int Id, String term, String def) {
        this.Id = Id;
        this.term = term;
        this.def = def;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return "FileSystemClass{" + "term=" + term + ", def=" + def + '}';
    }
    
    
    
}
