package ha.otus.simple.social.network.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
public class SysUser {

    // ID первичного ключа
    private Long userId;
    @NotNull
    private String userName;
    @NotNull
    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
    private String password;
    @NotNull
    @Size(min=6, max=100, message = "Min size is 6 and max size is 100")
    private String passwordConfirmation;
    private String encrytedPassword;

    /*Имя*/
    @NotNull
//    @Column(value = "first_name")
    private String firstName;
    /*Фамилия*/
    @NotNull
    @Size(min=2, max=100, message = "Min size is 2 and max size is 100")
    private String lastName;
    /*Возраст*/
    private String age;
    /*Пол*/
    @NotNull
    private String sex;
    /*Интересы*/
    @NotNull
    private String interest;
    /*
                Город
    */
    @NotNull
    private String city;
    @NotNull
    private String status;





    private List<SysRole> roles;

    public SysUser() {

    }

    public SysUser(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }


}
