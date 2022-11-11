package com.example.a662k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a662k.models.Employee
import com.example.a662k.volleyNetWorkHttp.VolleyHandler
import com.example.a662k.volleyNetWorkHttp.VolleyNetworkHttp
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val employee = Employee(1, "Alisher", 50000, 27, "")
        val employeePOST = Employee(88, "Alisher Daminov", 770000, 98, "")
        val employeePUT = Employee(122, "Alisherbek", 8888000, 7, "")

        //apiVolleyList()
       // apiVolleySingle(employee)
        //apiVolleyPost(employeePOST)
        //apiVolleyPut(employeePUT)
         apiVolleyDelete(employeePUT)
    }

    private fun apiVolleyDelete(employee: Employee) {
        VolleyNetworkHttp.delete(VolleyNetworkHttp.API_DELETE_POST + employee.id,
            object : VolleyHandler {
                override fun onSuccess(response: String) {

                }

                override fun onError(error: String) {
                }

            })
    }

    private fun apiVolleyPut(employee: Employee) {
        VolleyNetworkHttp.put(
            VolleyNetworkHttp.API_UPDATE_POST + employee.id,
            VolleyNetworkHttp.paramsUpdate(employee),
            object : VolleyHandler {
                override fun onSuccess(response: String) {

                }

                override fun onError(error: String) {

                }

            })
    }

    private fun apiVolleyPost(employee: Employee) {
        VolleyNetworkHttp.post(
            VolleyNetworkHttp.API_CREATE_POST,
            VolleyNetworkHttp.paramsCreate(employee),
            object : VolleyHandler {
                override fun onSuccess(response: String) {

                }

                override fun onError(error: String) {
                }


            })
    }

    private fun apiVolleySingle(employee: Employee) {
        VolleyNetworkHttp.getSingle(VolleyNetworkHttp.API_SINGLE_POST + employee.id,
            VolleyNetworkHttp.paramsEmpty(),
            object : VolleyHandler {
                override fun onSuccess(response: String) {

                }

                override fun onError(error: String) {
                }

            })
    }

    private fun apiVolleyList() {
        VolleyNetworkHttp.getList(VolleyNetworkHttp.API_LIST_POST, VolleyNetworkHttp.paramsEmpty(),
            object : VolleyHandler {
                override fun onSuccess(response: String) {

                }

                override fun onError(error: String) {
                }

            })
    }


}