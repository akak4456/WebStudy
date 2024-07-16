package jpabook.start.chapter9;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PhoneServiceProvider {
    @Id @GeneratedValue
    Long id;
}
