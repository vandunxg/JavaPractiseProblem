import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import static java.lang.System.out;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void exportTitle(){
        out.printf("%-20s%-15s%-15s%-15s%-20s%-30s%-10s","Họ và tên","Ngày sinh","Địa chỉ","Giới tính",
                "Mã sinh viên", "Email", "Điểm tổng kết\n");
    }

    public static <List, Scanner> void main(String[] args) {
        List<Person> listOfStudent = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            out.println("\n\n");
            out.println("|------------------------------MENU------------------------------|");
            out.printf("%-31s","|");
            out.printf("%35s", "|");
            out.println();
            out.printf("%-25s", "|\t1.\tThêm thông tin sinh viên từ console.");
            out.printf("%22s", "|");
            out.println();
            out.printf("%-31s", "|\t2.\tLưu thông tin vào file.");
            out.printf("%32s", "|");
            out.println();
            out.printf("%-31s", "|\t3.\tXóa file.");
            out.printf("%32s", "|");
            out.println();
            out.printf("%-31s", "|\t4.\tXem danh sách sinh viên.");
            out.printf("%32s", "|");
            out.println();
            out.printf("%-31s", "|\t5.\tĐọc dữ liệu từ file.");
            out.printf("%32s", "|");
            out.println();
            out.printf("%-31s","|");
            out.printf("%35s", "|");
            out.println();
            out.println("|----------------------------------------------------------------|");
            out.println("\n");

            out.print("\t Chọn chức năng : ");
            int choose = scanner.nextInt();

            switch (choose){
                case 1 :{
                    out.println();
                    out.print("Nhập thông tin sinh viên :");
                    Person newPerson = new Student();
                    newPerson.getInformation();
                    listOfStudent.add(newPerson);
                    break;
                }
                case 2 :{
                    boolean check = false;
                    for (Person x : listOfStudent) {
                        check = x.writeFile();
                        if(!check)
                           break;
                    }
                    if(check)
                        out.println("\n\tLưu thông tin vào file thành công!\n");
                    else
                        out.println("\n\tLưu thông tin vào file không thành công\n");
                    break;
                }
                case 3 : {
                    try{

                        FileReader reader = new FileReader("saved.dat");
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        FileWriter writer = new FileWriter("backup.dat");
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);

                        String line;

                        while((line = bufferedReader.readLine()) != null){
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                        }

                        out.println("\tĐã xóa file và backup sang file backup.dat!");

                    }
                    catch (Exception e){
                        out.println(e.toString());
                        out.println("\tXóa file không thành công!");
                    }
                }
                case 4 : {
                    exportTitle();
                    for (Person x : listOfStudent) {
                        x.exportData();
                    }
                    break;
                }
                case 5 : {
                    try{
                        FileReader fr = new FileReader("vandunxg.dat");
                        BufferedReader br = new BufferedReader(fr);
                        String text;
                        while((text = br.readLine()) != null){
                            String[] informations = text.split("&");
                            Person newPerson = new Student(informations[0], informations[1], informations[2], informations[3], informations[4], informations[5], informations[6]);
                            listOfStudent.add(newPerson);
                        }
                        br.close();
                        fr.close();
                        out.println("\tĐọc dữ liệu không thành công!");
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                        out.println("Đọc dữ liệu không thành công!");
                    }
                    break;
                }
                default:
                    break;
            }

        }


    }
}
