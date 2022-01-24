import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1;

    @BeforeEach
    void setUp() {
    p1 = new Product("Name", "Desc", "000001", 5.99);
    }
}