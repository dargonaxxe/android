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

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import io.tonapi.models.GetOutMsgQueueSizes200Response
import io.tonapi.models.GetOutMsgQueueSizes200ResponseShardsInner

class GetOutMsgQueueSizes200ResponseTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of GetOutMsgQueueSizes200Response
        //val modelInstance = GetOutMsgQueueSizes200Response()

        // to test the property `extMsgQueueSizeLimit`
        should("test extMsgQueueSizeLimit") {
            // uncomment below to test the property
            //modelInstance.extMsgQueueSizeLimit shouldBe ("TODO")
        }

        // to test the property `shards`
        should("test shards") {
            // uncomment below to test the property
            //modelInstance.shards shouldBe ("TODO")
        }

    }
}