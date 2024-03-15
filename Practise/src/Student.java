import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.out;

public class Student extends Person{
    private String ID;
    private String email;
    private double totalPoint;

    Student(){}

    Student(String fullname, String birthday, String address, String sex, String ID, String email, String totalPoint) {
        super(fullname, birthday, address, sex);
        this.ID = ID;
        this.email = email;
        this.totalPoint = Double.parseDouble(totalPoint);
    }

    public void getInformation() {
        Scanner scanner = new Scanner(System.in);
        super.getInformation();
        out.print("\tNhập ID : ");
        this.ID = scanner.nextLine();
        out.print("\tNhập email : ");
        this.email = scanner.nextLine();
        out.print("\tNhập điểm tổng kết : ");
        this.totalPoint = Double.parseDouble(scanner.nextLine());

    }

    public boolean writeFile(){
        boolean check = super.writeFile();
        try{
            FileWriter file = new FileWriter("saved.dat", true);
            BufferedWriter writeData = new BufferedWriter(file);

            writeData.write(this.ID + "&" + this.email + "&" +
                    this.totalPoint);
            writeData.newLine();

            writeData.close();
            file.close();

            return check;

        } catch (Exception e){
            out.println(e.toString());
            return false;
        }
    }
    public void exportData(){
        super.exportData();
        out.printf("%-20s", this.ID);
        out.printf("%-30s", this.email);
        out.printf("%-10s", this.totalPoint);
        out.println();
    }

}
