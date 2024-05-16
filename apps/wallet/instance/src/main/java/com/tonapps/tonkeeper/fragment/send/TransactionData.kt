package com.tonapps.tonkeeper.fragment.send

import android.net.Uri
import com.tonapps.blockchain.Coin
import com.tonapps.extensions.toByteArray
import com.tonapps.security.Security
import com.tonapps.security.hex
import com.tonapps.wallet.api.entity.TokenEntity
import com.tonapps.wallet.data.token.entities.AccountTokenEntity
import org.ton.block.AddrStd
import org.ton.block.Coins
import org.ton.block.MsgAddressInt
import org.ton.block.StateInit
import org.ton.cell.Cell
import org.ton.contract.wallet.WalletTransfer
import org.ton.contract.wallet.WalletTransferBuilder
import ton.SendMode
import ton.transfer.Transfer
import java.math.BigInteger

data class TransactionData(
    val address: String? = null,
    val name: String? = null,
    val comment: String? = null,
    val amountRaw: String = "0",
    val max: Boolean = false,
    val token: AccountTokenEntity? = null,
    val bounce: Boolean = false,
) {

    private val t: TokenEntity
        get() = token?.balance?.token ?: TokenEntity.TON

    val icon: Uri
        get() = t.imageUri

    val tokenName: String
        get() = t.name

    val tokenAddress: String
        get() = t.address

    val tokenSymbol: String
        get() = t.symbol

    val isTon: Boolean
        get() = t.isTon

    val destination: AddrStd
        get() {
            if (isTon) {
                return AddrStd.parse(address!!)
            }
            return AddrStd.parse(token?.balance?.walletAddress!!)
        }

    val sendMode: Int
        get() {
            if (max && isTon) {
                return SendMode.CARRY_ALL_REMAINING_BALANCE.value
            }
            return SendMode.PAY_GAS_SEPARATELY.value + SendMode.IGNORE_ERRORS.value
        }

    val coins: Coins
        get() {
            if (isTon) {
                return amount
            }
            return Coins.ofNano(Coin.toNano(0.064f))
        }

    val decimals: Int
        get() = t.decimals

    val amount: Coins
        get() {
            val value = Coin.prepareValue(amountRaw).toFloatOrNull() ?: 0f
            val nano = Coin.toNano(value, decimals)
            return Coins.ofNano(nano)
        }

    fun buildWalletTransfer(
        responseAddress: MsgAddressInt,
        stateInit: StateInit?,
        bodyBuilder: TransactionData.() -> Cell? = { buildWalletTransferBody(responseAddress) }
    ): WalletTransfer {
        val builder = WalletTransferBuilder()
        builder.bounceable = bounce
        builder.destination = destination
        builder.body = this.bodyBuilder()
        builder.sendMode = sendMode
        builder.coins = coins
        builder.stateInit = stateInit
        return builder.build()
    }


    companion object {

        fun getWalletQueryId(): BigInteger {
            try {
                val tonkeeperSignature = 0x546de4ef.toByteArray()
                val randomBytes = Security.randomBytes(4)
                val value = tonkeeperSignature + randomBytes
                val hexString = hex(value)
                return BigInteger(hexString, 16)
            } catch (e: Throwable) {
                return BigInteger.ZERO
            }
        }
    }
}

fun TransactionData.buildWalletTransferBody(
    responseAddress: MsgAddressInt,
): Cell? {
    if (isTon) {
        return Transfer.text(comment)
    }
    return Transfer.jetton(
        coins = amount,
        toAddress = MsgAddressInt.parse(address!!),
        responseAddress = responseAddress,
        queryId = TransactionData.getWalletQueryId(),
        body = comment,
    )
}
