package example.chap_6.ManyToMany.identifying;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Chap6_MTM_MemberProductId_IDEN implements Serializable {
    //jpa에서 복합 키를 사용하려면 별도의 식별자 클래스를 만들어야 한다.
    //해당 클래스가 복합 키를 위한 식별자 클래스로써 사용된다.

    private String member;
    private String product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chap6_MTM_MemberProductId_IDEN that = (Chap6_MTM_MemberProductId_IDEN) o;
        return Objects.equals(member, that.member) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }

    //hashCode and equals 는 자바 IDE에서 자동으로 생성해준다.

}
