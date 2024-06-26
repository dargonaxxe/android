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
 * @param address Wallet address
 * @param balanceDeltas Changes in balance
 * @param coins Transaction coins
 * @param exitCode Exit code of operation
 * @param logicalTime Operation logical time
 * @param queryId Id of operation status query
 * @param txHash Operation hash
 */


data class OperationStatus (

    /* Wallet address */
    @Json(name = "address")
    val address: kotlin.String,

    /* Changes in balance */
    @Json(name = "balance_deltas")
    val balanceDeltas: kotlin.String,

    /* Transaction coins */
    @Json(name = "coins")
    val coins: kotlin.String,

    /* Exit code of operation */
    @Json(name = "exit_code")
    val exitCode: kotlin.String,

    /* Operation logical time */
    @Json(name = "logical_time")
    val logicalTime: kotlin.String,

    /* Id of operation status query */
    @Json(name = "query_id")
    val queryId: kotlin.String,

    /* Operation hash */
    @Json(name = "tx_hash")
    val txHash: java.io.File

)

