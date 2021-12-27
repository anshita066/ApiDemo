//package com.example.apidemo.adapter
//
//import Question
//import org.json.JSONObject
//
//open class Parser{
//
//    fun parseJson(jsonString : String) : ArrayList<Question>{
//
//        var quesList = ArrayList<Question>()
//
//        // cond 1: check is string is blank
//        if (jsonString.isNotBlank()){
//            // if string is not blank convert to json object
//            var jsonObj = JSONObject(jsonString)
//            //cond 2 : check object named "results" is present
//            if(jsonObj.has("results")){
//                //get string array of object results
//                val resultArray = jsonObj.getJSONArray(("results"))
//
//                for(i in 0 until resultArray.length()){
//                    //assign object "dictionary" in dictObject || get object array of dictionary
//                    val dictObject = jsonObj.getJSONObject("dictionary")
//                    //for 0 to length-1 assign questions string of results in quesObj
//                    val quesObj = dictObject.getJSONObject(resultArray.get(i).toString())
//                }
//            }
//        }
//        return quesList
//    }
//}
//
