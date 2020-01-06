package icbs.tellering

class SssConfig {
    String caption
    String paramValue
    String paramCode
    String paramType
    
    static constraints = {
        caption maxSize:1000,nullable:true
        paramValue maxSize:1000,nullable:true
        paramCode maxSize:1000,nullable:true
        paramType maxSize:1000,nullable:true
    }
    static mapping = {
       
    	id sqlType:'int', generator:'increment'
    	
    }
}
