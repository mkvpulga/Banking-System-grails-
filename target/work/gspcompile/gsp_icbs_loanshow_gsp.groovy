import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(1)
if(true && (module == 'loan')) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(4)
}
else {
printHtmlPart(5)
createTagBody(3, {->
createTagBody(4, {->
expressionOut.print(title)
})
invokeTag('captureTitle','sitemesh',12,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],3)
printHtmlPart(1)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(7)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateInterestRateAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller :'loan', action:'updateInterestRateAjax'))
printHtmlPart(10)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateBranchAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'customer', action:'customerSaveRelatedAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller :'loan', action:'updateBranchAjax'))
printHtmlPart(13)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateStatusAjax'))
printHtmlPart(14)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateStatAjax'))
printHtmlPart(15)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateCloseStatusAjax'))
printHtmlPart(16)
expressionOut.print(createLink(controller :'loan', action:'updateStatusAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller :'loan', action:'updateStatAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller :'loan', action:'updateCloseStatusAjax'))
printHtmlPart(19)
expressionOut.print(loanInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller :'loan', action:'showUpdateGLClassificationAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller :'loan', action:'updateGLClassificationAjax'))
printHtmlPart(21)
expressionOut.print(loanInstance?.customer?.id)
printHtmlPart(22)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(27).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(27).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(27).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(26)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(27)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(65).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(65).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(65).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(28)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(29)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(28).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(28).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(28).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(28)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(30)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(63).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(63).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(63).reportUnit)
printHtmlPart(31)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(28)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(32)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(66).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(66).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(66).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(33)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(68).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(68).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(68).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(34)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(35)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(69).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(69).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(69).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(36)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(37)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(29).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(29).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(29).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(34)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(38)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(30).baseParams)
printHtmlPart(23)
expressionOut.print(icbs.admin.Report.get(30).outputParam)
printHtmlPart(24)
expressionOut.print(icbs.admin.Report.get(30).reportUnit)
printHtmlPart(25)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(39)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(40)
})
invokeTag('javascript','g',382,[:],2)
printHtmlPart(41)
})
invokeTag('captureHead','sitemesh',383,[:],1)
printHtmlPart(41)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(42)
expressionOut.print(title)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',387,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(44)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(45)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(46)
invokeTag('textField','g',390,['name':("loanid"),'id':("loanid"),'value':(loanInstance.id),'style':("display:none")],-1)
printHtmlPart(47)
if(true && (flash.message)) {
printHtmlPart(48)
expressionOut.print(flash.message)
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (module =="loanAmendment")) {
printHtmlPart(51)
invokeTag('render','g',411,['template':("classification/show")],-1)
printHtmlPart(52)
}
else {
printHtmlPart(53)
invokeTag('render','g',438,['template':("loanApplication/show")],-1)
printHtmlPart(54)
invokeTag('render','g',441,['template':("specification/show")],-1)
printHtmlPart(55)
invokeTag('render','g',444,['template':("classification/show")],-1)
printHtmlPart(56)
invokeTag('render','g',447,['template':("serviceCharges/show")],-1)
printHtmlPart(57)
invokeTag('render','g',450,['template':("deductions/show")],-1)
printHtmlPart(58)
invokeTag('render','g',453,['template':("advancedInterests/list")],-1)
printHtmlPart(59)
invokeTag('render','g',456,['template':("installments/schedule")],-1)
printHtmlPart(60)
invokeTag('render','g',459,['template':("balance/list")],-1)
printHtmlPart(61)
invokeTag('render','g',462,['template':("transactions/list")],-1)
printHtmlPart(62)
invokeTag('render','g',465,['template':("sweep/show")],-1)
printHtmlPart(63)
invokeTag('render','g',468,['template':("history/list")],-1)
printHtmlPart(64)
}
printHtmlPart(65)
if(true && (save != 'save')) {
printHtmlPart(66)
}
printHtmlPart(67)
})
invokeTag('captureContent','sitemesh',578,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(68)
createClosureForHtmlPart(69, 3)
invokeTag('link','g',580,['class':("list"),'controller':(module)],3)
printHtmlPart(70)
if(true && (module == 'loan')) {
printHtmlPart(71)
if(true && (loanInstance&&loanInstance.status?.id == 3 || loanInstance&&loanInstance.status?.id == 4  || loanInstance&&loanInstance.status?.id == 5 || loanInstance&&loanInstance.status?.id == 2)) {
printHtmlPart(72)
invokeTag('textField','g',602,['class':("form-control"),'id':("textfield_crdt"),'name':("textfield"),'value':("")],-1)
printHtmlPart(73)
createClosureForHtmlPart(74, 5)
invokeTag('javascript','g',612,[:],5)
printHtmlPart(75)
invokeTag('textField','g',637,['class':("form-control"),'id':("textfield_crdt"),'name':("textfield"),'value':("")],-1)
printHtmlPart(76)
createClosureForHtmlPart(74, 5)
invokeTag('javascript','g',647,[:],5)
printHtmlPart(77)
invokeTag('textField','g',673,['class':("form-control"),'id':("textfield_Witness"),'name':("textfield"),'value':("")],-1)
printHtmlPart(78)
invokeTag('textField','g',679,['class':("form-control"),'id':("textfield_Address"),'name':("textfield"),'value':("")],-1)
printHtmlPart(79)
invokeTag('textField','g',681,['class':("form-control"),'id':("textfield_Wit"),'name':("textfield"),'value':("")],-1)
printHtmlPart(80)
invokeTag('textField','g',683,['class':("form-control"),'id':("textfield_Add"),'name':("textfield"),'value':("")],-1)
printHtmlPart(81)
createClosureForHtmlPart(74, 5)
invokeTag('javascript','g',690,[:],5)
printHtmlPart(82)
}
printHtmlPart(83)
createClosureForHtmlPart(84, 4)
invokeTag('link','g',694,['action':("edit"),'resource':(loanInstance)],4)
printHtmlPart(85)
createClosureForHtmlPart(86, 4)
invokeTag('link','g',696,['action':("editSweepAccount"),'resource':(loanInstance)],4)
printHtmlPart(87)
createClosureForHtmlPart(88, 4)
invokeTag('link','g',703,['href':("#"),'onclick':("genReportICBS005()")],4)
printHtmlPart(89)
if(true && (loanInstance?.hasInterestAccrual)) {
printHtmlPart(90)
createTagBody(5, {->
invokeTag('actionSubmit','g',710,['action':("stopInterestAccrual"),'value':("Stop Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(91)
})
invokeTag('form','g',710,['url':([controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']),'method':("POST")],5)
printHtmlPart(92)
}
else {
printHtmlPart(90)
createTagBody(5, {->
invokeTag('actionSubmit','g',713,['action':("startInterestAccrual"),'value':("Start Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(91)
})
invokeTag('form','g',713,['url':([controller: loan, id: loanInstance.id,  action:'startInterestAccrual']),'method':("POST")],5)
printHtmlPart(92)
}
printHtmlPart(93)
if(true && (loanInstance?.loanPerformanceId?.id == 1)) {
printHtmlPart(94)
createClosureForHtmlPart(95, 5)
invokeTag('link','g',717,['action':("reschedule"),'resource':(loanInstance)],5)
printHtmlPart(96)
}
else {
printHtmlPart(94)
createClosureForHtmlPart(97, 5)
invokeTag('link','g',717,['action':("restructure"),'resource':(loanInstance)],5)
printHtmlPart(96)
}
printHtmlPart(98)
createClosureForHtmlPart(99, 4)
invokeTag('link','g',721,['action':("renew"),'resource':(loanInstance)],4)
printHtmlPart(100)
if(true && (user?.designation?.id == 19 || user?.designation?.id == 30)) {
printHtmlPart(101)
if(true && (loanInstance&&loanInstance.status?.id <=2)) {
printHtmlPart(102)
}
else {
printHtmlPart(103)
}
printHtmlPart(101)
}
printHtmlPart(104)
if(true && (loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(105)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(106)
createClosureForHtmlPart(107, 6)
invokeTag('link','g',738,['action':("loanRelief"),'id':(loanInstance?.id)],6)
printHtmlPart(108)
}
printHtmlPart(109)
}
else {
printHtmlPart(105)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(110)
}
printHtmlPart(109)
}
printHtmlPart(83)
createClosureForHtmlPart(111, 4)
invokeTag('link','g',743,['controller':("loan"),'action':("viewLoanPaymentList"),'id':(loanInstance?.id)],4)
printHtmlPart(112)
}
else if(true && (module == "loanAmendment")) {
printHtmlPart(113)
createClosureForHtmlPart(84, 4)
invokeTag('link','g',747,['controller':(module),'action':("edit"),'id':(loanInstance?.id)],4)
printHtmlPart(114)
}
else if(true && (module == "loanInterestAccrual" && loanInstance?.status?.id==5)) {
printHtmlPart(115)
if(true && (loanInstance?.hasInterestAccrual)) {
printHtmlPart(90)
createTagBody(5, {->
printHtmlPart(116)
invokeTag('hiddenField','g',753,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(117)
invokeTag('actionSubmit','g',757,['id':("stop"),'action':("stopInterestAccrual"),'value':("Stop Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(118)
})
invokeTag('form','g',764,['id':("stop-form"),'url':([controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']),'method':("POST")],5)
printHtmlPart(92)
}
else {
printHtmlPart(90)
createTagBody(5, {->
printHtmlPart(74)
invokeTag('hiddenField','g',768,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(117)
invokeTag('actionSubmit','g',769,['id':("start "),'action':("startInterestAccrual"),'value':("Start Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(119)
})
invokeTag('form','g',779,['id':("start-form"),'url':([controller: loan, id: loanInstance.id,  action:'startInterestAccrual']),'method':("POST")],5)
printHtmlPart(92)
}
printHtmlPart(5)
}
else if(true && (module == "loanRepricing")) {
printHtmlPart(120)
}
else if(true && (module == "loanReschedule")) {
printHtmlPart(115)
if(true && (loanInstance?.loanPerformanceId.id == 1)) {
printHtmlPart(121)
createClosureForHtmlPart(95, 5)
invokeTag('link','g',783,['controller':(module),'action':("reschedule"),'id':(loanInstance?.id)],5)
printHtmlPart(92)
}
printHtmlPart(122)
}
else if(true && (module == "loanRestructure")) {
printHtmlPart(115)
if(true && (loanInstance?.loanPerformanceId.id == 2 || loanInstance?.loanPerformanceId.id == 3)) {
printHtmlPart(121)
createClosureForHtmlPart(97, 5)
invokeTag('link','g',788,['controller':(module),'action':("restructure"),'id':(loanInstance?.id)],5)
printHtmlPart(123)
}
printHtmlPart(122)
}
else if(true && (module == "loanGLClassification")) {
printHtmlPart(124)
}
else if(true && (module == "loanRenewal")) {
printHtmlPart(113)
createClosureForHtmlPart(99, 4)
invokeTag('link','g',799,['controller':(module),'action':("renew"),'id':(loanInstance?.id)],4)
printHtmlPart(114)
}
else if(true && (module == "loanBranchTransfer")) {
printHtmlPart(125)
}
else if(true && (module == "loanApproval" && loanInstance?.status?.id <=2)) {
printHtmlPart(126)
if(true && (role || user?.designation?.id == 19)) {
printHtmlPart(127)
}
printHtmlPart(128)
createTagBody(4, {->
printHtmlPart(129)
invokeTag('textField','g',830,['class':("form-control"),'id':("txnParticulars"),'name':("txnParticulars"),'value':("")],-1)
printHtmlPart(130)
invokeTag('textField','g',837,['class':("form-control"),'id':("txnReference"),'name':("txnReference"),'value':("")],-1)
printHtmlPart(131)
createClosureForHtmlPart(132, 5)
invokeTag('javascript','g',864,[:],5)
printHtmlPart(133)
})
invokeTag('form','g',866,['id':("approve-form"),'url':([controller: loan, id: loanInstance.id,  action:'approved']),'method':("POST")],4)
printHtmlPart(5)
}
else if(true && (module == "loanApproval" && loanInstance?.status?.id ==3)) {
printHtmlPart(134)
}
else if(true && (module == "loanTermination")) {
printHtmlPart(135)
if(true && (loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(136)
createClosureForHtmlPart(137, 5)
invokeTag('link','g',891,['controller':("loan"),'action':("applyIntToDate"),'id':(loanInstance?.id)],5)
printHtmlPart(138)
createClosureForHtmlPart(139, 5)
invokeTag('link','g',893,['controller':("loan"),'action':("applyIntToMaturity"),'id':(loanInstance?.id)],5)
printHtmlPart(138)
createClosureForHtmlPart(140, 5)
invokeTag('link','g',893,['controller':("loan"),'action':("capitalizeAccruedInt"),'id':(loanInstance?.id)],5)
printHtmlPart(141)
}
printHtmlPart(115)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            (loanInstance?.status?.id == 1 || loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5))) {
printHtmlPart(142)
}
printHtmlPart(115)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 8)) {
printHtmlPart(143)
}
printHtmlPart(144)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 6)) {
printHtmlPart(145)
createClosureForHtmlPart(146, 5)
invokeTag('link','g',907,['action':("reopen"),'resource':(loanInstance)],5)
printHtmlPart(141)
}
printHtmlPart(5)
}
else if(true && (module == "loanWriteOff")) {
printHtmlPart(147)
createClosureForHtmlPart(148, 4)
invokeTag('form','g',911,['url':([controller:loan, action:'transferToWriteOff', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(149)
createClosureForHtmlPart(150, 4)
invokeTag('link','g',912,['action':("viewWriteOff"),'id':(loanInstance.id)],4)
printHtmlPart(151)
createTagBody(4, {->
printHtmlPart(152)
createClosureForHtmlPart(153, 5)
invokeTag('link','g',915,['action':("viewWriteOff"),'id':(loanInstance.id)],5)
printHtmlPart(154)
invokeTag('actionSubmit','g',916,['action':("writeOff"),'value':("Write-Off")],-1)
printHtmlPart(155)
})
invokeTag('form','g',916,['url':([controller:loan, action:'writeOff', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(156)
}
else if(true && (module == "loanROPA")) {
printHtmlPart(157)
createClosureForHtmlPart(148, 4)
invokeTag('form','g',921,['url':([controller:loan, action:'transferToROPA', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(158)
createClosureForHtmlPart(159, 4)
invokeTag('link','g',922,['action':("viewRopa"),'id':(loanInstance.id)],4)
printHtmlPart(160)
createClosureForHtmlPart(161, 4)
invokeTag('link','g',923,['controller':("glBatch"),'action':("create")],4)
printHtmlPart(162)
createClosureForHtmlPart(163, 4)
invokeTag('link','g',924,['controller':(module),'action':("createSCR"),'id':(loanInstance?.id)],4)
printHtmlPart(164)
}
printHtmlPart(165)
})
invokeTag('captureContent','sitemesh',925,['tag':("main-actions")],2)
printHtmlPart(166)
})
invokeTag('captureBody','sitemesh',925,[:],1)
printHtmlPart(167)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1570673129133L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
