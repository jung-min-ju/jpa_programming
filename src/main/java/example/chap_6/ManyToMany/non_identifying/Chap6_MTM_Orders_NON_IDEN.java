package example.chap_6.ManyToMany.non_identifying;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Chap6_MTM_Orders_NON_IDEN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본 키를 자동 생성
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Chap6_MTM_Member_NON_IDEN member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Chap6_MTM_PRODUCT_NON_IDEN product;

    private int orderAmount;
}
