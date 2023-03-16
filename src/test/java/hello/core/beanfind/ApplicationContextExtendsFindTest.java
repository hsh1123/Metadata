package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 2 이상 보유 시, 오류 발생")
    void findBeanByParentTypeDuplicate(){
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 2 이상 보유 시, 이름 지정")
    void findBeanByParentType(){
        DiscountPolicy fixDiscountPolicy = ac.getBean("FixDiscountPolicy",DiscountPolicy.class);
        Assertions.assertThat(fixDiscountPolicy).isInstanceOf(FixDiscountPolicy.class);

        DiscountPolicy rateDiscountPolicy = ac.getBean("RateDiscountPolicy", DiscountPolicy.class);
        Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);

    }

    @Test
    @DisplayName("특정 하위 타입으로 지정")
    void findBeanBySubType() {
        FixDiscountPolicy bean = ac.getBean(FixDiscountPolicy.class);
        Assertions.assertThat(bean).isInstanceOf(FixDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key+ " value = " + beansOfType.get(key)) ;
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByParentTypeObject() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key+ " value = " + beansOfType.get(key)) ;
        }
    }




   @Configuration
   static class TestConfig{

       @Bean
       public DiscountPolicy FixDiscountPolicy(){
           return new FixDiscountPolicy();
       }

       @Bean
       public DiscountPolicy RateDiscountPolicy() {
           return new RateDiscountPolicy();
       }
   }
}
