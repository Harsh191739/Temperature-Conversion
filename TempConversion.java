import java.util.Scanner;

public class TempConversion {

    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.println();
        String border = "    ╔══════════════════════════════════════╗" ;
        printWithDelay(border);
        System.out.println();

        printWithDelay("    ║"+YELLOW + "         TEMPERATURE CONVERSION       " + RESET + "║");
        System.out.println();
        

        printWithDelay("    ╚══════════════════════════════════════╝" );
        System.out.println();
        System.out.println();
        System.out.println(YELLOW +"   Enter the temperature and unit "+ GREEN + "(C, F, K)"+ RESET);
        System.out.println();
        System.out.print(RED+"> Temperature: " +GREEN);
        double inputTemperature = scanner.nextDouble();

        System.out.print(RED +"> Unit (C/F/K): " +GREEN);
        char unit = scanner.next().charAt(0);
        System.out.print(RESET);
        double celsius, fahrenheit, kelvin;

        if (unit == 'C' || unit == 'c') {
            celsius = inputTemperature;
            fahrenheit = (celsius * 9 / 5) + 32;
            kelvin = celsius + 273.15;
        } else if (unit == 'F' || unit == 'f') {
            fahrenheit = inputTemperature;
            celsius = (fahrenheit - 32) * 5 / 9;
            kelvin = celsius + 273.15;
        } else if (unit == 'K' || unit == 'k') {
            kelvin = inputTemperature;
            celsius = kelvin - 273.15;
            fahrenheit = (celsius * 9 / 5) + 32;
        } else {
            System.out.println(RED + "Invalid unit! Please use C, F, or K." + RESET);
            return;
        }
        System.out.println();

        System.out.println("    ╔══════════════════════════════════════╗" );
        printCenteredLine(String.format("Input Temperature: "+ inputTemperature +"°"+unit));
        System.out.println("    ╠══════════════════════════════════════╣" );
        printCenteredLine( String.format("Fahrenheit: %.2f°F", fahrenheit));
        printCenteredLine(String.format("Celsius: %.2f°C", celsius) );
        printCenteredLine(String.format("Kelvin: %.2f K", kelvin)  );

        System.out.println("    ╚══════════════════════════════════════╝" );
    }
    public static void printWithDelay(String message) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(5); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void printCenteredLine(String message ) {
        int boxWidth = 38; 
        int messageLength = message.length();
        int padding = (boxWidth - messageLength) / 2 ;
        printWithDelay("    ║");
        if((boxWidth - messageLength)%2!=0){
            System.out.print(" ");
        }

        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(GREEN);
        printWithDelay(message);
        System.out.print(RESET);

        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println("║");
    }
}