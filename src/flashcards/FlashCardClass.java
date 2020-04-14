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
public class FlashCardClass {
    private String term;
    private String def;
    private boolean isFlipped;

    public FlashCardClass() {
    }

    public FlashCardClass(String term, String def) {
        this.term = term;
        this.def = def;
        isFlipped=false;
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
    public void FlipCard(){
    if(isFlipped){
        isFlipped = false;
    }
    else{
        isFlipped = true;
    }
    }

    @Override
    public String toString() {
        if(isFlipped){
            return def;
        }
        else{
            return term;
        }
    }
}
