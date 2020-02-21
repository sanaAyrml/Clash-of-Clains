package map;

import java.io.Serializable;

public class Message implements Serializable{
    String Id = new String();
    String text = new String();

    public Message(String Id, String text){
        this.Id = Id;
        this.text = text;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return Id;
    }

    public String getText() {
        return text;
    }
}
