public class ValidationTest {

    public static void main(String[] args) {
        run("Username", Validation.checkUsername("abc_d"));
        run("Password", Validation.checkPassword("Password1!"));
        run("Cell phone", Validation.checkCellPhone("+27831234567"));
        System.out.println("All Validation tests passed.");
    }

    private static void run(String name, boolean condition) {
        if (!condition) {
            throw new IllegalStateException(name + " test failed");
        }
    }
}