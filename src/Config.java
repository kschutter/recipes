public class Config {

    File readme;
    Scanner sc;
    PrintWriter writer = new PrintWriter("README.md", "UTF-8");

    String toc = "# kschutter Culinary Recipes\n" +
            "\n" +
            "- [Poultry](#poultry)\n" +
            "- [Beef](#beef)\n" +
            "- [Beverage](#beverage)\n\n";
    String[] types = ["Poultry", "Beef", "Beverage"];

    public static void main(String[] args) {

        try {
            readme = new File("README.md");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        writer.println(toc);

        for (String type: types) {
            writer.println("## " + type);

            File dir = new File("r/" + type);
            File[] directoryListing = dir.listFiles();

            for (File child : directoryListing) {
                sc = new Scanner(child);
                String title = sc.nextLine().substring(4);
                writer.println("- " + title);
            }
        }
    }
}