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
 * @param asset0Address Address of asset0
 * @param asset0Amount Amount of asset0
 * @param asset0Delta Delta of asset0
 * @param asset0Reserve Reserve of asset0
 * @param asset1Address Address of asset1
 * @param asset1Amount Amount of asset1
 * @param asset1Delta Delta of asset1
 * @param asset1Reserve Reserve of asset1
 * @param destinationWalletAddress Address of destination wallet
 * @param exitCode Operation exit code
 * @param lpFeeAmount Liquidity pool fee amount
 * @param lpTokenDelta Liquidity pool token amount change
 * @param lpTokenSupply Liquidity pool token amount supply
 * @param operationType Type of operation
 * @param poolAddress Address of the pool
 * @param poolTxHash Transaction hash
 * @param poolTxLt Transaction logical time
 * @param poolTxTimestamp Transaction timestamp
 * @param protocolFeeAmount Protocol fee amount
 * @param referralFeeAmount Referral fee amount
 * @param routerAddress Address of the router
 * @param success Operation is successful
 * @param walletAddress Wallet address
 * @param walletTxHash Transaction hash
 * @param walletTxLt Transaction logical time
 * @param walletTxTimestamp Transaction timestamp
 * @param feeAssetAddress Liquidity pool fee asset address
 * @param referralAddress Referral fee address
 */


data class OperationStat (

    /* Address of asset0 */
    @Json(name = "asset0_address")
    val asset0Address: kotlin.String,

    /* Amount of asset0 */
    @Json(name = "asset0_amount")
    val asset0Amount: kotlin.String,

    /* Delta of asset0 */
    @Json(name = "asset0_delta")
    val asset0Delta: kotlin.String,

    /* Reserve of asset0 */
    @Json(name = "asset0_reserve")
    val asset0Reserve: kotlin.String,

    /* Address of asset1 */
    @Json(name = "asset1_address")
    val asset1Address: kotlin.String,

    /* Amount of asset1 */
    @Json(name = "asset1_amount")
    val asset1Amount: kotlin.String,

    /* Delta of asset1 */
    @Json(name = "asset1_delta")
    val asset1Delta: kotlin.String,

    /* Reserve of asset1 */
    @Json(name = "asset1_reserve")
    val asset1Reserve: kotlin.String,

    /* Address of destination wallet */
    @Json(name = "destination_wallet_address")
    val destinationWalletAddress: kotlin.String,

    /* Operation exit code */
    @Json(name = "exit_code")
    val exitCode: kotlin.String,

    /* Liquidity pool fee amount */
    @Json(name = "lp_fee_amount")
    val lpFeeAmount: kotlin.String,

    /* Liquidity pool token amount change */
    @Json(name = "lp_token_delta")
    val lpTokenDelta: kotlin.String,

    /* Liquidity pool token amount supply */
    @Json(name = "lp_token_supply")
    val lpTokenSupply: kotlin.String,

    /* Type of operation */
    @Json(name = "operation_type")
    val operationType: kotlin.String,

    /* Address of the pool */
    @Json(name = "pool_address")
    val poolAddress: kotlin.String,

    /* Transaction hash */
    @Json(name = "pool_tx_hash")
    val poolTxHash: kotlin.String,

    /* Transaction logical time */
    @Json(name = "pool_tx_lt")
    val poolTxLt: kotlin.Long,

    /* Transaction timestamp */
    @Json(name = "pool_tx_timestamp")
    val poolTxTimestamp: kotlin.String,

    /* Protocol fee amount */
    @Json(name = "protocol_fee_amount")
    val protocolFeeAmount: kotlin.String,

    /* Referral fee amount */
    @Json(name = "referral_fee_amount")
    val referralFeeAmount: kotlin.String,

    /* Address of the router */
    @Json(name = "router_address")
    val routerAddress: kotlin.String,

    /* Operation is successful */
    @Json(name = "success")
    val success: kotlin.Boolean,

    /* Wallet address */
    @Json(name = "wallet_address")
    val walletAddress: kotlin.String,

    /* Transaction hash */
    @Json(name = "wallet_tx_hash")
    val walletTxHash: kotlin.String,

    /* Transaction logical time */
    @Json(name = "wallet_tx_lt")
    val walletTxLt: kotlin.String,

    /* Transaction timestamp */
    @Json(name = "wallet_tx_timestamp")
    val walletTxTimestamp: kotlin.String,

    /* Liquidity pool fee asset address */
    @Json(name = "fee_asset_address")
    val feeAssetAddress: kotlin.String? = null,

    /* Referral fee address */
    @Json(name = "referral_address")
    val referralAddress: kotlin.String? = null

)

