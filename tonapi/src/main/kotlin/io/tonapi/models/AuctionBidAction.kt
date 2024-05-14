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

package io.tonapi.models

import io.tonapi.models.AccountAddress
import io.tonapi.models.NftItem
import io.tonapi.models.Price

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param auctionType 
 * @param amount 
 * @param bidder 
 * @param auction 
 * @param nft 
 */


data class AuctionBidAction (

    @Json(name = "auction_type")
    val auctionType: AuctionBidAction.AuctionType,

    @Json(name = "amount")
    val amount: Price,

    @Json(name = "bidder")
    val bidder: AccountAddress,

    @Json(name = "auction")
    val auction: AccountAddress,

    @Json(name = "nft")
    val nft: NftItem? = null

) {

    /**
     * 
     *
     * Values: DNSPeriodTon,DNSPeriodTg,NUMBERPeriodTg,getgems
     */
    @JsonClass(generateAdapter = false)
    enum class AuctionType(val value: kotlin.String) {
        @Json(name = "DNS.ton") DNSPeriodTon("DNS.ton"),
        @Json(name = "DNS.tg") DNSPeriodTg("DNS.tg"),
        @Json(name = "NUMBER.tg") NUMBERPeriodTg("NUMBER.tg"),
        @Json(name = "getgems") getgems("getgems");
    }
}

