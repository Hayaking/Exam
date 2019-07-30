package cadc.service;

import cadc.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author haya
 */
public interface PaperService extends IService<Paper> {

    /**
     * 随机选择题数生成试卷
     * @param paper
     * @param eSize 简答题数量
     * @param jSize 判断题数量
     * @param mSize 多选题数量
     * @param sSize 单选题数量
     * @return 键值对的方式保存 paper - xxx, single - xxx, essay - xxx, multi - xxx, judge - xxx
     */
    Map<String, Object> generatePaper(Paper paper, int eSize, int jSize, int mSize, int sSize);
}
