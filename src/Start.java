import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        File file = new File("src/calledfile.txt");

        if(file.exists()){
            System.out.println("The file already exists, do you want to overwrite it?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(!input.equals("yes")){
                System.out.println("Operation cancelled");
                return;
            }
        }else {
            try {
                file.createNewFile();
                System.out.println("The file " + file.getName() + " has been created");
            } catch (Exception e){
                System.out.println("Unable to create file");
                e.printStackTrace();
                return;
            }
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        try(FileWriter writer = new FileWriter(file)) {
            writer.write(formattedDate);
            System.out.println("Date written correctly in the file");
        }catch (Exception e){
            System.out.println("Unable to write to file");
            e.printStackTrace();
            return;
        }
    }
}
