import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\t\t\t--------------------MENU--------------------");
            System.out.println("\t\t\t\t1. Tìm kiếm từ.");
            System.out.println("\t\t\t\t2. Thêm từ vào từ điển.");
            System.out.println("\t\t\t\t3. Lưu danh sách từ trong từ điển.");
            System.out.println("\t\t\t--------------------MENU--------------------\n\n");



            System.out.print("\t\t\t\tNhập lựa chọn : ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose){
                case 1:{
                    System.out.print("\t\t\t\t\tNhập từ cần tìm : ");
                    String en = scanner.nextLine();
                    System.out.println("\t\t\t\t\t" + dictionary.binarySearch(en));
                    break;
                }
                case 2:{
                    System.out.print("\t\t\t\t\tNhập từ tiếng anh : ");
                    String en = scanner.nextLine();
                    System.out.print("\t\t\t\t\tNhập từ tiếng Việt : ");
                    String vn = scanner.nextLine();
                    dictionary.addNewWord(en, vn);
                }
                case 3:{
                    FileWriter fw = new FileWriter("dictionary.dat");
                    BufferedWriter bw = new BufferedWriter(fw);

                    List<Word> wordList = dictionary.getWordList();

                    for (Word x : wordList) {
                        bw.write(x.toString());
                        bw.newLine();
                    }

                    bw.close();
                    fw.close();

                    System.out.println("\t\t\t\t\tLưu vào file thành công!");

                }
                default:
                    break;
            }

        }
    }
}