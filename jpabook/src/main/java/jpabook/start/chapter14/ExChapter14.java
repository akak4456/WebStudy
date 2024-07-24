package jpabook.start.chapter14;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExChapter14 {
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
        Duck duck = new Duck();
        duck.setName("duck");
        em.persist(duck);
    }

    private static void doTest(EntityManager em) {
        Duck duck = em.find(Duck.class, 1L);
        em.remove(duck);
    }
}
