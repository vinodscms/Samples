package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;

public class RestTest {
    public static void main(String[] args) throws  IOException {
        /*HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://t1.testtempoe.com/shc/MarketplaceAPI/api/order/status/");

        StringEntity input = new StringEntity( "{\"UserID\":\"SEARSEC\",\"PSW\":\"password\",\"ApprovalCode\":\"4D4QGBT\",\"Status\":\"CONFIRM\",\"MerchantOrderID\":\"876890057\",\"NotificationAmount\":\"0.00\",\"OrderBalance\":\"500.96\",\"Reason\":\"need to void lease\",\"OrderTotal\":\"500.96\"}\n");
        input.setContentType("application/json");

        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }*/

        String input = new String( "{\"UserID\":\"SEARSEC\",\"PSW\":\"password\",\"ApprovalCode\":\"4D4QGBT\",\"Status\":\"CONFIRM\",\"MerchantOrderID\":\"876890057\",\"NotificationAmount\":\"0.00\",\"OrderBalance\":\"500.96\",\"Reason\":\"need to void lease\",\"OrderTotal\":\"500.96\"}\n");
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod("https://t1.testtempoe.com/shc/MarketplaceAPI/api/order/status/");
        httpClient.setTimeout(12000);
        method.setRequestHeader("Content-type", "application/json");
        //jsonRequest = gsonObject.toJson(wnliRequest);
        method.setRequestBody(input);
        int statusCode = httpClient.executeMethod(method);
        System.out.println("HTTP statuscode " + statusCode);
        String responseMsg = method.getResponseBodyAsString();
        System.out.println("  responseMsg received  " + responseMsg);
        if (null != responseMsg) {
            System.out.println("Yes Success");
        }
    }
}