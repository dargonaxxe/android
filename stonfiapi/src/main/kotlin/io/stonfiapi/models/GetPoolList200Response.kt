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

import io.stonfiapi.models.PoolInfoSchema

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param poolList 
 */


data class GetPoolList200Response (

    @Json(name = "pool_list")
    val poolList: kotlin.collections.List<PoolInfoSchema>

)

