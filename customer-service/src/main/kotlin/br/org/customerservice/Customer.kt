package br.org.customerservice

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(
    @JsonProperty("id") private val id: Long,
    @JsonProperty("name") private val name: String
)
