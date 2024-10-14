package example.chap_5.pureObject;

import lombok.Data;

@Data
public class Chap5_Pure_Member {

    private String id;
    private String username;

    private Chap5_Pure_Team team;//팀의 참조를 보관

    public void setTeam(Chap5_Pure_Team team){
        this.team=team;
    }

}
