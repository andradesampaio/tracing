package br.org.apiservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.RestTemplate

@Component
class CustomerClient(
    private val restTemplate: RestTemplate,
    @param:Value("\${addressClient.baseUrl}") private val baseUrl: String
) {

    private val logger: Logger = LoggerFactory.getLogger(CustomerClient::class.java)
    fun getCustomer(@PathVariable("id") id: Long): Customer {
        val url = String.format("%s/customers/%d", baseUrl, id)
        return restTemplate.getForObject(url, Customer::class.java)!!
    }
}
