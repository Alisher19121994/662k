package com.example.a662k.volleyNetWorkHttp

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.a662k.MyApplication
import com.example.a662k.models.Employee
import com.example.a662k.utils.Logger
import org.json.JSONObject

class VolleyNetworkHttp {

    companion object {
        private val TAG = VolleyNetworkHttp::class.java.simpleName
        val IS_TESTER = true
        val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/"
        val SERVER_PRODUCTION = "https://dummy.restapiexample.com/api/v1/"


        fun server(url: String): String {
            if (IS_TESTER) {
                return SERVER_DEVELOPMENT + url
            }
            return SERVER_PRODUCTION + url
        }

        fun headers(): HashMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Content-type"] = "application/json; charset = UTF-8"
            return headers
        }


        fun getList(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response.toString())
                    volleyHandler.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            MyApplication.instance?.addToRequestQueue(stringRequest)
        }



        fun getSingle(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response.toString())
                    volleyHandler.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            MyApplication.instance?.addToRequestQueue(stringRequest)
        }


        fun post(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.POST, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response.toString())
                    volleyHandler.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance?.addToRequestQueue(stringRequest)

        }

        fun put(api: String, body: HashMap<String, Any>, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.PUT, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response.toString())
                    volleyHandler.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }

                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance?.addToRequestQueue(stringRequest)
        }

        fun delete(api: String, volleyHandler: VolleyHandler) {
            val stringRequest = object : StringRequest(
                Method.DELETE, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response.toString())
                    volleyHandler.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    Logger.d(TAG, error.toString())
                    volleyHandler.onError(error.toString())
                }) {}
            MyApplication.instance?.addToRequestQueue(stringRequest)
        }

        var API_LIST_POST = "employees"
        var API_SINGLE_POST = "employee/1"
        var API_CREATE_POST = "create"
        var API_UPDATE_POST = "update/21"
        var API_DELETE_POST = "delete/2"

        fun paramsEmpty(): HashMap<String, String> {
            return HashMap()
        }

        fun paramsCreate(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()

            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }

        fun paramsUpdate(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["id"] = employee.id
            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }


    }
}