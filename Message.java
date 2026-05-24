public class Message {

    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private int messageNumber;

    public Message(String messageID, String recipient, String messageText, int messageNumber) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = messageNumber;
    }

    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    public boolean checkRecipientCell() {
        return recipient.startsWith("+") && recipient.length() <= 13;
    }

    public String generateMessageID() {
        return String.valueOf((long)(Math.random() * 1000000000L));
    }

    public String createMessageHash() {
        String idPart = "00";
        if (messageID != null) {
            if (messageID.length() >= 2) {
                idPart = messageID.substring(0, 2);
            } else if (messageID.length() == 1) {
                idPart = "0" + messageID;
            }
        }

        String firstWord = "";
        String lastWord = "";
        if (messageText != null && !messageText.isBlank()) {
            String[] words = messageText.trim().split("\\s+");
            firstWord = words[0].toUpperCase();
            lastWord = words[words.length - 1].toUpperCase();
        }

        return idPart
                + ":" + messageNumber
                + ":" + firstWord + lastWord;
    }

}