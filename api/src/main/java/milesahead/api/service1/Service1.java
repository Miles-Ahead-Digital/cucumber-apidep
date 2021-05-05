package milesahead.api.service1;

public class Service1 {

    private final long id;
    private final String content;

    public Service1(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Service1() {
        this.id = 0;
        this.content = null;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
