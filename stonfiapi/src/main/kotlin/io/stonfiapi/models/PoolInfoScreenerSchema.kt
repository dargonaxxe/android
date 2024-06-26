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

package io.stonfiapi.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param asset0Id First asset in pair address
 * @param asset1Id First asset in pair address
 * @param id Liquidity pool address
 * @param createdAtBlockNumber Pool creation block number
 * @param createdAtBlockTimestamp Pool creation block number
 * @param createdAtTxnId Pool creation transaction id
 * @param feeBps Protocol fee in base points
 */


data class PoolInfoScreenerSchema (

    /* First asset in pair address */
    @Json(name = "asset0Id")
    val asset0Id: kotlin.String,

    /* First asset in pair address */
    @Json(name = "asset1Id")
    val asset1Id: kotlin.String,

    /* Liquidity pool address */
    @Json(name = "id")
    val id: kotlin.String,

    /* Pool creation block number */
    @Json(name = "createdAtBlockNumber")
    val createdAtBlockNumber: kotlin.Int? = null,

    /* Pool creation block number */
    @Json(name = "createdAtBlockTimestamp")
    val createdAtBlockTimestamp: kotlin.Long? = null,

    /* Pool creation transaction id */
    @Json(name = "createdAtTxnId")
    val createdAtTxnId: kotlin.String? = null,

    /* Protocol fee in base points */
    @Json(name = "feeBps")
    val feeBps: kotlin.Int? = null

)

