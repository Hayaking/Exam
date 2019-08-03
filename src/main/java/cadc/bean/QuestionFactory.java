package cadc.bean;

import cadc.entity.SingleQuestion;

import java.util.Map;

/**
 * @author haya
 */
public class QuestionFactory {

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
        singleQuestion.setSubject( map.get( "subjet" ) );
        return singleQuestion;
    }
}
