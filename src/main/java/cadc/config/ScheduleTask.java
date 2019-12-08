package cadc.config;

import cadc.entity.Exam;
import cadc.service.ExamService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author haya
 */
@Log4j2
@Component
@Configuration
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private ExamService examService;

    @Scheduled(fixedRate=60000)
    private void configureTasks() {
        List<Exam> list = examService.getNoEndExam();
        Date now = new Date();
        for (Exam item : list) {
            if (now.getTime() > item.getExamEndTime().getTime()) {
                log.warn( item +"结束");
                item.setExamState( "end" );
                item.updateById();
            } else if (now.getTime() > item.getExamStartTime().getTime()) {
                log.warn( item +"开始");
                item.setExamState( "yes" );
                item.updateById();
            }
        }
    }
}
