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
 * @param trades 
 * @param tvl 
 * @param uniqueWallets 
 * @param volumeUsd 
 */


data class DexStats (

    @Json(name = "trades")
    val trades: kotlin.Long,

    @Json(name = "tvl")
    val tvl: kotlin.String,

    @Json(name = "unique_wallets")
    val uniqueWallets: kotlin.Long,

    @Json(name = "volume_usd")
    val volumeUsd: kotlin.String

)

