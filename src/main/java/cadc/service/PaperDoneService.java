package cadc.service;

import cadc.entity.Paper;
import cadc.entity.PaperDone;
import cadc.entity.PaperDoneHistory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface PaperDoneService extends IService<PaperDone> {

    PaperDone getByUserAndPaperId(int userId, int paperId);

    Double sumScore(List<PaperDoneHistory> list);

    boolean updateScore(int id, Double socre);

    IPage<PaperDone> getAll(Page<PaperDone> page);
}
