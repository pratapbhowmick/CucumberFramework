package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConsoleOutputCapture {
	public static void captureConsoleOutput() {
        try {
            File logFile = new File("logs/eclipse_console.log");
            FileOutputStream fileOutputStream = new FileOutputStream(logFile, true); // Append mode

            PrintStream filePrintStream = new PrintStream(fileOutputStream);
            PrintStream consolePrintStream = System.out;  

            // Create MultiOutputStream that writes to both console and file
            MultiOutputStream multiOutputStream = new MultiOutputStream(consolePrintStream, filePrintStream);

            // Create PrintStream from MultiOutputStream
            PrintStream multiPrintStream = new PrintStream(multiOutputStream);

            // Redirect System.out and System.err
            System.setOut(multiPrintStream);  
            System.setErr(multiPrintStream);  // Capture errors too

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
