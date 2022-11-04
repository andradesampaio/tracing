package br.org.customerservice

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Controller {
    private val logger = LoggerFactory.getLogger(Controller::class.java)

    @GetMapping("customers/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCustomer(@PathVariable("id") customerId: Long): ResponseEntity<Customer> {
        logger.info("GETTING CUSTOMER WITH ID {}", customerId)
        if (customerId < 0 || customerId > NAMES.size - 1) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        var customer = Customer(customerId, NAMES[customerId.toInt()])
        return ResponseEntity.ok(customer)
    }

    @GetMapping("addresses/{id}")
    @Throws(InterruptedException::class)
    fun getAddress(@PathVariable("id") customerId: Long): ResponseEntity<Address> {
        logger.info("GETTING ADDRESS FOR CUSTOMER WITH ID {}", customerId)
        if (customerId < 0 || customerId > NAMES.size - 1) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(Address(customerId, STREETS[customerId.toInt()]), HttpStatus.OK)
    }

    companion object {
        private val STREETS: List<String> = Arrays.asList(
            "Jefferson Street",
            "Cambridge Road",
            "Olive Street",
            "Old York Road",
            "Aspen Drive",
            "Cherry Lane",
            "10th Street",
            "Pennsylvania Avenue",
            "Central Avenue",
            "8th Street West",
            "Route 11",
            "Street Road",
            "Prospect Street",
            "Devon Road",
            "Forest Avenue",
            "Elm Avenue",
            "Heather Court",
            "Route 202",
            "Willow Drive",
            "Evergreen Lane",
            "Windsor Drive",
            "Mulberry Street",
            "2nd Street North",
            "Sheffield Drive",
            "Ashley Court",
            "Valley Road",
            "Spruce Street",
            "Wood Street",
            "Bridge Street",
            "Monroe Drive",
            "Church Road",
            "Main Street South",
            "Adams Avenue",
            "Delaware Avenue",
            "Somerset Drive",
            "9th Street",
            "3rd Street East",
            "Augusta Drive",
            "Wall Street",
            "Broad Street",
            "Route 2",
            "Fairview Avenue",
            "5th Avenue",
            "Spruce Avenue",
            "Cemetery Road",
            "River Street",
            "Tanglewood Drive",
            "Cedar Street",
            "Canal Street",
            "Market Street"
        )
        private val NAMES: List<String> = Arrays.asList(
            "Daria Domino",
            "Yukiko Yawn",
            "Diane Dalessio",
            "Elijah Elmore",
            "Tyron Thaler",
            "Stefani Stayton",
            "Shara Stam",
            "Earlean Eblin",
            "Jonell Janecek",
            "Thaddeus Tupper",
            "Dorthy Delany",
            "Shanel Saffell",
            "Ricki Rost",
            "Kandy Knecht",
            "Mirella Ma",
            "Rocky Ros",
            "Theo Tosi",
            "Marnie Manzer",
            "Talisha Trottier",
            "Thanh Tamez",
            "Hyacinth Hotard",
            "Dianne Dearman",
            "Marc Medlin",
            "Roxane Rossin",
            "Mellie Marino",
            "Eugene Eng",
            "Charis Curnutt",
            "Lillia Leming",
            "Gretta Gately",
            "Jessica Johnsen",
            "Raven Riera",
            "Roni Rost",
            "Garth Gipson",
            "Demetrice Dell",
            "Eugenie Ead",
            "Jared Julio",
            "Alaina Aguinald ",
            "Hortense Haun",
            "Willia Woodland",
            "Jessenia Jefferis",
            "Jinny June",
            "William Whang",
            "Dessie Down",
            "Katelyn Koren",
            "Barbara Bazaldua",
            "France Frese",
            "Eufemia Evangelista",
            "Neva Nock",
            "Rickey Redd",
            "Norma Nagler"
        )
    }
}
