public class Config {

    File readme;
    Scanner sc;

    public static void main(Strings arg[]) {

        try {
            readme = new File("README.md");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}