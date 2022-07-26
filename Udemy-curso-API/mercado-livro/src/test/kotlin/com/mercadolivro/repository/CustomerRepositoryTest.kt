package com.mercadolivro.repository

import com.mercadolivro.ModelBuilderHelper.buildCustomer
import io.mockk.junit5.MockKExtension
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
//@ActiveProfiles("teste")
@ExtendWith(MockKExtension::class)
class CustomerRepositoryTest {

    @Autowired
    private lateinit var customerRepository :CustomerRepository

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @Test
    fun `should return name containing`(){
        val marcos = customerRepository.save(buildCustomer(name = "Marcos"))
        val matheus = customerRepository.save(buildCustomer(name = "Matheus"))
        customerRepository.save(buildCustomer(name="Alex"))
        val customers =customerRepository.findByNameContaining("Ma")

        assertEquals(listOf(marcos,matheus),customers)
    }

    @Nested
    inner class `  exists by emai `{
        @Test
        fun ` should return true when email exists `(){
            val email = "email@teste.com"
            customerRepository.save(buildCustomer(email = email))
            val exists = customerRepository.existsByEmail(email)
            assertTrue(exists)
        }

        @Test
        fun ` should return false when email not exists `(){
            val email = "noneexistingemail@teste"

            val exists = customerRepository.existsByEmail(email)

            assertFalse(exists)
        }
    }


    @Nested
    inner class `  find by emai `{
        @Test
        fun ` should return customer when email exists `(){
            val email = "email@teste.com"
            val customer = customerRepository.save(buildCustomer(email = email))
            val result = customerRepository.findByEmail(email)
            assertNotNull(result)
            assertEquals(customer,result)
        }

        @Test
        fun ` should return null when email not exists `(){
            val email = "noneexistingemail@teste"

            val result = customerRepository.findByEmail(email)

            assertNull(result)
        }
    }
}