package cn.oracle.chatbot.api.domain.zsxq.service;

import cn.oracle.chatbot.api.domain.zsxq.IZsxqApi;
import cn.oracle.chatbot.api.domain.zsxq.model.aggregates.UnAnswerQuestionsAggregates;
import cn.oracle.chatbot.api.domain.zsxq.model.req.AnswerReq;
import cn.oracle.chatbot.api.domain.zsxq.model.req.ReqData;
import cn.oracle.chatbot.api.domain.zsxq.model.res.AnswerRes;
import com.alibaba.fastjson.JSON;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ZsxqApiImpl implements IZsxqApi {
    private final Logger logger=LoggerFactory.getLogger(ZsxqApiImpl.class);
    @Override
    public UnAnswerQuestionsAggregates queryUnAnswerQuestionsTopicId(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get= new HttpGet("https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie",cookie);
        get.addHeader("Content-Type","application/json,charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            log.info("拉取提问数据:groupId:{},jsonStr:{}",groupId,jsonStr);
          return JSON.parseObject(jsonStr,UnAnswerQuestionsAggregates.class);

        }else {
           throw new RuntimeException("queryUnAnswerQuestionsTopicId Err Code is "+response.getStatusLine().getStatusCode());
        }

    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/"+topicId+"/answer");
            post.addHeader("cookie",cookie);
        post.addHeader("Content-Type","application/json,charset=utf8");
        post.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");
/*测试数据
               String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"晚上9点23分了\\n\",\n" +
               "    \"image_ids\": []\n" +
                "  }\n" +
               "}";*/
        AnswerReq answerReq=new AnswerReq(new ReqData(text));
        String paramJson= JSONObject.fromObject(answerReq).toString();

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            log.info("回答问题结果,groupId:{},topicId:{},jsonStr:{}",groupId,topicId,paramJson);
            String jsonStr = EntityUtils.toString(response.getEntity());
            AnswerRes answerRes = com.alibaba.fastjson.JSONObject.parseObject(jsonStr, AnswerRes.class);
            return answerRes.isSuccessed();

        }else {
            throw new RuntimeException("answer Err Code is "+response.getStatusLine().getStatusCode());
        }

    }
}
