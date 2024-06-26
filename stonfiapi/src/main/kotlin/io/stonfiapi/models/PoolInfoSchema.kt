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
 * @param address Address of pool
 * @param collectedToken0ProtocolFee Protocol fee collected in token0
 * @param collectedToken1ProtocolFee Protocol fee collected in token1
 * @param deprecated Pool is deprecated
 * @param lpFee Fee of liquidity pool token
 * @param lpTotalSupply Total supply of liquidity pool tokens
 * @param protocolFee Fee of protocol
 * @param protocolFeeAddress Address of protocol fee
 * @param refFee Referral fee
 * @param reserve0 Reserve of token0 in pool
 * @param reserve1 Reserve of token1 in pool
 * @param routerAddress Address of router
 * @param token0Address Address of token0
 * @param token1Address Address of token1
 * @param apy1d Annual percentage yield on the last day
 * @param apy30d Annual percentage yield on the last month
 * @param apy7d Annual percentage yield on the last week
 * @param lpAccountAddress Account address of liquidity pool tokens
 * @param lpBalance Balance of liquidity pool tokens
 * @param lpPriceUsd Price of liquidity pool token in USD
 * @param lpTotalSupplyUsd Total supply of liquidity pool tokens in USD
 * @param lpWalletAddress Wallet address of liquidity pool tokens
 * @param token0Balance Balance of token0
 * @param token1Balance Balance of token1
 */


data class PoolInfoSchema (

    /* Address of pool */
    @Json(name = "address")
    val address: kotlin.String,

    /* Protocol fee collected in token0 */
    @Json(name = "collected_token0_protocol_fee")
    val collectedToken0ProtocolFee: kotlin.String,

    /* Protocol fee collected in token1 */
    @Json(name = "collected_token1_protocol_fee")
    val collectedToken1ProtocolFee: kotlin.String,

    /* Pool is deprecated */
    @Json(name = "deprecated")
    val deprecated: kotlin.Boolean,

    /* Fee of liquidity pool token */
    @Json(name = "lp_fee")
    val lpFee: kotlin.String,

    /* Total supply of liquidity pool tokens */
    @Json(name = "lp_total_supply")
    val lpTotalSupply: kotlin.String,

    /* Fee of protocol */
    @Json(name = "protocol_fee")
    val protocolFee: kotlin.String,

    /* Address of protocol fee */
    @Json(name = "protocol_fee_address")
    val protocolFeeAddress: kotlin.String,

    /* Referral fee */
    @Json(name = "ref_fee")
    val refFee: kotlin.String,

    /* Reserve of token0 in pool */
    @Json(name = "reserve0")
    val reserve0: kotlin.String,

    /* Reserve of token1 in pool */
    @Json(name = "reserve1")
    val reserve1: kotlin.String,

    /* Address of router */
    @Json(name = "router_address")
    val routerAddress: kotlin.String,

    /* Address of token0 */
    @Json(name = "token0_address")
    val token0Address: kotlin.String,

    /* Address of token1 */
    @Json(name = "token1_address")
    val token1Address: kotlin.String,

    /* Annual percentage yield on the last day */
    @Json(name = "apy_1d")
    val apy1d: kotlin.String? = null,

    /* Annual percentage yield on the last month */
    @Json(name = "apy_30d")
    val apy30d: kotlin.String? = null,

    /* Annual percentage yield on the last week */
    @Json(name = "apy_7d")
    val apy7d: kotlin.String? = null,

    /* Account address of liquidity pool tokens */
    @Json(name = "lp_account_address")
    val lpAccountAddress: kotlin.String? = null,

    /* Balance of liquidity pool tokens */
    @Json(name = "lp_balance")
    val lpBalance: kotlin.String? = null,

    /* Price of liquidity pool token in USD */
    @Json(name = "lp_price_usd")
    val lpPriceUsd: kotlin.String? = null,

    /* Total supply of liquidity pool tokens in USD */
    @Json(name = "lp_total_supply_usd")
    val lpTotalSupplyUsd: kotlin.String? = null,

    /* Wallet address of liquidity pool tokens */
    @Json(name = "lp_wallet_address")
    val lpWalletAddress: kotlin.String? = null,

    /* Balance of token0 */
    @Json(name = "token0_balance")
    val token0Balance: kotlin.String? = null,

    /* Balance of token1 */
    @Json(name = "token1_balance")
    val token1Balance: kotlin.String? = null

)

