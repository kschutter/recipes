
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
            "\n";
    private static String[] types = { "Beef", "Beverage", "Pork", "Poultry", "Seafood", "Treats"};

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter pw = new PrintWriter("README.md", "UTF-8");
        pw.println(toc);

        for (String type: types) {
            pw.println("\n## " + type + "\n");

            File dir = new File("r/" + type);
            File[] directoryListing = dir.listFiles();

            for (int i = 0; i < directoryListing.length; i++) {
                pw.println("\n- [" + parseName(directoryListing[i].getName()) + "](" +
                        directoryListing[i] + ")");
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
}