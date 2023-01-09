import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    Product product1 = new Product(101, "Один дома", 600);
    Product product2 = new Product(112, "HONORpro", 60_000);
    Product product3 = new Product(123, "Redmi6", 6000);
    Product product4 = new Product(134, "Один в поле не воин", 300);
    Product product5 = new Product(145, "Программирование на JAVA", 1000);

    @Test
    public void shouldSaveAll() {
        ProductRepository repository = new ProductRepository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.removeById(product2.getId());

        Product[] expected = {product1, product3, product4, product5};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}