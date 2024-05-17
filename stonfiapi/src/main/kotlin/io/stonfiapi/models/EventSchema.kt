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

import io.stonfiapi.models.BlockSchema
import io.stonfiapi.models.EventType
import io.stonfiapi.models.Reserves

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param amount0 
 * @param amount1 
 * @param eventIndex 
 * @param maker 
 * @param pairId 
 * @param txnId 
 * @param txnIndex 
 * @param eventType 
 * @param priceNative 
 * @param block 
 * @param reserves 
 * @param amount0In 
 * @param amount0Out 
 * @param amount1In 
 * @param amount1Out 
 */


data class EventSchema (

    @Json(name = "amount0")
    override val amount0: kotlin.String,

    @Json(name = "amount1")
    override val amount1: kotlin.String,

    @Json(name = "eventIndex")
    override val eventIndex: kotlin.Long,

    @Json(name = "maker")
    override val maker: kotlin.String,

    @Json(name = "pairId")
    override val pairId: kotlin.String,

    @Json(name = "txnId")
    override val txnId: kotlin.String,

    @Json(name = "txnIndex")
    override val txnIndex: kotlin.Long,

    @Json(name = "eventType")
    override val eventType: EventSchema.EventType,

    @Json(name = "priceNative")
    override val priceNative: kotlin.String,

    @Json(name = "block")
    val block: BlockSchema,

    @Json(name = "reserves")
    override val reserves: Reserves? = null,

    @Json(name = "amount0In")
    override val amount0In: kotlin.String? = null,

    @Json(name = "amount0Out")
    override val amount0Out: kotlin.String? = null,

    @Json(name = "amount1In")
    override val amount1In: kotlin.String? = null,

    @Json(name = "amount1Out")
    override val amount1Out: kotlin.String? = null

) : EventType

