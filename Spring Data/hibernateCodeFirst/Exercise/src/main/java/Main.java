import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        /*
        Creating Entity Manager to perform the transaction upon the data base
         */
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("hcf")
                .createEntityManager();

//        entityManager.getTransaction().begin();
//
//        Sale sale = new Sale();
//        sale.setLocalDateTime(LocalDateTime.now());
//        Product product = new Product();
//
//        product.setName("Test");
//        product.setPrice(BigDecimal.TEN);
//        product.setQuantity(5);
//        product.getSales().add(sale);
//        sale.setProduct(product);
//
//        entityManager.persist(product);
//        Product found = entityManager
//                .find(Product.class, 3L);
//        entityManager.remove(found);
//
//        entityManager.getTransaction().commit();
    }
}
