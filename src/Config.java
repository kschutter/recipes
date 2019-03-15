
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Config {

    private static File readme;
    private static Scanner sc;


    private static String toc = "# kschutter Culinary Recipes\n" +
            "\n" +
            "- [Beef :cow2:](#beef)\n" +
            "- [Beverage :tropical_drink:](#beverage)\n" +
            "- [Pork :pig2:](#pork)\n" +
            "- [Poultry :chicken:](#poultry)\n" +
            "- [Seafood :fish:](#seafood)\n" +
            "- [Treats :cake:](#treats)\n" +
            "- [Vegetable :herb:](#vegetable)\n" +
            "\n";
    private static String[] types = { "Beef", "Beverage", "Pork", "Poultry", "Seafood", "Treats", "Vegetable"};

    public static void main(String[] args) throws FileNotFoundException, NullPointerException {

        PrintWriter pw = new PrintWriter("README.md");
        pw.println(toc);

        for (String type: types) {
            pw.println("\n## " + type + "\n");

            File dir = new File("r/" + type);
            File[] directoryListing = dir.listFiles();

//            for (int i = 0; i < directoryListing.length; i++) {
//                String link = directoryListing[i].getPath();
//                pw.println("\n- [" + parseName(directoryListing[i].getName()) + "](" +
//                         fixLink(link) + ")");
//            }

            try {
                for (File file : directoryListing) {
                    String link = file.getPath();
                    pw.println("\n- [" + parseName(file.getName()) + "](" +
                            fixLink(link) + ")");
                }
            } catch (NullPointerException e) {}
        }

        pw.close();
    }


    private static String parseName(String name) {
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_')
                chars[i] = ' ';
        }
        return new String(chars).substring(0, chars.length-3);
    }

    private static String fixLink(String link) {
        char[] chars = link.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\\')
                chars[i] = '/';
        }
        return new String(chars);
    }
}