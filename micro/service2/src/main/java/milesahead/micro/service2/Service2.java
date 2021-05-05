package milesahead.micro.service2;

public class Service2 {

     private final long id;
        private final String content;

        public Service2(long id, String content) {
            this.id = id;
            this.content = content;
        }

    public Service2() {
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
