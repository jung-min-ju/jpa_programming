package example.chap_6.ManyToMany;

import example.chap_6.OneToOne.Chap6_OTO_Locker;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Chap6_MTM_Member {

    @Id
    @Column(name="member_id")
    private String id;

    private String username;

//    @ManyToMany
//    @JoinTable(name = "Chap6_MEMBER_PRODUCT",
//               joinColumns = @JoinColumn(name = "member_id"),
//               inverseJoinColumns = @JoinColumn(name="product_id"))
//    private List<Chap6_MTM_PRODUCT> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Chap6_MTM_MemberProduct> memberProducts = new ArrayList<>();

//    public void addProducts(Chap6_MTM_PRODUCT product){
//        //products.add(product);
//        product.getMembers().add(this);
//    }

    //중간엔티티 미사용 -> 주석해제
    // ----------------------------------
    //중간엔티티 사용 -> 주석처리


}
