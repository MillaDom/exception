package ru.netology.javaqa.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Product(101, "Один дома", 600);
    Product product2 = new Product(112, "HONORpro", 60_000);
    Product product3 = new Product(123, "Redmi6", 6000);
    Product product4 = new Product(134, "Один в поле не воин", 300);
    Product product5 = new Product(145, "Программирование на JAVA", 1000);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void shouldAddAll() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.addAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextJustOne() {

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("поле");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {

        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("Один");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void couldNotSearchByText() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("нет");

        assertArrayEquals(expected, actual);
    }

}