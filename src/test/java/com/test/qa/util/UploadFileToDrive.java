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
	
	//This method can be optimized more. This method is just to upload the file using Google APIS
	public  Response upload(String filePath,String metadata) {
        String apiUrl = "https://www.googleapis.com/upload/drive/v3/files?uploadType=multipart";
        String accessToken = "ya29.a0AfB_byD58NTJJMULX9jWAyQ5bibTGA3NRCca07YnuTNLrQFJoP7ISdTIeIgMdhvP1-FpoRIWBpc0ha5SCUx3XF898s_QMUbPfBYUHzPJ18xIhkxmuOIkiYJW8cdF61SffDtyPJYmBsGPgtR7JBLIUTgaNVAuto7pcwaCgYKAVwSARMSFQHGX2MiATQsiVzxZQRRhGBViytWHg0169";
        Response response= RestAssured.given()
        .header("Authorization", "Bearer " + accessToken)
        .multiPart("metadata", new java.io.File(metadata), ContentType.JSON.toString())
        .multiPart("file", new java.io.File(filePath), "text/csv")
        .when()
        .post(apiUrl);
        return response;
	}
}
