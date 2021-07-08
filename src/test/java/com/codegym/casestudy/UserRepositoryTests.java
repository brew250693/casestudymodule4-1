//package com.codegym.casestudy;
//
//import com.codegym.casestudy.entity.Users;
//import com.codegym.casestudy.repository.IUserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private IUserRepository repository;
//
//    @Test
//    public void testCreateUser() {
//        Users user = new Users();
//        user.setEmail("ravikumar@gmail.com");
//        user.setPassword("ravi2020");
//        user.setFirstName("Ravi");
//        user.setLastName("Kumar");
//
//        Users savedUser = repository.save(user);
//        Users existUser = entityManager.find(Users.class, savedUser.getId());
//
//        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//    }
//
//    @Test
//    public void testFindByEmail() {
//        String email = "nam@codejava.net";
//        Users user = repository.findByEmail(email);
//
//        assertThat(user.getEmail()).isEqualTo(email);
//    }
//}
