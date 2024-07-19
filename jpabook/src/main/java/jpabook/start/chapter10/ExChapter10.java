package jpabook.start.chapter10;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.QueryModifiers;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.Projections;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ExChapter10 {
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
        List<Team> teams = new ArrayList<>();
        for(int i=1;i<=10;i++) {
            Team team = new Team();
            team.setName("team" + i);
            em.persist(team);
            teams.add(team);
        }
        List<Member> members = new ArrayList<Member>();
        for(int i=1;i<=30;i++) {
            Member member = new Member();
            member.setUsername("member"+i);
            member.setAge(i * 3);

            Team target = teams.get((i - 1) % teams.size());
            member.setTeam(target);
            target.getMembers().add(member);
            em.persist(member);
            members.add(member);
        }

        Product product1 = new Product();
        product1.setName("product1");
        product1.setPrice(1000);
        product1.setStockAmount(10);
        em.persist(product1);

        Order order1 = new Order();
        order1.setMember(members.get(0));
        order1.setProduct(product1);
        order1.setOrderAmount(20);
        order1.setAddress(new Address("city1", "street1", "zip1"));
        em.persist(order1);

        Order order2 = new Order();
        order2.setMember(members.get(0));
        order2.setProduct(product1);
        order2.setOrderAmount(30);
        order2.setAddress(new Address("city2", "street2", "zip2"));
        em.persist(order2);
    }

    private static void doTest(EntityManager em) {
        JPAQuery query = new JPAQuery(em);
        QProduct product = QProduct.product;
        List<Product> products = query.from(product).where(product.name.eq("product1")).list(product);
        Product p = products.get(0);
        em.setFlushMode(FlushModeType.COMMIT);
        p.setPrice(2000);
        Product product2 =
                em.createQuery("select p from Product p where p.price = 2000", Product.class)
                        .setFlushMode(FlushModeType.AUTO)
                                .getSingleResult();
        System.out.println(product2.getName() + ":" + product2.getPrice());
    }
}
