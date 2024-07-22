package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() {
        // Given
        Book item = new Book();
        item.setName("book1");
        item.setPrice(1000);
        item.setStockQuantity(10);
        item.setAuthor("author1");
        item.setIsbn("isbn1");

        // When
        itemRepository.save(item);

        // Then
        assertEquals(item.getId(), itemRepository.findOne(item.getId()).getId());
    }
}