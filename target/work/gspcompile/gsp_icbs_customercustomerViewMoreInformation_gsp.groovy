import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerViewMoreInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerViewMoreInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && ((customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id)) {
printHtmlPart(6)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id ))
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (customerInstance?.type.id==1)) {
printHtmlPart(9)
expressionOut.print(customerInstance?.name3)
printHtmlPart(10)
expressionOut.print(customerInstance?.name1)
printHtmlPart(11)
expressionOut.print(customerInstance?.name2)
printHtmlPart(12)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(13)
expressionOut.print(customerInstance?.title?.itemValue)
printHtmlPart(14)
expressionOut.print(customerInstance?.name4)
printHtmlPart(15)
expressionOut.print(customerInstance?.gender?.description)
printHtmlPart(16)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(17)
}
else {
printHtmlPart(18)
expressionOut.print(customerInstance?.name1)
printHtmlPart(19)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(17)
}
printHtmlPart(20)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(21)
expressionOut.print(customerInstance?.type?.description)
printHtmlPart(22)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(23)
expressionOut.print(customerInstance?.civilStatus?.itemValue)
printHtmlPart(24)
expressionOut.print(customerInstance?.birthPlace)
printHtmlPart(25)
expressionOut.print(customerInstance?.nationality?.itemValue)
printHtmlPart(26)
invokeTag('formatNumber','g',101,['format':("#,##0.00"),'number':(customerInstance?.creditLimit)],-1)
printHtmlPart(27)
}
printHtmlPart(28)
loop:{
int i = 0
for( contact in (customerInstance.contacts) ) {
printHtmlPart(29)
if(true && (contact?.status.id == 2)) {
printHtmlPart(30)
expressionOut.print(fieldValue(bean: contact, field: "type.itemValue"))
printHtmlPart(31)
expressionOut.print(fieldValue(bean: contact, field: "contactValue"))
printHtmlPart(31)
expressionOut.print(fieldValue(bean: contact, field: "isPrimaryEmail"))
printHtmlPart(31)
expressionOut.print(fieldValue(bean: contact, field: "isPrimaryPhone"))
printHtmlPart(32)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(34)
loop:{
int i = 0
for( address in (customerInstance.addresses) ) {
printHtmlPart(29)
if(true && (address.status.id==1 || address.status.id==2)) {
printHtmlPart(35)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(36)
expressionOut.print(fieldValue(bean: address, field: "type.description"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "address1"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: address, field: "address2"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: address, field: "town.description"))
printHtmlPart(11)
expressionOut.print(fieldValue(bean: address, field: "address3"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "phone1"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "phone2"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "phone3"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "phone4"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "isPrimary"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "isOwned"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "isMailing"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: address, field: "isMortaged"))
printHtmlPart(38)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(39)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(40)
}
printHtmlPart(41)
if(true && (customerInstance?.type?.id!=1)) {
printHtmlPart(42)
}
printHtmlPart(43)
loop:{
int i = 0
for( relation in (customerInstance.relations) ) {
printHtmlPart(29)
if(true && (relation.status.id==2)) {
printHtmlPart(35)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(36)
expressionOut.print(fieldValue(bean: relation, field: "type.itemValue"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: relation, field: "customer2.customerId"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name1"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name2"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name3"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name4"))
printHtmlPart(44)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(45)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(46)
loop:{
int i = 0
for( education in (customerInstance.educations) ) {
printHtmlPart(29)
if(true && (education.status.id==2)) {
printHtmlPart(35)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(36)
expressionOut.print(fieldValue(bean: education, field: "type.itemValue"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: education, field: "schoolAttended"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: education, field: "yearStart"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: education, field: "yearEnd"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: education, field: "educationDegree"))
printHtmlPart(44)
}
printHtmlPart(47)
i++
}
}
printHtmlPart(48)
loop:{
int i = 0
for( presentedId in (customerInstance.presentedids) ) {
printHtmlPart(29)
if(true && (presentedId.status.id==2)) {
printHtmlPart(49)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(50)
expressionOut.print(fieldValue(bean: presentedId, field: "type.itemValue"))
printHtmlPart(51)
expressionOut.print(fieldValue(bean: presentedId, field: "idNo"))
printHtmlPart(51)
expressionOut.print(presentedId?.issueDate?.format("MM/dd/yyyy"))
printHtmlPart(51)
expressionOut.print(presentedId?.validDate?.format("MM/dd/yyyy"))
printHtmlPart(51)
expressionOut.print(fieldValue(bean: presentedId, field: "isGovtIssue"))
printHtmlPart(51)
expressionOut.print(fieldValue(bean: presentedId, field: "isWithPhoto"))
printHtmlPart(51)
expressionOut.print(fieldValue(bean: presentedId, field: "isWithSignature"))
printHtmlPart(38)
}
printHtmlPart(52)
i++
}
}
printHtmlPart(53)
}
printHtmlPart(54)
loop:{
int i = 0
for( otherAcct in (customerInstance.otheraccts) ) {
printHtmlPart(29)
if(true && (otherAcct.status.id==2)) {
printHtmlPart(35)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(36)
expressionOut.print(fieldValue(bean: otherAcct, field: "type.description"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: otherAcct, field: "bankName"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: otherAcct, field: "branchName"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: otherAcct, field: "acctNo"))
printHtmlPart(37)
expressionOut.print(fieldValue(bean: otherAcct, field: "isOtherAcctJoint"))
printHtmlPart(44)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(55)
loop:{
int i = 0
for( attachment in (customerInstance.attachments) ) {
printHtmlPart(29)
if(true && (attachment.status.id==2)) {
printHtmlPart(35)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(36)
expressionOut.print(fieldValue(bean: attachment, field: "type.description"))
printHtmlPart(56)
expressionOut.print(fieldValue(bean: attachment, field: "fileName"))
printHtmlPart(57)
if(true && (attachment?.id!=null)) {
printHtmlPart(58)
expressionOut.print(createLink(controller:'Attachment', action:'show', id: attachment?.id))
printHtmlPart(59)
expressionOut.print(createLink(controller:'Attachment', action:'download', id: attachment?.id))
printHtmlPart(60)
}
printHtmlPart(61)
}
printHtmlPart(33)
i++
}
}
printHtmlPart(62)
expressionOut.print(customerInstance?.pepDescription)
printHtmlPart(63)
expressionOut.print(customerInstance?.amla)
printHtmlPart(64)
expressionOut.print(customerInstance?.typeOfSourceIncome?.itemValue)
printHtmlPart(65)
expressionOut.print(customerInstance?.sourceOfIncome)
printHtmlPart(66)
expressionOut.print(customerInstance?.customerCode3?.description)
printHtmlPart(67)
expressionOut.print(customerInstance?.customerCode2?.description)
printHtmlPart(68)
expressionOut.print(customerInstance?.customerCode1?.description)
printHtmlPart(69)
expressionOut.print(customerInstance?.status?.description)
printHtmlPart(70)
invokeTag('formatDate','g',436,['format':("MM/dd/yyyy"),'date':(customerInstance?.createdAt)],-1)
printHtmlPart(71)
expressionOut.print(customerInstance?.lastUpdatedBy?.username)
printHtmlPart(72)
invokeTag('formatDate','g',444,['format':("MM/dd/yyyy"),'date':(customerInstance?.lastUpdatedAt)],-1)
printHtmlPart(73)
expressionOut.print(customerInstance?.businesses[0]?.name)
printHtmlPart(74)
expressionOut.print(customerInstance?.businesses[0]?.lProject)
printHtmlPart(75)
expressionOut.print(customerInstance?.businesses[0]?.address1)
printHtmlPart(11)
expressionOut.print(customerInstance?.businesses[0]?.address2)
printHtmlPart(11)
expressionOut.print(customerInstance?.businesses[0]?.address3)
printHtmlPart(76)
invokeTag('formatDate','g',477,['format':("MM/dd/yyyy"),'date':(customerInstance?.businesses[0]?.registrationDate)],-1)
printHtmlPart(77)
expressionOut.print(customerInstance?.businesses[0]?.faxNo)
printHtmlPart(78)
expressionOut.print(customerInstance?.businesses[0]?.eMail)
printHtmlPart(79)
expressionOut.print(customerInstance?.employments[0]?.employerName)
printHtmlPart(80)
expressionOut.print(customerInstance?.employments[0]?.address1)
printHtmlPart(11)
expressionOut.print(customerInstance?.employments[0]?.address2)
printHtmlPart(11)
expressionOut.print(customerInstance?.employments[0]?.address3)
printHtmlPart(81)
expressionOut.print(customerInstance?.employments[0]?.yearStart)
printHtmlPart(82)
expressionOut.print(customerInstance?.employments[0]?.yearEnd)
printHtmlPart(83)
expressionOut.print(customerInstance?.employments[0]?.designation)
printHtmlPart(84)
expressionOut.print(customerInstance?.employments[0]?.employmentId)
printHtmlPart(85)
expressionOut.print(customerInstance?.employments[0]?.depedEmploymentId)
printHtmlPart(86)
expressionOut.print(customerInstance?.employments[0]?.region?.itemValue)
printHtmlPart(87)
expressionOut.print(customerInstance?.employments[0]?.contactNo)
printHtmlPart(88)
expressionOut.print(customerInstance?.employments[0]?.faxNo)
printHtmlPart(89)
expressionOut.print(customerInstance?.employments[0]?.eMail)
printHtmlPart(90)
expressionOut.print(customerInstance?.placeOfBusinessRegistration)
printHtmlPart(91)
expressionOut.print(customerInstance?.registeringAgency)
printHtmlPart(92)
expressionOut.print(customerInstance?.registrationNo)
printHtmlPart(93)
invokeTag('formatDate','g',570,['format':("MM/dd/yyyy"),'date':(customerInstance?.registrationDate)],-1)
printHtmlPart(94)
expressionOut.print(customerInstance?.tin)
printHtmlPart(95)
expressionOut.print(customerInstance?.typeOfBusiness)
printHtmlPart(96)
expressionOut.print(customerInstance?.authorizedRepresentative)
printHtmlPart(97)
expressionOut.print(customerInstance?.listOfDirectorsPartnersStackholder)
printHtmlPart(98)
})
invokeTag('captureContent','sitemesh',595,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(99)
createClosureForHtmlPart(100, 3)
invokeTag('link','g',598,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(101)
createTagBody(3, {->
printHtmlPart(102)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10251').paramValue)
expressionOut.print(icbs.admin.Report.get(5).baseParams)
printHtmlPart(103)
expressionOut.print(icbs.admin.Report.get(5).outputParam)
printHtmlPart(104)
expressionOut.print(icbs.admin.Report.get(5).reportUnit)
printHtmlPart(105)
expressionOut.print(customerInstance?.customerId)
printHtmlPart(106)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(107)
})
invokeTag('javascript','g',610,[:],3)
printHtmlPart(108)
})
invokeTag('captureContent','sitemesh',612,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',613,[:],1)
printHtmlPart(109)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571021484079L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
