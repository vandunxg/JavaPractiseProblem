import java.util.HashMap;
import java.util.LinkedHashMap;

public class Word {
    int ID;
    String en;
    String vn;
    public Word() {
    }

    public Word(int ID, String en, String vn) {
        this.ID = ID;
        this.en = en;
        this.vn = vn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String toString(){
        return this.en + " : " + this.vn;
    }
}
