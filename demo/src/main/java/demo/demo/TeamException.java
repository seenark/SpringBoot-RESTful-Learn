package demo.demo;

public class TeamException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public TeamException() {}
    
    public TeamException(String id) {
        super("In DB has no Object id: " + id);

    }

}
