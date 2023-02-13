//package com.example.AacademyProject.runner;
//
//import com.example.AacademyProject.entity.Customer;
//import com.example.AacademyProject.entity.Email;
//import com.example.AacademyProject.entity.Order;
//import com.example.AacademyProject.entity.Role;
//import com.example.AacademyProject.repository.CustomerRepository;
//import com.example.AacademyProject.repository.EmailRepository;
//import com.example.AacademyProject.repository.OrderRepository;
//import com.example.AacademyProject.repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class CommandRunner implements CommandLineRunner {
//    @Autowired
//    CustomerRepository customerRepository;
//    @Autowired
//    EmailRepository emailRepository;
//    @Autowired
//    OrderRepository orderRepository;
//    @Autowired
//    RoleRepository roleRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        Role adminRole = new Role();
//        adminRole.setRoleName("ADMIN");
//        Role devRole = new Role();
//        devRole.setRoleName("DEVELOPER");
//        Role dbaRole = new Role();
//        dbaRole.setRoleName("DATABASE_ADMIN");
//        List<Role> roles = List.of(adminRole,devRole,dbaRole);
//        List<Role> savedRoles =  roleRepository.saveAll(roles);
//
//        Customer customer = new Customer();
//        customer.setCustomerName("Pesho");
//        customer.setCustomerLastName("Nikolov");
//        Set<Role> rolesForUser= new HashSet<>(savedRoles);
//        customer.setRoles(rolesForUser);
//        Email email = new Email();
//        email.setEmailAddress("example@google.com");
//        Email savedEmail = emailRepository.save(email);
//        customer.setCustomerEmail(savedEmail);
//        Customer savedCustomer = customerRepository.save(customer);
//        System.out.println(customerRepository.findById(1L).get());
//        Order order = new Order();
//        order.setProducts("Potato,Tomato,Onion");
//        order.setCustomer(savedCustomer);
//        orderRepository.save(order);
//    }
//}
