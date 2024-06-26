/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package io.tonapi.apis

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import io.tonapi.apis.DNSApi
import io.tonapi.models.Auctions
import io.tonapi.models.DnsRecord
import io.tonapi.models.DomainBids
import io.tonapi.models.DomainInfo
import io.tonapi.models.StatusDefaultResponse

class DNSApiTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of DNSApi
        //val apiInstance = DNSApi()

        // to test dnsResolve
        should("test dnsResolve") {
            // uncomment below to test dnsResolve
            //val domainName : kotlin.String = wallet.ton // kotlin.String | domain name with .ton or .t.me
            //val result : DnsRecord = apiInstance.dnsResolve(domainName)
            //result shouldBe ("TODO")
        }

        // to test getAllAuctions
        should("test getAllAuctions") {
            // uncomment below to test getAllAuctions
            //val tld : kotlin.String = ton // kotlin.String | domain filter for current auctions \"ton\" or \"t.me\"
            //val result : Auctions = apiInstance.getAllAuctions(tld)
            //result shouldBe ("TODO")
        }

        // to test getDnsInfo
        should("test getDnsInfo") {
            // uncomment below to test getDnsInfo
            //val domainName : kotlin.String = wallet.ton // kotlin.String | domain name with .ton or .t.me
            //val result : DomainInfo = apiInstance.getDnsInfo(domainName)
            //result shouldBe ("TODO")
        }

        // to test getDomainBids
        should("test getDomainBids") {
            // uncomment below to test getDomainBids
            //val domainName : kotlin.String = wallet.ton // kotlin.String | domain name with .ton or .t.me
            //val result : DomainBids = apiInstance.getDomainBids(domainName)
            //result shouldBe ("TODO")
        }

    }
}
