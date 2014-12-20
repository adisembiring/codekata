import com.learnkata.kata01.BuyXForYPriceDiscount;
import com.learnkata.kata01.Checkout;
import com.learnkata.kata01.Product;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Adi on 12/20/2014.
 */
public class TestPrice {

    private Checkout co;

    @Test
    public void test_total() {
        assertEquals(0, price(""), 0);
        assertEquals( 50, price("A"), 0);
        assertEquals(80, price("AB"), 0);
        assertEquals(115, price("CDBA"), 0);

        assertEquals(100, price("AA"), 0);
        assertEquals(130, price("AAA"), 0);
        assertEquals(180, price("AAAA"), 0);
        assertEquals(230, price("AAAAA"), 0);
        assertEquals(260, price("AAAAAA"), 0);

        assertEquals(160, price("AAAB"), 0);
        assertEquals(175, price("AAABB"), 0);
        assertEquals(190, price("AAABBD"), 0);
        assertEquals(190, price("DABABA"), 0);
    }

    @Test
    public void test_incremental() {
        init();
        co.scan("A");  assertEquals(50, co.getTotal(), 0);
        co.scan("B");  assertEquals(80, co.getTotal(), 0);
        co.scan("A");  assertEquals(130, co.getTotal(), 0);
        co.scan("A");  assertEquals(160, co.getTotal(), 0);
        co.scan("B");  assertEquals(175, co.getTotal(), 0);
    }

    public float price(String items) {
        init();
        Arrays.asList(items.split("(?!^)")).forEach(item -> co.scan(item));
        return co.getTotal();
    }

    private void init() {
        Product a = new Product(1, "A", 50);
        Product b = new Product(2, "B", 30);
        Product c = new Product(3, "C", 20);
        Product d = new Product(4, "D", 15);
        co = new Checkout(Arrays.asList(a, b, c, d));
        co.addDiscountPolicy(new BuyXForYPriceDiscount(1, "Product A, 3 For 130", a, 3, 130f));
        co.addDiscountPolicy(new BuyXForYPriceDiscount(2, "Product B, 2 For 45", b, 2, 45f));
    }
}
