import entities.Address;
import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.print("Select exercise number: ");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());
            switch (exNum) {
                case 2 -> Exercise02();
                case 3 -> Exercise03();
                case 4 -> Exercise04();
                case 5 -> Exercise05();
                case 6 -> Exercise06();
                case 7 -> Exercise07();
                case 10 -> Exercise10();
                case 12 -> Exercise12();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void Exercise12() {
        List<Object[]> rows = entityManager
                .createNativeQuery("SELECT d.name, MAX(e.salary) AS `m_salary` FROM departments d\n" +
                        "join employees e on d.department_id = e.department_id\n" +
                        "group by d.name\n" +
                        "HAVING `m_salary` NOT BETWEEN 30000 AND 70000;")
                .getResultList();
    }

    private void Exercise10() {
        entityManager.getTransaction().begin();
       int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                "SET e.salary = e.salary * 1.2 " +
                        "WHERE e.department.id IN :ids")
               .setParameter("ids", Set.of(1, 2, 4, 11))
               .executeUpdate();

       entityManager.getTransaction().commit();
       System.out.println(affectedRows);


    }

    private void Exercise07() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                //Limiting the results of the query above
                .setMaxResults(10)
                .getResultList();

            addresses
                    .forEach(address -> {
                        System.out.printf("%s, %s - %d employees%n",
                                address.getText(),
                                address.getTown() == null
                                ? "Unknown Town!" : address.getTown().getName(),
                                address.getEmployees().size());
                    });
    }

    private void Exercise06() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();
        System.out.println("Please enter your new address:");
        Address address = createAddress(bufferedReader.readLine());

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private void Exercise05() {
        entityManager
                .createQuery("SELECT e from  Employee e " +
                        "WHERE e.department.name = :d_name " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void Exercise04() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void Exercise03() throws IOException {
        System.out.println("Enter employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager
                .createQuery("SELECT count(e) FROM Employee e "
                + "WHERE e.firstName = :f_name AND e.lastName = :l_name"
                , Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();
        System.out.printf(singleResult == 0 ? "No employees found!" : "Yes!\n-- %s %s",firstName, lastName);
    }

    private void Exercise02() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name = upper(t.name) " +
                "WHERE length(t.name) >= 5 ");
        System.out.println(query.executeUpdate());
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }
}
