package Engine;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;


    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please enter exercise number:");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());
            switch (exNum) {
                case 2 -> exTwo();
                case 3 -> exThree();
                case 4 -> exFour();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exFour() {
       entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :min_salary", Employee.class)
               .setParameter("min_salary", BigDecimal.valueOf(50000L))
               .getResultStream()
               .map(Employee::getFirstName)
               .forEach(System.out::println);
    }

    private void exThree() throws IOException {
        System.out.println("Please enter Employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];
        Long singleResult = entityManager.createQuery
                        ("SELECT count(e) FROM Employee e WHERE " +
                        "e.firstName = :f_name AND e.lastName = :l_name",
                        Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();
        System.out.println(singleResult == 0
        ? "No names found!" : String.format("Yes %s employee found!", singleResult) );

    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = upper(t.name) WHERE LENGTH(t.name) >= 5");

        System.out.println(query.executeUpdate());
        entityManager.getTransaction().commit();
    }
}
