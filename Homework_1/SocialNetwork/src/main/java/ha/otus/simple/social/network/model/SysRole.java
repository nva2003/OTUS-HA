package ha.otus.simple.social.network.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SysRole {

    // ID первичного ключа
    private Integer id;
    // Имя роли
    private String name;
}
