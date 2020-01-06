package icbs.lov

class CreditScoringAnswers {

        String code
	String description
        String value
	boolean status

    static constraints = {
    	code nullable:true
        description nullable:true
        value nullable:true
        status nullable:true
    }

    static mapping = {
    	id sqlType:'smallint'
    }
}
