
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
            "- [Beef](#beef)\n" +
            "- [Beverage](#beverage)\n" +
            "- [Pork](#pork)\n" +
            "- [Poultry](#poultry)\n" +
            "- [Seafood](#seafood)\n" +
            "- [Treats](#treats)\n" +
            "- [Vegetable](#vegetable)\n" +
            "\n";
    private static String[] types = { "Beef", "Beverage", "Pork", "Poultry", "Seafood", "Treats", "Vegetable"};

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

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

            for (File file : directoryListing) {
                String link = file.getPath();
                pw.println("\n- [" + parseName(file.getName()) + "](" +
                        fixLink(link) + ")");
            }
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