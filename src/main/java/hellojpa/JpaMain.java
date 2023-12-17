package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // 연결 db당 하나만 생성
        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("hello");
        // 커넥션 받아오기
        EntityManager em =emf.createEntityManager();
        EntityTransaction tx  =em.getTransaction();
        tx.begin();
//////////////////////////////////////////

        Team team = new Team();
        team.setName("TeamA");
        em.persist(team);

        Member member = new Member();
        member.setName("member1");
        member.setTeam(team);
        em.persist(member);


        Member findMember = em.find(Member.class,member.getId());

        Team findMemberTeam = findMember.getTeam();

        System.out.println("findMemberTeam = " + findMemberTeam);



        Team newTeam=em.find(Team.class , 100L);

        findMember.setTeam(newTeam);

///////////////////////////////////////
        tx.commit();
        em.close();
        emf.close();
    }

}
