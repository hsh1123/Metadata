package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

        //OCP DIP 규칙 위반 한 클래스는 역할만 의존성을 가져야하지 구현까지 의존성을 가지면 안됨 현 주석되어있는 코드는 역할과 구현 둘 다 의존하는 코드
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this. memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memeberId, String itemName, int itemPrice) {

        Member member = memberRepository.findbyId(memeberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memeberId, itemName, itemPrice, discountPrice);
    }
}
