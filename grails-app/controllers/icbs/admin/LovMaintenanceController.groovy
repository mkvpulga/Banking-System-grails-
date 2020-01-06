package icbs.admin
import icbs.lov.FirmSize
class LovMaintenanceController {
    def index() { }
    
    def sizeOfFirmIndex(){
        def firmSize = FirmSize.list(sort: "code")
        respond firmSize
    }
    
    def firmSizeInstanceEdit(){
        def firmSize = FirmSize.get(params.id)
        if (firmSize){
            respond firmSize
        } else {
          redirect(action: "sizeOfFirmIndex")
        }           
    }
    
    def firmSizeInstanceUpdate(){
        println params
        def firmSize = FirmSize.get(params.id)
        
        redirect(action: "sizeOfFirmIndex")
    }
    
}