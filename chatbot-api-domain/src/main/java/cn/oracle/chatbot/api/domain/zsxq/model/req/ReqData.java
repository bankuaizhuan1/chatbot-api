package cn.oracle.chatbot.api.domain.zsxq.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *
 * @author wyh
 * @date 2023/3/21
 * @desctiption  请求对象
 * @author 武宇鸿
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqData {
    private String text;
    private String[] imageIds =new String[]{};


    public ReqData(String text) {
        this.text = text;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImageIds() {
        return imageIds;
    }

    public void setImageIds(String[] imageIds) {
        this.imageIds = imageIds;
    }


}
