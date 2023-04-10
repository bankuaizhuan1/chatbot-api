package cn.oracle.chatbot.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**@desctiption  单元测试
 * @author wyh
 * @date 2023/1/31 /21:22
 */

public class ApiTest {
    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/15552554155842/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "zsxq_access_token=E33B6998-3B53-8C15-D891-C36BF5EBB14B_6FC0C610C2613017; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22481848244158%22%2C%22first_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxYzM4NWE2OTk2ZDItMGNkMmM5OTFiYmRmYjE4LTI2MDIxYTUxLTEzMjcxMDQtMTgxYzM4NWE2OWExNjhiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDgxODQ4MjQ0MTU4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22481848244158%22%7D%7D; abtest_env=product; zsxqsessionid=51a8187a6ae541cb2643779b6b812916");
        get.addHeader("Content-Type", "application/json,charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814255512814482/answer");
        post.addHeader("cookie", "zsxq_access_token=E33B6998-3B53-8C15-D891-C36BF5EBB14B_6FC0C610C2613017; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22481848244158%22%2C%22first_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217e96c23a441224-0b3464dad8bd598-f791539-1327104-17e96c23a4510a1%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxYzM4NWE2OTk2ZDItMGNkMmM5OTFiYmRmYjE4LTI2MDIxYTUxLTEzMjcxMDQtMTgxYzM4NWE2OWExNjhiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDgxODQ4MjQ0MTU4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22481848244158%22%7D%7D; abtest_env=product; zsxqsessionid=51a8187a6ae541cb2643779b6b812916");
        post.addHeader("Content-Type", "application/json,charset=utf8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"晚上9点23分了\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testFibo() {
        for (int i : fun(5)) {
            System.out.println(i);
        }

    }

    @Test
    public  void testArray(){
        double[] doubles = generateArray(4);
        Double sum=0.0;
        for (double aDouble : doubles) {
            sum+=aDouble;
            System.out.println(aDouble);

        }
        System.out.println("总合--》"+sum);
        //
    }
    public static double[] generateArray(int N) {

            if (N <= 0) {
                return new double[0];
            }

            double[] arr = new double[N];
            double sum = 0.0;

            for (int i = 0; i < N; i++) {
                double rand = (double) Math.round(Math.random() * 100) / 100;
                while (rand == 0.0) {
                    rand = (double) Math.round(Math.random() * 100) / 100;
                }
                arr[i] = rand;
                sum += rand;
            }
        double factor = 1.0 / sum;
            for (int i = 0; i < N; i++) {
                arr[i] = Math.round((arr[i] * factor) * 100.0) / 100.0;
            }

            double diff = 1.0 - Arrays.stream(arr).sum();
//当随机数数组中所有元素归一化后的总和不等于1.0时，我们需要对其中一个元素进行调整，以保证总和为1.0。这两行代码就是对数组最后一个元素进行调整的步骤。
//
//具体来说，arr[N-1] += diff 首先将最后一个元素增加一个差值 diff，以使得数组归一化后的总和变为1.0。例如，如果数组中前面的元素和为0.99，而差值为0.01，那么我们就将最后一个元素增加0.01，从而使得数组的和为1.0。
//
//然后，arr[N-1] = Math.round(arr[N-1] * 100.0) / 100.0 将最后一个元素四舍五入到小数点后两位，以确保所有元素都是小数点后两位的非零数。例如，如果最后一个元素的值为0.133，那么我们将其四舍五入到0.13，从而保证数组中所有元素的小数点后两位都是非零数。
        arr[N-1] += diff;
        arr[N-1] = Math.round(arr[N-1] * 100.0) / 100.0;

            return arr;
        }

    int[] fun(int n) {

//定义存储菲薄拉切数列的数组
            int[]f=new int[n];
//初始化前两项
            f[0]=1;
            f[1]=1;
//计算后面的项
            for(int i=2;i<n;i++){
                f[i]=f[i-1]+f[i-2];


            }
            return f;

        }

}
