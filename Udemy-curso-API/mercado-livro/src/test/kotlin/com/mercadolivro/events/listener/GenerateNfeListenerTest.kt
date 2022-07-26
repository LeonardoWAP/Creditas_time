package com.mercadolivro.events.listener

import com.mercadolivro.ModelBuilderHelper.buildCustomer
import com.mercadolivro.ModelBuilderHelper.buildPurchase
import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.service.PurchaseService
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*


@ExtendWith(MockKExtension::class)
class GenerateNfeListenerTest{
    @MockK
    private lateinit var purchaseService: PurchaseService

    @InjectMockKs
    private lateinit var generateNfeListener: GenerateNfeListener

    @Test
    fun `should generate nfe`(){
        val purchase = buildPurchase(nfe = null)
        val fakenfe = UUID.randomUUID()
        val purchaseExpected = purchase.copy(nfe = fakenfe.toString())

        mockkStatic(UUID::class)

        every { UUID.randomUUID() }returns fakenfe
        every { purchaseService.update(purchaseExpected) }just runs

        generateNfeListener.listen(PurchaseEvent (this,purchase))

        verify (exactly = 1){purchaseService.update(purchaseExpected)  }
    }
}