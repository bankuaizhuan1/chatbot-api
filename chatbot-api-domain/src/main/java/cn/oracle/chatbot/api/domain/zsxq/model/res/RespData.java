package cn.oracle.chatbot.api.domain.zsxq.model.res;

import cn.oracle.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * 结果数据
 *
 * @author 武宇鸿
 * @date 2023/03/21
 */
public class RespData {
    private List<Topics> topics;

    public RespData(List<Topics> topics) {
        this.topics = topics;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
