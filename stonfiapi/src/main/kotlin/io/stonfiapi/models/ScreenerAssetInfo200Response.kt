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

import io.stonfiapi.models.AssetInfoScreenerSchema

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param asset 
 */


data class ScreenerAssetInfo200Response (

    @Json(name = "asset")
    val asset: AssetInfoScreenerSchema

)

