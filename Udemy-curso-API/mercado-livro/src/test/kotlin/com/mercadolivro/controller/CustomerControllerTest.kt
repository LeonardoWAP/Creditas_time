package com.mercadolivro.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.mercadolivro.ModelBuilderHelper.buildCustomer
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.repository.CustomerRepository
import com.mercadolivro.security.UserCustomDetails
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.awt.PageAttributes.MediaType
import kotlin.random.Random


@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
@WithMockUser
class CustomerControllerTest{

    @Autowired
    private lateinit var mockMvc : MockMvc

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var objectMapper : ObjectMapper

    @BeforeEach
    fun setup() = customerRepository.deleteAll()

    @AfterEach
    fun tearDown() = customerRepository.deleteAll()

    @Test
    fun ` should return all customers `(){
        val customer1 = customerRepository.save(buildCustomer())
        val customer2 = customerRepository.save(buildCustomer())
        mockMvc.perform(get("/customers"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].id").value(customer1.id))
            .andExpect(jsonPath("$[0].name").value(customer1.name))
            .andExpect(jsonPath("$[0].email").value(customer1.email))
            .andExpect(jsonPath("$[0].status").value(customer1.status.name))
    }

    @Test
    fun ` should filter all customers by name when get all `(){
        val customer1 = customerRepository.save(buildCustomer(name = "Gustavo"))
        val customer2 = customerRepository.save(buildCustomer(name = "Daniel"))
        mockMvc.perform(get("/customers?name=Gus"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].id").value(customer1.id))
            .andExpect(jsonPath("$[0].name").value(customer1.name))
            .andExpect(jsonPath("$[0].email").value(customer1.email))
            .andExpect(jsonPath("$[0].status").value(customer1.status.name))
    }

    @Test
    fun ` should create customer ` (){
        val request = PostCustomerRequest("fake name", "${Random.nextInt()}@fakeemail.com","123456")
        mockMvc.perform(post("/customers")
            .contentType(org.springframework.http.MediaType
            .APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated)

        val customers = customerRepository.findAll().toList()
        assertEquals(1,customers.size)
        assertEquals(request.name,customers[0].name)
        assertEquals(request.email,customers[0].email)
    }
    @Test
    fun ` should throw error when create customer has invalid information `(){
        val request = PostCustomerRequest("", "${Random.nextInt()}@fakeemail.com","123456")
        mockMvc.perform(post("/customers")
                .contentType(org.springframework.http.MediaType
                .APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isUnprocessableEntity)

            .andExpect(jsonPath("$.httpCode").value(422))
            .andExpect(jsonPath("$.message").value("Invalid Request"))
            .andExpect(jsonPath("$.internalCode").value("ML-001"))
    }

    @Test
    fun ` should get user by id when user has the same id `(){
        val customer = customerRepository.save(buildCustomer())

        mockMvc.perform(get("/customers/${customer.id}").with(user(UserCustomDetails(customer))))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(customer.id))
            .andExpect(jsonPath("$.name").value(customer.name))
            .andExpect(jsonPath("$.email").value(customer.email))
            .andExpect(jsonPath("$.status").value(customer.status.name))
    }

    @Test
    fun ` should return forbidden when user has different id `(){
        val customer = customerRepository.save(buildCustomer())
            val response = mockMvc.perform(get("/customers/0").with(user(UserCustomDetails(customer))))
                .andExpect(status().isForbidden)
                .andExpect(jsonPath("$.httpCode").value(403))
                .andExpect(jsonPath("$.message").value("Unauthorized"))
                .andExpect(jsonPath("$.internalCode").value("ML-000"))
    }

    @Test
    @WithMockUser(roles = ["ROLE_ADMIN"])
    fun ` should get user by id when user is admin `(){
        val customer = customerRepository.save(buildCustomer())

        mockMvc.perform(get("/customers/${customer.id}"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(customer.id))
            .andExpect(jsonPath("$.name").value(customer.name))
            .andExpect(jsonPath("$.email").value(customer.email))
            .andExpect(jsonPath("$.status").value(customer.status.name))
    }

    @Test
    fun ` should update customer `(){
        val customer = customerRepository.save(buildCustomer())
        val request = PutCustomerRequest("Gustavo" ,"emailupdate@email.com" )

        mockMvc.perform(put("/customers/${customer.id}")
                .contentType(org.springframework.http.MediaType
                .APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isNoContent)

        val customers = customerRepository.findAll().toList()
        assertEquals(1,customers.size)
        assertEquals(request.name,customers[0].name)
        assertEquals(request.email,customers[0].email)
    }

    @Test
    fun ` should throw error when update customer has invalid information `(){
        val request = PutCustomerRequest("", "${Random.nextInt()}@fakeemail.com")
        mockMvc.perform(put("/customers/1")
            .contentType(org.springframework.http.MediaType
                .APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isUnprocessableEntity)

            .andExpect(jsonPath("$.httpCode").value(422))
            .andExpect(jsonPath("$.message").value("Invalid Request"))
            .andExpect(jsonPath("$.internalCode").value("ML-001"))
    }

    @Test
    fun ` should delete customer ` (){
        val customer = customerRepository.save(buildCustomer())
        mockMvc.perform(delete("/customers/${customer.id}"))
            .andExpect(status().isNoContent)

        val customerdeleted = customerRepository.findById(customer.id!!)
        assertEquals(CustomerStatus.INATIVO, customerdeleted.get().status)
    }

    @Test
    fun ` should not return not found when delete customer not exists `(){
        mockMvc.perform(delete("/customer/1"))
            .andExpect(status().isNotFound)
            .andExpect(jsonPath("$.httpCode").value(404))
            .andExpect(jsonPath("$.message").value("Customer [1] not exists"))
            .andExpect(jsonPath("$.internalCode").value("ML-201"))
    }

    @Test
    fun ` should return not found when update customer not existing `(){
        val request = PutCustomerRequest("Gustavo" ,"emailupdate@email.com" )

        mockMvc.perform(put("/customers/1")
            .contentType(org.springframework.http.MediaType
                .APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isUnprocessableEntity)
            .andExpect(status().isNotFound)
            .andExpect(jsonPath("$.httpCode").value(404))
            .andExpect(jsonPath("$.message").value("Customer [1] not exists"))
            .andExpect(jsonPath("$.internalCode").value("ML-201"))

    }

}