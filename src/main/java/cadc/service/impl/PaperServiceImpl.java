package cadc.service.impl;

import cadc.entity.Paper;
import cadc.mapper.PaperMapper;
import cadc.service.PaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

    @Override
    public Map<String, Object> generatePaper(Paper paper, int eSize, int jSize, int mSize, int sSize) {
        return null;
    }
}
