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

package io.stonfiapi.apis

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import io.stonfiapi.apis.DexApi
import io.stonfiapi.models.DexReverseSimulateSwap200Response
import io.stonfiapi.models.DexSwapStatus200Response
import io.stonfiapi.models.GetAssetList200Response
import io.stonfiapi.models.GetFarmList200Response
import io.stonfiapi.models.GetMarketList200Response
import io.stonfiapi.models.GetPoolList200Response

class DexApiTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of DexApi
        //val apiInstance = DexApi()

        // to test dexReverseSimulateSwap
        should("test dexReverseSimulateSwap") {
            // uncomment below to test dexReverseSimulateSwap
            //val offerAddress : kotlin.String = EQBynBO23ywHy_CgarY9NK9FTz0yDsG82PtcbSTQgGoXwiuA // kotlin.String | The address of the token we want to sell
            //val askAddress : kotlin.String = EQCM3B12QK1e4yZSf8GtBRT0aLMNyEsBc_DhVfRRtOEffLez // kotlin.String | The address of the token we want to buy
            //val units : kotlin.String = 300 // kotlin.String | Number of token units we want to sell
            //val slippageTolerance : kotlin.String = 0.001 // kotlin.String | The maximum possible difference between the rates that we expect and which will actually be, in fractions (for example, 0.001 is 0.1%)
            //val referralAddress : kotlin.String = referralAddress_example // kotlin.String | Referral address
            //val result : DexReverseSimulateSwap200Response = apiInstance.dexReverseSimulateSwap(offerAddress, askAddress, units, slippageTolerance, referralAddress)
            //result shouldBe ("TODO")
        }

        // to test dexSimulateSwap
        should("test dexSimulateSwap") {
            // uncomment below to test dexSimulateSwap
            //val offerAddress : kotlin.String = EQBynBO23ywHy_CgarY9NK9FTz0yDsG82PtcbSTQgGoXwiuA // kotlin.String | The address of the token we want to sell
            //val askAddress : kotlin.String = EQCM3B12QK1e4yZSf8GtBRT0aLMNyEsBc_DhVfRRtOEffLez // kotlin.String | The address of the token we want to buy
            //val units : kotlin.String = 300 // kotlin.String | Number of token units we want to sell
            //val slippageTolerance : kotlin.String = 0.001 // kotlin.String | The maximum possible difference between the rates that we expect and which will actually be, in fractions (for example, 0.001 is 0.1%)
            //val referralAddress : kotlin.String = referralAddress_example // kotlin.String | Referral address
            //val result : DexReverseSimulateSwap200Response = apiInstance.dexSimulateSwap(offerAddress, askAddress, units, slippageTolerance, referralAddress)
            //result shouldBe ("TODO")
        }

        // to test dexSwapStatus
        should("test dexSwapStatus") {
            // uncomment below to test dexSwapStatus
            //val routerAddress : kotlin.String = EQB3ncyBUTjZUA5EnFKR5_EnOMI9V1tTEAAPaiU71gc4TiUt // kotlin.String | Address of the operation router
            //val ownerAddress : kotlin.String = EQCM3B12QK1e4yZSf8GtBRT0aLMNyEsBc_DhVfRRtOEffLez // kotlin.String | Owner`s wallet address
            //val queryId : kotlin.String = 1 // kotlin.String | Id of operation status query
            //val result : DexSwapStatus200Response = apiInstance.dexSwapStatus(routerAddress, ownerAddress, queryId)
            //result shouldBe ("TODO")
        }

        // to test getAssetList
        should("test getAssetList") {
            // uncomment below to test getAssetList
            //val result : GetAssetList200Response = apiInstance.getAssetList()
            //result shouldBe ("TODO")
        }

        // to test getFarmList
        should("test getFarmList") {
            // uncomment below to test getFarmList
            //val result : GetFarmList200Response = apiInstance.getFarmList()
            //result shouldBe ("TODO")
        }

        // to test getMarketList
        should("test getMarketList") {
            // uncomment below to test getMarketList
            //val result : GetMarketList200Response = apiInstance.getMarketList()
            //result shouldBe ("TODO")
        }

        // to test getPoolList
        should("test getPoolList") {
            // uncomment below to test getPoolList
            //val result : GetPoolList200Response = apiInstance.getPoolList()
            //result shouldBe ("TODO")
        }

    }
}
