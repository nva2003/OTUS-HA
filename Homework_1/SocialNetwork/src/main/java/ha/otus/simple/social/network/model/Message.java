package ha.otus.simple.social.network.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
    // Заголовок информации
    private String title;
    // Тема информации
    private String content;
    //Дополнительная информация
    private String etraInfo;

    public Message(String title, String content, String etraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
}
