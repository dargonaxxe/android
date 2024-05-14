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

import io.tonapi.models.BlockchainBlock

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param lastKnownBlockId 
 * @param lastKnownBlock 
 */


data class BlockchainBlockShardsShardsInner (

    @Json(name = "last_known_block_id")
    val lastKnownBlockId: kotlin.String,

    @Json(name = "last_known_block")
    val lastKnownBlock: BlockchainBlock

)

