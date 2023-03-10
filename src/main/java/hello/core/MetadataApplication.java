package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class MetadataApplication {

    public static void main(String[] args) {

        // join
//        MemberService memberService = new MemberServiceImpl();
//        Member member = new Member(1L,"memberA", Grade.VIP);
//        memberService.join(member);
//
//        Member findMember = memberService.findMember(1L);
//        System.out.println("new Member = "+ member.getId());
//        System.out.println("fine Member = "+ findMember.getId());

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);



    }

}
