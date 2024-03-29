package cn.oracle.chatbot.api.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**@desctiption  单元测试
 * @author wyh
 * @date 2023/1/31 /21:22
 */

public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get= new HttpGet("https://api.zsxq.com/v2/groups/15552554155842/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","abtest_env=product; zsxq_access_token=E33B6998-3B53-8C15-D891-C36BF5EBB14B_6FC0C610C2613017; zsxqsessionid=53d11e61fc65de4a4eea13e845274c10; sensorsdata2015jssdkcross={\"distinct_id\":\"481848244158\",\"first_id\":\"17e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1\",\"props\":{\"$latest_traffic_source_type\":\"社交网站流量\",\"$latest_search_keyword\":\"未取到值\",\"$latest_referrer\":\"https://open.weixin.qq.com/\"},\"$device_id\":\"17e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxYzM4NWE2OTk2ZDItMGNkMmM5OTFiYmRmYjE4LTI2MDIxYTUxLTEzMjcxMDQtMTgxYzM4NWE2OWExNjhiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDgxODQ4MjQ0MTU4In0=\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"481848244158\"}}");
        get.addHeader("Content-Type","application/json,charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println( res);

        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/814255512814482/answer");
        post.addHeader("cookie","zsxq_access_token=E33B6998-3B53-8C15-D891-C36BF5EBB14B_6FC0C610C2613017; abtest_env=product; zsxqsessionid=a477bb791fb690f01b5eea5c8c985c94; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22481848244158%22%2C%22first_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxYzM4NWE2OTk2ZDItMGNkMmM5OTFiYmRmYjE4LTI2MDIxYTUxLTEzMjcxMDQtMTgxYzM4NWE2OWExNjhiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDgxODQ4MjQ0MTU4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22481848244158%22%7D%7D");
        post.addHeader("Content-Type","application/json,charset=utf8");
        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"晚上9点23分了\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println( res);

        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
