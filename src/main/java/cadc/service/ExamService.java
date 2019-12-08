package cadc.service;

import cadc.entity.Exam;
import cadc.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface ExamService extends IService<Exam> {
    IPage<Exam> getAllExam(Page<Exam> page);

    boolean updatePaperState(int id, String state);

    Exam getByName(String name);

    List<Exam> getNoEndExam();

    List<Exam> getNoExam();
}
