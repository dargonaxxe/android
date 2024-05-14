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

import io.tonapi.models.JettonTransferAction
import io.tonapi.models.AccountAddress
import io.tonapi.models.EncryptedComment
import io.tonapi.models.JettonPreview
import io.tonapi.models.Refund

class JettonTransferActionTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of JettonTransferAction
        //val modelInstance = JettonTransferAction()

        // to test the property `sendersWallet`
        should("test sendersWallet") {
            // uncomment below to test the property
            //modelInstance.sendersWallet shouldBe ("TODO")
        }

        // to test the property `recipientsWallet`
        should("test recipientsWallet") {
            // uncomment below to test the property
            //modelInstance.recipientsWallet shouldBe ("TODO")
        }

        // to test the property `amount` - amount in quanta of tokens
        should("test amount") {
            // uncomment below to test the property
            //modelInstance.amount shouldBe ("TODO")
        }

        // to test the property `jetton`
        should("test jetton") {
            // uncomment below to test the property
            //modelInstance.jetton shouldBe ("TODO")
        }

        // to test the property `sender`
        should("test sender") {
            // uncomment below to test the property
            //modelInstance.sender shouldBe ("TODO")
        }

        // to test the property `recipient`
        should("test recipient") {
            // uncomment below to test the property
            //modelInstance.recipient shouldBe ("TODO")
        }

        // to test the property `comment`
        should("test comment") {
            // uncomment below to test the property
            //modelInstance.comment shouldBe ("TODO")
        }

        // to test the property `encryptedComment`
        should("test encryptedComment") {
            // uncomment below to test the property
            //modelInstance.encryptedComment shouldBe ("TODO")
        }

        // to test the property `refund`
        should("test refund") {
            // uncomment below to test the property
            //modelInstance.refund shouldBe ("TODO")
        }

    }
}
