public class MessageTest {

    public static void main(String[] args) {

        MessageTest test = new MessageTest();

        test.testMessageLength();
        test.testRecipientValidation();
        test.testMessageHash();

    }

    // Test 1: Message length validation
    public void testMessageLength() {

        Message msg = new Message("", "+2783123456", "Hello this is a test message", 1);

        if (msg.checkMessageLength()) {
            System.out.println("PASS: Message length valid");
        } else {
            System.out.println("FAIL: Message length test failed");
        }
    }

    // Test 2: Recipient validation
    public void testRecipientValidation() {

        Message msg = new Message("", "+2783123456", "Test", 1);

        if (msg.checkRecipientCell()) {
            System.out.println("PASS: Recipient format valid");
        } else {
            System.out.println("FAIL: Recipient format invalid");
        }
    }

    // Test 3: Message hash check
    public void testMessageHash() {

        Message msg = new Message("", "+2783123456", "Hi Mike tonight", 1);

        String hash = msg.createMessageHash();

        if (hash != null && hash.contains(":")) {
            System.out.println("PASS: Hash generated correctly");
        } else {
            System.out.println("FAIL: Hash test failed");
        }
    }
}