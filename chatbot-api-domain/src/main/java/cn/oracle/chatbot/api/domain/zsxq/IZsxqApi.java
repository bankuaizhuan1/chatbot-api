package cn.oracle.chatbot.api.domain.zsxq;

import cn.oracle.chatbot.api.domain.zsxq.model.aggregates.UnAnswerQuestionsAggregates;

import java.io.IOException;

/***
 *
 * @author wyh
 * @date 2023/3/21
 * @desctiption 知识星球 API 接口
 *
*/

public interface IZsxqApi {
    /**
     * 查询未回答的问题
     *
     * @param groupId 组id
     * @param cookie  cookie
     * @throws IOException ioexception
     */
    UnAnswerQuestionsAggregates queryUnAnswerQuestionsTopicId (String groupId, String cookie) throws IOException;

    boolean answer(String groupId,String cookie,String topicId,String text)throws IOException;
}
