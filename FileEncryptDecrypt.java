import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== File Encryption / Decryption =====");
        System.out.print("Enter 'E' for Encryption or 'D' for Decryption: ");
        char choice = sc.next().toUpperCase().charAt(0);
        sc.nextLine();

        System.out.print("Enter the input file path: ");
        String inputFilePath = sc.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFilePath = sc.nextLine();

        System.out.print("Enter the secret key (number): ");
        int key = sc.nextInt();

        if (choice == 'E') {
            encryptFile(inputFilePath, outputFilePath, key);
        } else if (choice == 'D') {
            decryptFile(inputFilePath, outputFilePath, key);
        } else {
            System.out.println("Invalid choice! Please select E or D.");
        }

        sc.close();
    }

    public static void encryptFile(String inputFile, String outputFile, int key) {
        processFile(inputFile, outputFile, key, true);
        System.out.println("\n File encrypted successfully and saved as: " + outputFile);
    }

    public static void decryptFile(String inputFile, String outputFile, int key) {
        processFile(inputFile, outputFile, key, false);
        System.out.println("\n File decrypted successfully and saved as: " + outputFile);
    }

    private static void processFile(String inputFile, String outputFile, int key, boolean isEncrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder processedLine = new StringBuilder();

                for (char ch : line.toCharArray()) {
                    if (isEncrypt) {
                        processedLine.append((char) (ch + key)); 
                    } else {
                        processedLine.append((char) (ch - key)); 
                    }
                }
                writer.write(processedLine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error processing file: " + e.getMessage());
        }
    }
}
