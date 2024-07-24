package jpabook.start.chapter14;

import javax.persistence.*;

public class DuckListener {
    @PrePersist
    public void prePersist(Object o) {
        System.out.println("Duck.prePersist id = " + ((Duck)o).getId());
    }

    @PostPersist
    public void postPersist(Object o) {
        System.out.println("Duck.postPersist id = " + ((Duck)o).getId());
    }

    @PostLoad
    public void postLoad(Object o) {
        System.out.println("Duck.postLoad");
    }

    @PreRemove
    public void preRemove(Object o) {
        System.out.println("Duck.preRemove");
    }

    @PostRemove
    public void postRemove(Object o) {
        System.out.println("Duck.postRemove");
    }
}
