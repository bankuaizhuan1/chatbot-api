package cn.oracle.chatbot.api.domain.zsxq.model.res;

import lombok.Data;

/**
 * 请求问答接口结果
 *
 * @author 武宇鸿
 * @date 2023/03/21
 */
@Data
public class AnswerRes {
    private Boolean succeeded;

    public boolean isSuccessed(){
        return succeeded;
    }
}
