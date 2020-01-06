import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_productshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (productInstance?.code)) {
printHtmlPart(9)
expressionOut.print(fieldValue(bean: productInstance, field: "code").padLeft(3, '0'))
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.name)) {
printHtmlPart(12)
invokeTag('fieldValue','g',48,['bean':(productInstance),'field':("name")],-1)
printHtmlPart(10)
}
printHtmlPart(13)
if(true && (productInstance?.productType)) {
printHtmlPart(14)
expressionOut.print(productInstance?.productType?.description)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.shortName)) {
printHtmlPart(15)
invokeTag('fieldValue','g',60,['bean':(productInstance),'field':("shortName")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.allowFdPartialWithrawal)) {
printHtmlPart(16)
invokeTag('formatBoolean','g',66,['boolean':(productInstance?.allowFdPartialWithrawal)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.allowFdMultiplePlacement)) {
printHtmlPart(17)
invokeTag('formatBoolean','g',72,['boolean':(productInstance?.allowFdMultiplePlacement)],-1)
printHtmlPart(10)
}
printHtmlPart(18)
if(true && (productInstance?.depositDormancyMonths)) {
printHtmlPart(19)
invokeTag('fieldValue','g',78,['bean':(productInstance),'field':("depositDormancyMonths")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.depositDormancyTransferFreq)) {
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(productInstance?.depositDormancyTransferFreq?.description)
})
invokeTag('link','g',84,['controller':("depositAcctDormancyTransferFreq"),'action':("show"),'id':(productInstance?.depositDormancyTransferFreq?.id)],4)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.hasDepositDormancyInterest)) {
printHtmlPart(21)
invokeTag('formatBoolean','g',90,['boolean':(productInstance?.hasDepositDormancyInterest)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.depositDormancyAmt)) {
printHtmlPart(22)
invokeTag('fieldValue','g',96,['bean':(productInstance),'field':("depositDormancyAmt")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.depositChargeStart)) {
printHtmlPart(23)
invokeTag('fieldValue','g',102,['bean':(productInstance),'field':("depositChargeStart")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.isMicrofinance)) {
printHtmlPart(24)
invokeTag('formatBoolean','g',108,['boolean':(productInstance?.isMicrofinance)],-1)
printHtmlPart(10)
}
printHtmlPart(18)
if(true && (productInstance?.documentTemplate)) {
printHtmlPart(25)
invokeTag('fieldValue','g',114,['bean':(productInstance),'field':("documentTemplate")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.currency)) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(productInstance?.currency?.name)
})
invokeTag('link','g',120,['controller':("currency"),'action':("show"),'id':(productInstance?.currency?.id)],4)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.maxBalance)) {
printHtmlPart(27)
invokeTag('formatNumber','g',126,['format':("###,###,##0.00"),'number':(productInstance?.maxBalance)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.minBalance)) {
printHtmlPart(28)
invokeTag('formatNumber','g',132,['format':("###,###,##0.00"),'number':(productInstance?.minBalance)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.maxOpen)) {
printHtmlPart(29)
invokeTag('formatNumber','g',138,['format':("###,###,##0.00"),'number':(productInstance?.maxOpen)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.minOpen)) {
printHtmlPart(30)
invokeTag('formatNumber','g',144,['format':("###,###,##0.00"),'number':(productInstance?.minOpen)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.maxTerm)) {
printHtmlPart(31)
invokeTag('formatNumber','g',150,['format':("#####"),'number':(productInstance?.maxTerm)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.minTerm)) {
printHtmlPart(32)
invokeTag('formatNumber','g',156,['format':("#####"),'number':(productInstance?.minTerm)],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.loanProvisionFreq)) {
printHtmlPart(33)
expressionOut.print(productInstance?.loanProvisionFreq?.description)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.loanReclassFreq)) {
printHtmlPart(34)
expressionOut.print(productInstance?.loanReclassFreq?.description)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.loanUidTransferFreq)) {
printHtmlPart(35)
expressionOut.print(productInstance?.loanUidTransferFreq?.description)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.configItemStatus)) {
printHtmlPart(36)
expressionOut.print(productInstance?.configItemStatus?.description)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.configItemStatus)) {
printHtmlPart(36)
expressionOut.print(productInstance?.configItemStatus?.description)
printHtmlPart(10)
}
printHtmlPart(37)
if(true && (productInstance?.amortizedChargeSchemes)) {
printHtmlPart(38)
for( a in (productInstance.amortizedChargeSchemes) ) {
printHtmlPart(39)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(40)
createTagBody(5, {->
expressionOut.print(a?.name)
})
invokeTag('link','g',206,['controller':("amortizedChargeSchemeProduct"),'action':("show"),'id':(a.id)],5)
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (productInstance?.interestIncomeSchemes)) {
printHtmlPart(44)
invokeTag('sortableColumn','g',225,['property':("code"),'title':(message(code: 'interestIncomeSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(45)
invokeTag('sortableColumn','g',226,['property':("description"),'title':(message(code: 'interestIncomeSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(46)
loop:{
int i = 0
for( intr in (productInstance.interestIncomeSchemes) ) {
printHtmlPart(45)
if(true && (intr.statusId == 2)) {
printHtmlPart(39)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(47)
createTagBody(6, {->
expressionOut.print(intr.code)
})
invokeTag('link','g',233,['controller':("interestIncomeScheme"),'action':("show"),'id':(intr.id)],6)
printHtmlPart(48)
expressionOut.print(intr.name)
printHtmlPart(49)
}
printHtmlPart(50)
i++
}
}
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (productInstance?.loanDeductionSchemes)) {
printHtmlPart(53)
invokeTag('sortableColumn','g',254,['property':("code"),'title':(message(code: 'loanDeductionSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(45)
invokeTag('sortableColumn','g',255,['property':("description"),'title':(message(code: 'loanDeductionSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(46)
loop:{
int i = 0
for( l in (productInstance.loanDeductionSchemes) ) {
printHtmlPart(45)
if(true && (l.statusId == 2)) {
printHtmlPart(54)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(55)
createTagBody(6, {->
expressionOut.print(l.code)
})
invokeTag('link','g',263,['controller':("loanDeductionScheme"),'action':("show"),'id':(l.id)],6)
printHtmlPart(48)
expressionOut.print(l.name)
printHtmlPart(56)
}
printHtmlPart(50)
i++
}
}
printHtmlPart(57)
}
printHtmlPart(52)
if(true && (productInstance?.loanPerformanceClassificationSchemes)) {
printHtmlPart(58)
for( l in (productInstance.loanPerformanceClassificationSchemes) ) {
printHtmlPart(39)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(40)
createTagBody(5, {->
expressionOut.print(l?.name)
})
invokeTag('link','g',287,['controller':("loanPerformanceClassificationProduct"),'action':("show"),'id':(l.id)],5)
printHtmlPart(41)
}
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.penaltyIncomeSchemes)) {
printHtmlPart(61)
invokeTag('sortableColumn','g',308,['property':("code"),'title':(message(code: 'penaltyIncomeSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(50)
invokeTag('sortableColumn','g',309,['property':("description"),'title':(message(code: 'penaltyIncomeSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(62)
loop:{
int i = 0
for( p in (productInstance.penaltyIncomeSchemes) ) {
printHtmlPart(50)
if(true && (p.statusId == 2)) {
printHtmlPart(63)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(64)
createTagBody(6, {->
expressionOut.print(p.code)
})
invokeTag('link','g',317,['controller':("penaltyIncomeScheme"),'action':("show"),'id':(p.id)],6)
printHtmlPart(65)
expressionOut.print(p.name)
printHtmlPart(66)
}
printHtmlPart(67)
i++
}
}
printHtmlPart(68)
}
printHtmlPart(69)
invokeTag('sortableColumn','g',340,['property':("code"),'title':(message(code: 'branch.code.label', default: 'Code'))],-1)
printHtmlPart(70)
invokeTag('sortableColumn','g',341,['property':("description"),'title':(message(code: 'branch.name.label', default: 'Branch Name'))],-1)
printHtmlPart(71)
loop:{
int i = 0
for( productBranch in (productBranches) ) {
printHtmlPart(72)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(73)
createTagBody(4, {->
expressionOut.print(productBranch.branch.code)
})
invokeTag('link','g',347,['controller':("Branch"),'action':("show"),'id':(productBranch.branch.id)],4)
printHtmlPart(74)
expressionOut.print(productBranch.branch.name)
printHtmlPart(75)
i++
}
}
printHtmlPart(76)
invokeTag('sortableColumn','g',361,['property':("name"),'title':(message(code: 'txnTemplates.description.label', default: 'Group Name'))],-1)
printHtmlPart(77)
for( customerGroup in (productInstance.customerGroups) ) {
printHtmlPart(78)
expressionOut.print(customerGroup.name)
printHtmlPart(79)
}
printHtmlPart(80)
invokeTag('sortableColumn','g',380,['property':("code"),'title':(message(code: 'txnTemplates.code.label', default: 'Code'))],-1)
printHtmlPart(70)
invokeTag('sortableColumn','g',381,['property':("description"),'title':(message(code: 'txnTemplates.description.label', default: 'Description'))],-1)
printHtmlPart(71)
loop:{
int i = 0
for( txnTemplate in (productInstance.txnTemplates) ) {
printHtmlPart(72)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(73)
createTagBody(4, {->
expressionOut.print(txnTemplate.code)
})
invokeTag('link','g',387,['controller':("TxnTemplate"),'action':("show"),'id':(txnTemplate.id)],4)
printHtmlPart(74)
expressionOut.print(txnTemplate.description)
printHtmlPart(75)
i++
}
}
printHtmlPart(81)
createClosureForHtmlPart(82, 3)
invokeTag('form','g',396,['id':("delete"),'url':([resource:productInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(83)
})
invokeTag('captureContent','sitemesh',398,['tag':("main-content")],2)
printHtmlPart(84)
createTagBody(2, {->
printHtmlPart(85)
createTagBody(3, {->
invokeTag('message','g',401,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',401,['class':("create"),'action':("create")],3)
printHtmlPart(86)
if(true && (productInstance.configItemStatus.id.toInteger() in [1, 2])) {
printHtmlPart(87)
createTagBody(4, {->
invokeTag('message','g',403,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',403,['class':("edit"),'action':("edit"),'resource':(productInstance)],4)
printHtmlPart(88)
invokeTag('actionSubmit','g',412,['id':("deleteProduct"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00703', 'form#delete', 'Override delete Product.', null);
                                },
                                function(){
                                    return;
                                });                                 
                            """)],-1)
printHtmlPart(86)
}
printHtmlPart(89)
createClosureForHtmlPart(90, 3)
invokeTag('link','g',423,['action':("index")],3)
printHtmlPart(91)
})
invokeTag('captureContent','sitemesh',425,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',426,[:],1)
printHtmlPart(92)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129316L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
