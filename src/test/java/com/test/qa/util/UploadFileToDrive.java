package com.test.qa.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UploadFileToDrive {
	
	/**
	 * Method to upload the csv file to google drive
	 * @param filePath
	 * @param metadata
	 */
	public  Response upload(String filePath,String metadata) {
        String apiUrl = "https://www.googleapis.com/upload/drive/v3/files?uploadType=multipart";
        String accessToken = "ya29.a0AfB_byCmOmK8csFmELRxK14Og7lQPpqfoBdSi97suWTU0CBnpRPFU958Pss6yl_J8_cTQ5eSftBROjsOD8POk8NTOJQ4a3Wx5TVF3enjG7K-jrMCfaz_FH84PdD3pLEOQw56lD-Zej3hPVrNBKzDEdzHmB5a7ohlLDQaCgYKAVYSARMSFQHGX2Mi3cD4ld3IBjIZ_Xlb5RENpA0170";
        Response response= RestAssured.given()
        .header("Authorization", "Bearer " + accessToken)
        .multiPart("metadata", new java.io.File(metadata), ContentType.JSON.toString())
        .multiPart("file", new java.io.File(filePath), "text/csv")
        .when()
        .post(apiUrl);
        return response;
	}
}
