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
        String accessToken = "ya29.a0AfB_byC2VYxI0kVavYB_tWGA6Vqi9y89JAH6b-CH4cEp49yK8UaRLmhJFceqoXLejnXx396d8MZj87V-_1FBouVUdpUS4kzuSldc5uF8NVPvTl0aTz-2urocEtcP3ozGzZ2vUOJBgBXBB6IZ9jN_fP94DXIpxG3oDn2ZaSKKaCgYKARkSARMSFQHGX2MibDxRjv5FNvP3Ov1KWY21GA0175";
        Response response= RestAssured.given()
        .header("Authorization", "Bearer " + accessToken)
        .multiPart("metadata", new java.io.File(metadata), ContentType.JSON.toString())
        .multiPart("file", new java.io.File(filePath), "text/csv")
        .when()
        .post(apiUrl);
        return response;
	}
}
