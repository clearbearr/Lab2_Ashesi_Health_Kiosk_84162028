import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Ashesi Health Kiosk!");

        //Task1
        System.out.print("Enter service code (P/L/T/C): ");
        char serviceCode = input.next().toUpperCase().charAt(0);

        String service = "";
        switch (serviceCode) {
            case 'P': service = "PHARMACY"; System.out.println("Go to: Pharmacy Desk"); break;
            case 'L': service = "LAB"; System.out.println("Go to: Lab Desk"); break;
            case 'T': service = "TRIAGE"; System.out.println("Go to: Triage Desk"); break;
            case 'C': service = "COUNSELING"; System.out.println("Go to: Counseling Desk"); break;
            default: System.out.println("Invalid service code"); return;
        }

        //Task2
        double metric = 0; 
        double roundedMetric = 0;
        double bmi = 0;

        if (service.equals("TRIAGE")) {
            System.out.println("Choose a health metric: 1=BMI, 2=Dosage round-up, 3=Trig helper");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter weight(kg): ");
                double weight = input.nextDouble();
                System.out.print("Enter height(m): ");
                double height = input.nextDouble();

                bmi = weight / Math.pow(height, 2);
                double bmiRounded = Math.round(bmi * 10) / 10.0;
                roundedMetric = Math.round(bmi); 
                metric = bmirounded;

                String category;
                if (bmi < 18.5) category = "Underweight";
                else if (bmi <= 24.9) category = "Normal";
                else if (bmi <= 29.9) category = "Overweight";
                else category = "Obese";

                System.out.println("BMI: " + bmirounded + " Category: " + category);

            } else if (choice == 2) {
                System.out.print("Enter dosage mg: ");
                double dosage = input.nextDouble();
                int tablets = (int) Math.ceil(dosage / 250);
                metric = tablets;
                roundedMetric = tablets;
                System.out.println("Tablets needed: " + tablets);

            } else if (choice == 3) {
                System.out.print("Enter angle in degrees: ");
                double degrees = input.nextDouble();
                double radians = Math.toRadians(degrees);

                double sinVal = Math.round(Math.sin(radians) * 1000) / 1000.0;
                double cosVal = Math.round(Math.cos(radians) * 1000) / 1000.0;

                metric = sinVal; 
                roundedMetric = Math.round(sinVal * 100);
                System.out.println("sin: " + sinVal + " cos: " + cosVal);
            }
        }

        //Task3
        char randomChar = (char) ('A' + rand.nextInt(26));
        String id = "" + randomChar;
        for (int i = 0; i < 4; i++) {
            int digit = rand.nextInt(7) + 3; 
            id += digit;
        }

        System.out.println("Generated ID: " + id);

        if (id.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(id.charAt(1)) &&
                     Character.isDigit(id.charAt(2)) &&
                     Character.isDigit(id.charAt(3)) &&
                     Character.isDigit(id.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID OK");
        }

        //Task4
        System.out.print("Enter your first name: ");
        String firstName = input.next();

        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (base - 'A' + 2) % 26);
        String lastTwo = id.substring(3);

        String displayCode = shifted + lastTwo + "-" + (int) roundedMetric;
        System.out.println("Display Code: " + displayCode);

        //Task5
        if (service.equals("TRIAGE")) {
            System.out.println("Summary: " + service + "ID=" + id + "BMI=" + metric + "Code=" + displayCode);
        } else {
            System.out.println("Summary: " + service + "ID=" + id + "Code=" + displayCode);
        }

        input.close();
    }
}
