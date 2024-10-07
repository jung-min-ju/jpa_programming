package example.chap_6.ManyToMany.identifying;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@IdClass(Chap6_MTM_MemberProductId_IDEN.class)
@Data
public class Chap6_MTM_MemberProduct_IDEN {

    //기본키를 매핑하는 @Id와 외래 키를 매핑하는 @JoinColum을 동시에 사용해서 기본키 + 외래키를 한 번에 매핑했다.
    //또한 @IdClass를 사용해서 복합 기본키를 매핑했다.

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Chap6_MTM_Member_IDEN member;
    //MemberProductId.member와 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Chap6_MTM_PRODUCT_IDEN product;
    //MemberProductId.product와 연결

    private int orderAmount;
}
