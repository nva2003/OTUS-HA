package ha.otus.simple.social.network.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Friendship {
    /*
    * BIGINT
    * */
    @NonNull
    private  Long user_id;
    /*
     * BIGINT
     * */
    @NonNull
    private Long friend_id;
    /*
    * мало ли..
    * */
    private boolean accepted;

}
