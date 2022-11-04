package br.org.apiservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller @Autowired constructor(customerClient: CustomerClient, addressClient: AddressClient) {
    private val customerClient: CustomerClient
    private val addressClient: AddressClient
    private val logger: Logger = LoggerFactory.getLogger(Controller::class.java)

    init {
        this.customerClient = customerClient
        this.addressClient = addressClient
    }

    @GetMapping(path = ["customers/{id}"])
    fun getCustomerWithAddress(@PathVariable("id") customerId: Long): CustomerAndAddress {
        logger.info("COLLECTING CUSTOMER AND ADDRESS WITH ID {} FROM UPSTREAM SERVICE", customerId)
        val customer: Customer = customerClient.getCustomer(customerId)
        val address = addressClient.getAddressForCustomerId(customerId)
        return CustomerAndAddress(customer, address!!)
    }
}
