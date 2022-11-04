package br.org.customerservice

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Address(
    @JsonProperty("id") private val id: Long,
    @JsonProperty("street") private val street: String
)
