package Logging;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.*;


public class JUL {
    public static void main(String args[]) throws SecurityException, IOException{
        Logger logs = Logger.getLogger(JUL.class.getName());
        /*
         Creating a logger requires a name which represents the name of the logger. This string parameter is used to 
         identify the logger and to group the log messages generated by it.


         */

        /*
        Here the default level of severity of root logger is set to INFO which means that all the aboves level of severity of INFO 
        and severity INFO will get logged , rest below its level of severity won't be logged.
        */ 
        
        // Logger.getLogger("").setLevel(Level.FINEST); // Changing the severity level of root logger, by calling the root logger passing ""
        
        // logs.log(Level.SEVERE, "This is a Server log message");
        // logs.log(Level.WARNING, "This is a Warning log message");
        // logs.log(Level.INFO, "This is a log message");
        // logs.log(Level.CONFIG, "This is a config log message");
        // logs.log(Level.FINE, "This is a Fine log message");
        // logs.log(Level.FINER, "This is a Finer log message");
        // logs.log(Level.FINEST, "This is a Finest log message"); 

        // logs.fine("This is a fine log message ");
        System.out.println("Current Level "+logs.getLevel());
        System.out.println();

        ConsoleHandler handler = new ConsoleHandler(); // The consoleHandler which shows output on the console also had default INFO as level of severity 
        handler.setLevel(Level.FINEST);

        Logger.getLogger("").setLevel(Level.FINEST); // Set root logger to output FINE messages
        logs.addHandler(handler);
        // Getting output in console
        logs.finest("This is a finest message.");
        logs.finer("This is a finer message.");
        logs.fine("This is a fine message.");
        logs.config("This is a config message.");
        logs.info("This is an informational message.");
        logs.warning("This is a warning message.");
        logs.severe("This is a severe message.");
        System.out.println("Current Level "+Logger.getLogger("").getLevel());


        // Storing output in a file in simple format
        
        FileHandler fileHandler = new FileHandler("JUL.log");
        fileHandler.setFormatter(new SimpleFormatter());
        logs.addHandler(fileHandler);
        logs.finest("This is a finest message.");
        logs.finer("This is a finer message.");
        logs.fine("This is a fine message.");
        logs.config("This is a config message.");
        logs.info("This is an informational message.");
        logs.warning("This is a warning message.");
        logs.severe("This is a severe message.");

        // Storing output in a file in JSON format which requires external libraries
        
        // try{
        //     JSONFormatter formatter = new JSONFormatter();
        //     FileHandler handler1 = new FileHandler("/var/log/myapp.log");
        //     handler1.setFormatter(formatter);
        //     logs.addHandler(handler1);
        //     logs.finest("This is a finest message.");
        //     logs.finer("This is a finer message.");
        //     logs.fine("This is a fine message.");
        //     logs.config("This is a config message.");
        //     logs.info("This is an informational message.");
        //     logs.warning("This is a warning message.");
        //     logs.severe("This is a severe message.");
        // }
        // catch (IOException e) {
        //     logger.log(Level.SEVERE, "Error creating log file", e);
        //   }
    }
}
