package cadc.bean;

import cadc.entity.EssayQuestion;
import cadc.entity.JudgeQuestion;
import cadc.entity.MultiQuestion;
import cadc.entity.SingleQuestion;

import java.util.Map;

/**
 * @author haya
 */
public class QuestionFactory {

    public  static MultiQuestion multiQuestionFactory(Map<String, String> map) {
        MultiQuestion multiQuestion = new MultiQuestion();
        if (map.get( "id" ) != null) {
            multiQuestion.setId( Integer.parseInt( map.get( "id" ) ) );
        } else {
            multiQuestion.setId( 0 );
        }
        multiQuestion.setAnswer( map.get( "answer" ) );
        multiQuestion.setChioceA( map.get( "chioceA" ) );
        multiQuestion.setChioceB( map.get( "chioceB" ) );
        multiQuestion.setChioceC( map.get( "chioceC" ) );
        multiQuestion.setChioceD( map.get( "chioceD" ) );
        multiQuestion.setChioceD( map.get( "chioceE" ) );
        multiQuestion.setChioceD( map.get( "chioceF" ) );
        multiQuestion.setScore( Double.parseDouble( map.get( "score" ) ) );
        multiQuestion.setLevel( Integer.parseInt( map.get( "level" ) ) );
        multiQuestion.setSubject( map.get( "subject" ) );
        return multiQuestion;
    }
    public  static SingleQuestion singleQuestionFactory(Map<String, String> map) {
        SingleQuestion singleQuestion = new SingleQuestion();
        if (map.get( "id" ) != null) {
            singleQuestion.setId( Integer.parseInt( map.get( "id" ) ) );
        } else {
            singleQuestion.setId( 0 );
        }
        singleQuestion.setAnswer( map.get( "answer" ) );
        singleQuestion.setChioceA( map.get( "chioceA" ) );
        singleQuestion.setChioceB( map.get( "chioceB" ) );
        singleQuestion.setChioceC( map.get( "chioceC" ) );
        singleQuestion.setChioceD( map.get( "chioceD" ) );
        singleQuestion.setScore( Double.parseDouble( map.get( "score" ) ) );
        singleQuestion.setLevel( Integer.parseInt( map.get( "level" ) ) );
        singleQuestion.setSubject( map.get( "subject" ) );
        return singleQuestion;
    }
    public  static EssayQuestion essayQuestionFactory(Map<String, String> map) {
        EssayQuestion essayQuestion = new EssayQuestion();
        if (map.get( "id" ) != null) {
            essayQuestion.setId( Integer.parseInt( map.get( "id" ) ) );
        } else {
            essayQuestion.setId( 0 );
        }
        essayQuestion.setAnswer( map.get( "answer" ) );
        essayQuestion.setScore( Double.parseDouble( map.get( "score" ) ) );
        essayQuestion.setLevel( Integer.parseInt( map.get( "level" ) ) );
        essayQuestion.setSubject( map.get( "subject" ) );
        return essayQuestion;
    }
    public  static JudgeQuestion judgeQuestionFactory(Map<String, String> map) {
        JudgeQuestion judgeQuestion = new JudgeQuestion();
        if (map.get( "id" ) != null) {
            judgeQuestion.setId( Integer.parseInt( map.get( "id" ) ) );
        } else {
            judgeQuestion.setId( 0 );
        }
        judgeQuestion.setAnswer( map.get( "answer" ) );
        judgeQuestion.setScore( Double.parseDouble( map.get( "score" ) ) );
        judgeQuestion.setLevel( Integer.parseInt( map.get( "level" ) ) );
        judgeQuestion.setSubject( map.get( "subject" ) );
        return judgeQuestion;
    }
}
