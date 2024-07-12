package jpabook.start.chapter5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    @OneToMany
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        this.members.add(member);
        member.setTeam(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team() {

    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
