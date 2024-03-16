import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.out;

public class Person {
    private String fullname; // Full name
    private String birthday;
    private String address;
    private String sex;

    Person(){}

    Person(String fullname, String birthday, String address, String sex){
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    public void getInformation(){
        out.println();
        Scanner scanner = new Scanner(System.in);
        out.print("\tNhập họ và tên : ");
        this.fullname = scanner.nextLine();
        out.print("\tNhập ngày sinh : ");
        this.birthday = scanner.nextLine();
        out.print("\tNhập địa chỉ : ");
        this.address = scanner.nextLine();
        out.print("\tNhập giới tính : ");
        this.sex = scanner.nextLine();
    }

    public boolean writeFile(){
        try{
            FileWriter file = new FileWriter("saved.dat", true);
            BufferedWriter writeData = new BufferedWriter(file);

            writeData.write(this.fullname + "&" + this.birthday + "&" +
                    this.address + "&" + this.sex + "&");

            writeData.close();
            file.close();

            return true;

        } catch (Exception e){
            out.println(e.toString());

            return false;
        }
    }

    public void exportData(){
        out.printf("%-20s", this.fullname);
        out.printf("%-15s", this.birthday);
        out.printf("%-15s", this.address);
        out.printf("%-15s", this.sex);
    }

}
