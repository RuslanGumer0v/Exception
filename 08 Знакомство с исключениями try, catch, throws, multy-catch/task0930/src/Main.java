import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Логирование состояний и ошибок в работе программы.
 * Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 * Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 */

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            example();
        } catch (Exception e) {
            logger.log(Level.INFO, "Info");
            logger.log(Level.WARNING, "Warning");
        }
    }

    public static void example() throws Exception {
        int a = Integer.parseInt("qwe");
    }
}