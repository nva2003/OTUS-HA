package ha.otus.simple.social.network.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Permission {

    // ID первичного ключа
    private int id;
    // Имя разрешения
    private String name;

    // Описание разрешения
    private String descritpion;

    // Ссылка для авторизации
    private String url;

    // ID родительского узла
    private int pid;

    // Метод запроса
    private String method;

}
