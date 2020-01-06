package icbs.lov

class BorrowRiskRating {
    String code
    String description
    String shortDescription
    boolean status

    static constraints = {
    	code maxSize:10, unique:true
    	description unique:true
        shortDescription nullable:true
    }

    static mapping = {
    	id sqlType:'smallint'
    }

    String toString() {
        return description
    }

    String getCodeDescription() {
        "${code} - ${description}"
    }
}
