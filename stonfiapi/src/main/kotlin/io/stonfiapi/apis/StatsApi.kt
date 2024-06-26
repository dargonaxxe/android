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

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.HttpUrl

import io.stonfiapi.models.GetDexStats200Response
import io.stonfiapi.models.GetOperationStats200Response
import io.stonfiapi.models.GetPoolStats200Response

import com.squareup.moshi.Json

import io.stonfiapi.infrastructure.ApiClient
import io.stonfiapi.infrastructure.ApiResponse
import io.stonfiapi.infrastructure.ClientException
import io.stonfiapi.infrastructure.ClientError
import io.stonfiapi.infrastructure.ServerException
import io.stonfiapi.infrastructure.ServerError
import io.stonfiapi.infrastructure.MultiValueMap
import io.stonfiapi.infrastructure.PartConfig
import io.stonfiapi.infrastructure.RequestConfig
import io.stonfiapi.infrastructure.RequestMethod
import io.stonfiapi.infrastructure.ResponseType
import io.stonfiapi.infrastructure.Success
import io.stonfiapi.infrastructure.toMultiValue

class StatsApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
     * 
     * 
     * @param since Time since stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @param until Time until stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @return GetDexStats200Response
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getDexStats(since: kotlin.String? = null, until: kotlin.String? = null) : GetDexStats200Response {
        val localVarResponse = getDexStatsWithHttpInfo(since = since, until = until)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetDexStats200Response
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param since Time since stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @param until Time until stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @return ApiResponse<GetDexStats200Response?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getDexStatsWithHttpInfo(since: kotlin.String?, until: kotlin.String?) : ApiResponse<GetDexStats200Response?> {
        val localVariableConfig = getDexStatsRequestConfig(since = since, until = until)

        return request<Unit, GetDexStats200Response>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getDexStats
     *
     * @param since Time since stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @param until Time until stats are requested (YYYY-MM-DDTHH:MM:SS) (optional)
     * @return RequestConfig
     */
    fun getDexStatsRequestConfig(since: kotlin.String?, until: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                if (since != null) {
                    put("since", listOf(since.toString()))
                }
                if (until != null) {
                    put("until", listOf(until.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/v1/stats/dex",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return GetOperationStats200Response
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getOperationStats(since: kotlin.String, until: kotlin.String) : GetOperationStats200Response {
        val localVarResponse = getOperationStatsWithHttpInfo(since = since, until = until)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetOperationStats200Response
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return ApiResponse<GetOperationStats200Response?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getOperationStatsWithHttpInfo(since: kotlin.String, until: kotlin.String) : ApiResponse<GetOperationStats200Response?> {
        val localVariableConfig = getOperationStatsRequestConfig(since = since, until = until)

        return request<Unit, GetOperationStats200Response>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getOperationStats
     *
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return RequestConfig
     */
    fun getOperationStatsRequestConfig(since: kotlin.String, until: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("since", listOf(since.toString()))
                put("until", listOf(until.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/v1/stats/operations",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return GetPoolStats200Response
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getPoolStats(since: kotlin.String, until: kotlin.String) : GetPoolStats200Response {
        val localVarResponse = getPoolStatsWithHttpInfo(since = since, until = until)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetPoolStats200Response
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return ApiResponse<GetPoolStats200Response?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getPoolStatsWithHttpInfo(since: kotlin.String, until: kotlin.String) : ApiResponse<GetPoolStats200Response?> {
        val localVariableConfig = getPoolStatsRequestConfig(since = since, until = until)

        return request<Unit, GetPoolStats200Response>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getPoolStats
     *
     * @param since Time since the stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @param until Time until pool stats are requested (YYYY-MM-DDTHH:MM:SS)
     * @return RequestConfig
     */
    fun getPoolStatsRequestConfig(since: kotlin.String, until: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("since", listOf(since.toString()))
                put("until", listOf(until.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/v1/stats/pool",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
