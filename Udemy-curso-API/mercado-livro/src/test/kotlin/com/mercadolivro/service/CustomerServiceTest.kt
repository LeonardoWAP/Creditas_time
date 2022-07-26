package com.mercadolivro.service

import com.mercadolivro.ModelBuilderHelper.buildCustomer
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.enums.Role
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*
import kotlin.collections.RandomAccess

@ExtendWith(MockKExtension::class)
internal class CustomerServiceTest{

    @MockK
    private lateinit var customerRepository: CustomerRepository

    @MockK
    private lateinit var bookService: BookService

    @MockK
    private lateinit var bCrypt : BCryptPasswordEncoder

    @InjectMockKs
    @SpyK
    private lateinit var customerService: CustomerService

    @Test
    fun `should return all customers`(){
        val fakeCustomer = listOf(buildCustomer(),buildCustomer())

        every{ customerRepository.findAll() } returns fakeCustomer
        val customers = customerService.getAll(null)


        assertEquals(fakeCustomer , customers)
        verify(exactly = 1 ){customerRepository.findAll()}
        verify(exactly = 0) { customerRepository.findByNameContaining(any()) }
    }

    @Test
    fun `should return all customers when name is informed`(){
        val name = Math.random().toString()
        val fakeCustomer = listOf(buildCustomer(),buildCustomer())

        every{ customerRepository.findByNameContaining(name) } returns fakeCustomer
        val customers = customerService.getAll(name)


        assertEquals(fakeCustomer , customers)
        verify(exactly = 0){customerRepository.findAll()}
        verify(exactly = 1) { customerRepository.findByNameContaining(name) }
    }

    @Test
    fun `should create customer and encrypt password `(){
        val initialPassword = Math.random().toString()
        val fakeCustomer = buildCustomer(password = initialPassword)
        val fakePassword = UUID.randomUUID().toString()
        val fakeCustomerEncrypted = fakeCustomer.copy(password = fakePassword)

        every { customerRepository.save((fakeCustomerEncrypted)) } returns fakeCustomer
        every { bCrypt.encode(initialPassword) }returns fakePassword

        customerService.create(fakeCustomer)
        verify (exactly = 1){ customerRepository.save(fakeCustomerEncrypted) }
        verify (exactly = 1){ bCrypt.encode(initialPassword)  }

    }

    @Test
    fun `should return customer by id`(){
        val id = Random().nextInt()
        val fakecustomer = buildCustomer(id = id)

        every { customerRepository.findById(id) }returns Optional.of(fakecustomer)

        val customer = customerService.findByid(id)

        assertEquals(fakecustomer,customer)
        verify(exactly = 1){customerRepository.findById(id)}
    }
    @Test
    fun `should throw not found when find by id`(){
        val id = Random().nextInt()


        every { customerRepository.findById(id) }returns Optional.empty()

        val error = assertThrows<NotFoundException>{customerService.findByid(id)}

        assertEquals("Customer [${id}] not exists", error.message)
        assertEquals("ML-201",  error.errorCode)
        verify(exactly = 1){customerRepository.findById(id)}
    }

    @Test
    fun `should update customer`(){
        val id = Random().nextInt()
        val fakeCustomer = buildCustomer(id = id)

        every { customerRepository.existsById(id) } returns true
        every { customerRepository.save(fakeCustomer) } returns fakeCustomer


        customerService.update(fakeCustomer)
        verify(exactly = 1){customerRepository.existsById(id)}
        verify(exactly = 1){customerRepository.save(fakeCustomer)}
    }

    @Test
    fun `should throw not found exception when update customer`(){
        val id = Random().nextInt()
        val fakeCustomer = buildCustomer(id = id)

        every { customerRepository.existsById(id) } returns false
        every { customerRepository.save(fakeCustomer) } returns fakeCustomer

        val error = assertThrows<NotFoundException>{
            customerService.update(fakeCustomer)
        }

        assertEquals("Customer [${id}] not exists", error.message)
        assertEquals("ML-201",  error.errorCode)


        verify(exactly = 1){customerRepository.existsById(id)}
        verify(exactly = 0){customerRepository.save(any())}
    }

    @Test
    fun `should delete customer`(){
        val id = Random().nextInt()
        val fakeCustomer = buildCustomer(id = id)
        val expectedCustomer = fakeCustomer.copy(status=CustomerStatus.INATIVO)

        every { customerService.findByid(id) } returns fakeCustomer
        every {customerRepository.save(expectedCustomer)  } returns expectedCustomer
        every { bookService.deleteByCustomer(fakeCustomer)} just runs

        customerService.delete(id)
        verify (exactly = 1){customerService.findByid(id) }
        verify(exactly = 1){bookService.deleteByCustomer(fakeCustomer)}
        verify (exactly = 1){ customerRepository.save(expectedCustomer)}
    }

    @Test
    fun `should throw not found exception when delete customer`(){
        val id = Random().nextInt()

        every { customerService.findByid(id) } throws NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code)

        val error = assertThrows<NotFoundException>{
            customerService.delete(id)
        }

        assertEquals("Customer [${id}] not exists", error.message)
        assertEquals("ML-201",  error.errorCode)

        verify (exactly = 1){customerService.findByid(id) }
        verify(exactly = 0){bookService.deleteByCustomer(any())}
        verify (exactly = 0){ customerRepository.save(any())}
    }

    @Test
    fun `should return true when email available`(){
        val email = "${Random().nextInt().toString()}@email.com"
        every { customerRepository.existsByEmail(email) }returns false
        val emailAvailable = customerService.emailAvailable(email)
        assertTrue(emailAvailable)
        verify (exactly = 1){customerRepository.existsByEmail(email)}
    }

    @Test
    fun `should return false when email unavailable`(){
        val email = "${Random().nextInt().toString()}@email.com"
        every { customerRepository.existsByEmail(email) }returns true
        val emailAvailable = customerService.emailAvailable(email)
        assertFalse(emailAvailable)
        verify (exactly = 1){customerRepository.existsByEmail(email)}
    }



}