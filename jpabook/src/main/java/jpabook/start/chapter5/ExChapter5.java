package jpabook.start.chapter5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ExChapter5 {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        //엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {


            tx.begin(); //트랜잭션 시작
            testSaveNonOwner(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close();
    }
    
    private static void testSaveNonOwner(EntityManager em) {
        Member member1 = new Member("member1", "회원1");
        em.persist(member1);
        
        Member member2 = new Member("member2", "회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀1");
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(team1);
    }

    private static void save(EntityManager em) {
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        Member member2 = new Member("member2","회원2");
        member2.setTeam(team1);
        em.persist(member2);

        team1.addMember(member1);
        team1.addMember(member2);
    }

    private static void findMember(EntityManager em) {
        Member member = em.find(Member.class, "member1");
        Team team = member.getTeam();
        System.out.println("팀 이름 = " + team.getName());
    }

    private static void queryLogicJoin(EntityManager em) {
        String jpql = "select m from Member m join m.team t where t.name=:teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for(Member member : resultList) {
            System.out.println("[query] member.username = " + member.getUsername());
        }
    }

    private static void updateRelation(EntityManager em) {
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    private static void deleteRelation(EntityManager em) {
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);
    }

    private static void deleteTeam(EntityManager em) {
        Team team = em.find(Team.class, "team1");
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);
        Member member2 = em.find(Member.class, "member2");
        member2.setTeam(null);
        em.remove(team);
    }

    private static void biDirection(EntityManager em) {
        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();
        System.out.println("team is " + team.getName());
        System.out.println(members.size());

        for(Member member : members) {
            System.out.println("member.username = " + member.getUsername());
        }
    }
}
