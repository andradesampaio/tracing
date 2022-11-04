package br.org.apiservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AddressClient(
    private val restTemplate: RestTemplate,
    @param:Value("\${addressClient.baseUrl}") private val baseUrl: String
) {
    fun getAddressForCustomerId(id: Long): Address? {
        return restTemplate.getForObject(
            String.format("%s/addresses/%d", baseUrl, id),
            Address::class.java
        )
    }
}
