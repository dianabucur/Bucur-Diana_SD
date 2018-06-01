package com.mkyong.Repository;

import com.mkyong.Models.Patient;
import com.mkyong.SpringBootWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = SpringBootWebApplication.class)
public class PatientRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void test1(){
        Patient patient = new Patient("Ana Maria", "1254796523", 19, "migraine", 10);
        entityManager.persist(patient);
        entityManager.flush();

        // when
        Patient found = patientRepository.findByName(patient.getName());

        assertThat(found.getName())
                .isEqualTo(patient.getName());
    }
}
