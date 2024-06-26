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

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import io.stonfiapi.models.FarmInfoSchema
import io.stonfiapi.models.FarmNftInfoSchema

class FarmInfoSchemaTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of FarmInfoSchema
        //val modelInstance = FarmInfoSchema()

        // to test the property `minStakeDurationS` - Minimal stake duration seconds
        should("test minStakeDurationS") {
            // uncomment below to test the property
            //modelInstance.minStakeDurationS shouldBe ("TODO")
        }

        // to test the property `minterAddress` - Address of the farm
        should("test minterAddress") {
            // uncomment below to test the property
            //modelInstance.minterAddress shouldBe ("TODO")
        }

        // to test the property `nftInfos` - Farm NFT list
        should("test nftInfos") {
            // uncomment below to test the property
            //modelInstance.nftInfos shouldBe ("TODO")
        }

        // to test the property `poolAddress` - Address of the pool
        should("test poolAddress") {
            // uncomment below to test the property
            //modelInstance.poolAddress shouldBe ("TODO")
        }

        // to test the property `rewardTokenAddress` - Address of the reward token
        should("test rewardTokenAddress") {
            // uncomment below to test the property
            //modelInstance.rewardTokenAddress shouldBe ("TODO")
        }

        // to test the property `status` - Minter status
        should("test status") {
            // uncomment below to test the property
            //modelInstance.status shouldBe ("TODO")
        }

        // to test the property `apy` - Annual percentage yield
        should("test apy") {
            // uncomment below to test the property
            //modelInstance.apy shouldBe ("TODO")
        }

    }
}
