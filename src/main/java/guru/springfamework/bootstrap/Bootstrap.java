package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();

    }

    private void loadCustomers() {
        Customer susanTanner = new Customer();
        susanTanner.setFirstname("Susan");
        susanTanner.setLastname("Tanner");

        Customer titoValentino = new Customer();
        titoValentino.setFirstname("Tito");
        titoValentino.setLastname("Valentino");

        customerRepository.save(susanTanner);
        customerRepository.save(titoValentino);
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        fruits.setName("Dried");

        Category fresh = new Category();
        fruits.setName("Fresh");

        Category exotic = new Category();
        fruits.setName("Exotic");

        Category nuts = new Category();
        fruits.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category Data loaded = " + categoryRepository.count());
    }
}
