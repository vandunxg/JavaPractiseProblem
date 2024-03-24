import java.util.ArrayList;
import java.util.List;

public class Dictionary{
    private List<Word> wordList = new ArrayList<>();

    public Dictionary(){}
    public Dictionary(List<Word> wordList) {
        this.wordList = wordList;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void addNewWord(String en, String vn){
        en = en.toLowerCase();
        if(this.Search(en)){
            int ID = this.wordList.size() + 1;
            Word word = new Word(ID, en, vn);
            this.wordList.add(word);
            System.out.print("\t\t\t\t\tThêm từ thành công!\n");
        } else{
            System.out.print("\t\t\t\t\tThêm thất bại từ đã có trong từ điển!\n");
        }
    }

    public boolean Search(String en){
        en = en.toLowerCase();
        if (wordList == null || wordList.isEmpty()) {
            return true;
        }
        int l = 0, r = this.wordList.size() - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(this.wordList.get(m).en.compareTo(en) == 0){
                return false;
            }
            else if(this.wordList.get(m).en.compareTo(en) > 0)
                r = m - 1;
            else
                l = m + 1;
        }
        return true;
    }

    public String binarySearch(String en){
        en = en.toLowerCase();
        if (wordList == null || wordList.isEmpty()) {
            return "Từ điển không có từ nào.";
        }
        int l = 0, r = this.wordList.size() - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(this.wordList.get(m).en.compareTo(en) == 0){
                return "Từ cần tìm là : \n" + "\t\t\t\t\t\t" +
                "ID : " +this.wordList.get(m).ID +   " - en : "   +  this.wordList.get(m).en + " - vn : " + this.wordList.get(m).vn;
            }
            else if(this.wordList.get(m).en.compareTo(en) > 0)
                r = m - 1;
            else
                l = m + 1;
        }
        return "Không tìm thấy từ cần tìm trong từ điển";
    }


}
