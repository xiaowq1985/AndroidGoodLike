package eventbus;

public class JamesEvent {
    public String getMessage() {
        return message;
    }

    private String message;

    public JamesEvent(String message) {
        this.message = message;
    }
}
