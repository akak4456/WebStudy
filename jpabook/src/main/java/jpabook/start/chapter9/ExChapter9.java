package jpabook.start.chapter9;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ExChapter9 {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        //엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            save(em);
            tx.commit();//트랜잭션 커밋
            em.clear();
            tx.begin();
            doTest(em);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close();
    }
    private static void save(EntityManager em) {
        PhoneServiceProvider provider = new PhoneServiceProvider();
        em.persist(provider);
        Period period = new Period();
        period.setStartDate(new Date());
        period.setEndDate(new Date());

        Zipcode zipcode = new Zipcode();
        zipcode.setZip("zip1");
        zipcode.setPlusFour("plus four");
        Address address1 = new Address();
        address1.setCity("city1");
        address1.setStreet("street1");
        address1.setZipcode("zip1");

        Address address2 = new Address();
        address2.setCity("city2");
        address2.setStreet("street2");
        address2.setZipcode("zip2");

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setAreaCode("areaCode1");
        phoneNumber.setLocalNumber("localNumber1");
        phoneNumber.setProvider(provider);

        Member member = new Member();
        member.setName("member1");
        member.setWorkPeriod(period);
        member.setHomeAddress(address1);
        member.getFavoriteFoods().add("짬뽕");
        member.getFavoriteFoods().add("짜장");
        member.getFavoriteFoods().add("탕수육");

        member.getAddressHistory().add(new Address("서울","강남","123-123"));
        member.getAddressHistory().add(new Address("서울","강북","000-000"));
        member.setPhoneNumber(phoneNumber);

        em.persist(member);
    }
    private static void doTest(EntityManager em) {
        Member member = em.find(Member.class, 2L);

        member.setHomeAddress(new Address("새로운도시", "신도시1", "123456"));

        Set<String> favoriteFoods = member.getFavoriteFoods();
        favoriteFoods.remove("탕수육");
        favoriteFoods.add("치킨");

        List<Address> addressHistory = member.getAddressHistory();
        addressHistory.remove(new Address("서울","강남","123-123"));
        addressHistory.add(new Address("새로운도시", "새로운주소", "123-456"));
    }
}
