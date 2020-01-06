
<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.loans.CreditScoringQuestions" %>
<%@ page import="icbs.loans.CreditScoringQuestionSection" %>
<%@ page import="icbs.loans.CreditScoringPreQualification" %>
<%@ page import="icbs.loans.CreditScoringCodeDescription" %>
<%@ page import="icbs.loans.CreditScoringChecklistRecords" %>
<%@ page import="icbs.loans.CreditScoringMatrix" %>
<%@ page import="icbs.loans.CreditScoringPreQualification" %>
<%@ page import="icbs.loans.CreditScoringTallyOfScores" %>
<%@ page import="icbs.lov.CreditScoringAnswers" %>
<%@ page import="icbs.loans.CreditScoringRated" %>
<%@ page import="icbs.loans.CreditScoringRatedItems" %>
<%@ page import="icbs.loans.CreditScoringRatedItemsRecords" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<title>View Credit Scoring Details</title>
	</head>
        
	<body>  
        <content tag="main-content">  
            <g:if test="${scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true}" >
                <div class="row" style="margin:auto">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header"><b>Loan Application Details</b><a style="float:right" id="tab1" class="collapsed" data-toggle="collapse" href="#table1"  aria-controls="table1"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                            <div id="table1" class="collapse in">
                            <table class="table table-bordered table-striped" >
                                <tbody>
                                    <tr>
                                        <td><b>Name of Borrower :</b></td>
                                        <td>${creditInvestigationInstance?.loanApplication?.customer?.displayName}</td>
                                        <td><b>Originating Unit :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.originatingUnit}</td>
                                    </tr>
                                    <tr>
                                        <%-- =========== ADDRESS =========--%>
                                        <g:set var="primaryAddress" value="${(creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true})}"/>
                                        <td><b>Address :</b></td>
                                        <g:if test="${primaryAddress!=null}">
                                            <td>${primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3}</td>
                                        </g:if>
                                        <g:else>
                                           <td>N / A</td>
                                        </g:else>
                                        <%-- ============================= --%>
                                        <%-- ====== Contact =======--%>
                                        <td><b>Contact No. :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.contactNumber}</td>
                                        <%-- ====================== --%>
                                    </tr>
                                    
                                    <tr>
                                        <td><b>Name of Business :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.nameOfBusiness}</td>
                                        <td><b>Industry/Subsector :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.industrySubsector}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Previous CRR/Rating :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.previousCrrRating}</td>
                                        <td><b>Industry Code :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.industryCode}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Previous Rating/Date :</b></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.previousRatingDate}" /></td>
                                        <td><b>Date of Current Rating :</b></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.dateOfCurrentRating}" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Basic Reasons for CRR : </b></td>
                                        <td>${creditScoringLoanDetailsInstance?.basicReasonForCrr}</td>
                                        <td><b>Rater : </b></td>
                                        <td>${creditScoringLoanDetailsInstance?.rater}</td>
                                    </tr>
                                    <tr>
                                        <td><b>Type of Collateral : </b></td>
                                        <td>${creditScoringLoanDetailsInstance?.typeOfCollateral?.description}</td>
                                        <td><b>Appraisal Value - REM : </b></td>
                                        <g:if test="${creditScoringLoanDetailsInstance?.appraisalValueRem}">
                                            <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.appraisalValueRem}" /></td>
                                        </g:if>
                                        <g:else>
                                            <td></td>
                                        </g:else>    
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td><b>AV - Other Collateral :</b></td>
                                        <g:if test="${creditScoringLoanDetailsInstance?.avOtherCollateral}">
                                            <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.avOtherCollateral}" /></td>
                                        </g:if>
                                        <g:else>
                                            <td></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td><b>Facility Type/s :</b></td>
                                        <td>${creditScoringLoanDetailsInstance?.facilityTypes}</td>
                                        <td><b>Expiry Date of Loan  :</b></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.expiryDateOfLoan}" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Commitment Amount :</b></td>
                                        <g:if test="${creditScoringLoanDetailsInstance?.commitmentAmount}">
                                            <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.commitmentAmount}" /></td>
                                        </g:if>
                                        <g:else>
                                            <td>0.00</td>
                                        </g:else>  
                                        <td><b>Total O/s Balance (P) :</b></td>
                                        <g:if test="${creditScoringLoanDetailsInstance?.totalOsBalance}">
                                            <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.totalOsBalance}" /></td>
                                        </g:if>
                                        <g:else>
                                            <td>0.00</td>
                                        </g:else>    
                                    </tr>

                                </tbody>
                            </table>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </g:if>
            <g:else>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Loan Application Details</b><a style="float:right" id="tab1" class="collapsed" data-toggle="collapse" href="#table1"  aria-controls="table1"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table1" class="collapse in">
                        <table class="table table-bordered table-striped" >
                            <tbody>
                                <tr>
                                    <td><b>Name of Borrower :</b></td>
                                    <td>${creditInvestigationInstance?.loanApplication?.customer?.displayName}</td>
                                    <td><b>Originating Unit :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.originatingUnit}</td>
                                </tr>
                                <tr>
                                    <%-- =========== ADDRESS =========--%>
                                    <g:set var="primaryAddress" value="${(creditInvestigationInstance?.loanApplication?.customer?.addresses?.find{it.isPrimary==true})}"/>
                                    <td><b>Address :</b></td>
                                    <g:if test="${primaryAddress!=null}">
                                        <td>${primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3}</td>
                                    </g:if>
                                    <g:else>
                                       <td>N / A</td>
                                    </g:else>
                                    <%-- ============================= --%>
                                    <%-- ====== Contact =======--%>
                                    <td><b>Contact No. :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.contactNumber}</td>
                                    <%-- ====================== --%>
                                </tr>
                                <tr>
                                    <%-- ========= Employer ==== --%>
                                    
                                    <td><b>Employer :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.employer}</td>
                                    
                                    
                                    <td><b>Previous Rating :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.previousCrrRating}</td>
                                </tr>
                                <tr>
                                    <td><b>Designation/Rank :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.designationRank}</td>
                                    <td><b>Date of Previous Rating :</b></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.previousRatingDate}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Type of Collateral :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.typeOfCollateral?.description}</td>
                                    <td><b>Current Rating :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.currentRating}</td>
                                </tr>
                                <tr>
                                    <td><b>AV of Collateral : </b></td>
                                    <td>${creditScoringLoanDetailsInstance?.avOfCollateral}</td>
                                    <td><b>Date of Current Rating :</b></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.dateOfCurrentRating}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Other Collateral : </b></td>
                                    <td>${creditScoringLoanDetailsInstance?.otherCollateral}</td>
                                    <td><b>Reason/s for Rating : </b></td>
                                    <td>${creditScoringLoanDetailsInstance?.reasonsOfRating}</td>
                                </tr>
                                <tr>
                                    <td><b>AV of Other Collateral : </b></td>
                                    <g:if test="${creditScoringLoanDetailsInstance?.avOtherCollateral}">
                                        <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.avOtherCollateral}" /></td>
                                    </g:if>
                                    <g:else>
                                        <td></td>
                                    </g:else>    
                                    <td><b>Rater's Name : </b></td>
                                    <td>${creditScoringLoanDetailsInstance?.rater}</td>
                                </tr>
                                <tr>
                                    <td><b>Loan Type/s :</b></td>
                                    <td>${creditScoringLoanDetailsInstance?.loanType}</td>
                                    <td><b>Expiry Date of Loan  : </b></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${creditScoringLoanDetailsInstance?.expiryDateOfLoan}" /></td>
                                </tr>
                                <tr>
                                    <td><b>Commitment Amount :</b></td>
                                    <g:if test="${creditScoringLoanDetailsInstance?.commitmentAmount}">
                                        <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.commitmentAmount}"/></td>
                                    </g:if>
                                    <g:else>
                                        <td>0.00</td>
                                    </g:else>
                                    <td><b>Total O/s Balance (P) : </b></td>
                                    <g:if test="${creditScoringLoanDetailsInstance?.totalOsBalance}">
                                        <td><g:formatNumber format="###,###,##0.00" number="${creditScoringLoanDetailsInstance?.totalOsBalance}"/></td>
                                    </g:if>
                                    <g:else>
                                        <td>0.00</td>
                                    </g:else>
                                </tr>
                            </tbody>
                        </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            </g:else>
            
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Pre Qualifiction Result</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table2"  aria-controls="table2"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table2" class="collapse in">    
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th>Pre Qualification Item</th>
                                        <th>Evaluation</th>
                                    </tr>
                                    <g:if test="${preQualificationInstance}">
                                        <g:each in="${preQualificationInstance}" var="recentPrequalification">
                                            <tr>
                                                <td>${recentPrequalification?.creditScoringPreQualification?.preQualificationItem}</td>
                                                <td>${recentPrequalification?.preQualificationAnswer?.description}</td>    
                                            </tr>
                                        </g:each>
                                    </g:if>
                                    <g:else>
                                        <g:each in="${idCreditPreq}" var="recentPrequalification">
                                            <tr>
                                                <td>${recentPrequalification?.preQualificationItem}</td>
                                                <td></td>    
                                            </tr>
                                        </g:each>
                                    </g:else>

                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            <legend>Credit Scoring Record</legend>
            
            <g:each in="${xxscoringSectionInstance}" var="sectionListing" >
                <div class="row" style="margin:auto">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header"><b>${sectionListing?.nameOfSection} ${sectionListing?.sectionPercentage} %</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#sectionTable${sectionListing.id}"  aria-controls="sectionTable${sectionListing.id}"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                            <div id="sectionTable${sectionListing.id}" class="collapse in"> 
                                <table class="table table-bordered table-striped">
                                    <tbody>
                                        <tr>
                                            <th>Check List Item</th>
                                            <th>Evaluation</th>
                                            <th>Score</th>
                                        </tr>
                                        <g:each in="${CreditScoringChecklistRecords.findAllByCreditScoringQuestionSection(sectionListing)}" var="questionWithValue" >
                                            <tr>
                                                <td><label>${questionWithValue?.creditScoringQuestions?.questionNumberDescription}<label></td>
                                                <td><label>${questionWithValue?.creditScoringAnswers?.description}<label></td>
                                                <td><label>${questionWithValue?.creditScoringAnswers?.value}<label></td>
                                            </tr>
                                        </g:each>    
                                    </tbody>
                                </table>
                            </div>
                        </fieldset>
                    </div>
                </div>
            </g:each>
            <legend>Tally of Score Details</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Breakdown of Scores per section</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table4"  aria-controls="table4"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table4" class="collapse in">    
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th>Section Details</th>
                                        <th style="text-align:center;">Section Percentage</th>
                                        <th style="text-align:center;"># of items per Section</th>
                                        <th style="text-align:center;">Total Score per Section</th>
                                        <th style="text-align:center;">Final Rate per Section</th>
                                    </tr>
                                    <g:each in="${resultqueryall}" var="tallyOfScores">
                                        <tr>
                                            <td><b>${tallyOfScores?.name}</b></td>
                                            <td style="text-align:center;">${tallyOfScores?.section_percentage}</td>
                                            <td style="text-align:center;">${tallyOfScores?.noofitems}</td>
                                            <td style="text-align:center;">${tallyOfScores?.sumofscores}</td>
                                            <td style="text-align:center;"><g:formatNumber format="###,###,##0.00" number="${(tallyOfScores?.sumofscores / tallyOfScores?.noofitems)*(tallyOfScores?.section_percentage * 0.01)}"/></td>
                                        </tr>
                                    </g:each>
                                    <tr>
                                        <td><label style="color: red;">TOTAL: </label></td>
                                        <td style="text-align:center;"><label >100%</label></td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:center;"><label style="color: red;"><g:formatNumber format="###,###,##0.00" number="${totalScoresInstance?.scoreRateTotal}"/></label></td>
                                    </tr>    
                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            
            <legend>Total Score</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Total Score Details</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table5"  aria-controls="table5"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table5" class="collapse in">
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th style="text-align:center;">TOTAL SCORE</th>
                                        <th style="text-align:center;">INITIAL CRR</th>
                                        <th style="text-align:center;">RATING ASSESSMENT</th>
                                        <th style="text-align:center;">RISK LEVEL</th>
                                    </tr>

                                    <tr>
                                        <td style="text-align:center;">${initialCrrRatingScores?.totalScore}</td>
                                        <td style="text-align:center;">${initialCrrRatingScores?.initialCrr}</td>  
                                        <td style="text-align:center;">${initialCrrRatingScores?.creditScoringrating?.ratingAssessment}</td> 
                                        <td style="text-align:center;">${initialCrrRatingScores?.creditScoringrating?.riskLevel}</td>  
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            
            <g:if test="${scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem == true}" >
                <legend>Credit Scoring Rated List Record</legend>
                <g:each in="${ratedInstanceListingRecords}" var="ratedddListing" >
                    <div class="row" style="margin:auto">
                        <div class="section-container">
                            <fieldset>
                                <legend class="section-header"><b>${ratedddListing?.ratedName.substring(0,ratedddListing?.ratedName.indexOf('-'))}</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#anotherSectionTable${ratedddListing.id}"  aria-controls="anotherSectionTable${ratedddListing.id}"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                                <div id="anotherSectionTable${ratedddListing.id}" class="collapse in">   
                                    <table class="table table-bordered table-striped">
                                        <tbody>
                                            <tr>
                                                <th>Check List Item</th>
                                                <th>Evaluation</th>

                                            </tr>
                                            <g:each in="${CreditScoringRatedItemsRecords.findAllByCreditScoringRated(ratedddListing)}" var="ratedWithValues" >
                                                <tr>
                                                    <td><label>${ratedWithValues?.creditScoringRatedItems?.itemDescription}<label></td>
                                                    <td><label>${ratedWithValues?.creditScoringAnswers?.description}<label></td>

                                                </tr>
                                            </g:each>    
                                        </tbody>
                                    </table>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </g:each>
            </g:if> 
            <legend>Calculated CRR</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Calculated CRR Details</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table7"  aria-controls="table7"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table7" class="collapse in">    
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th style="text-align:center;">CRR Score Assessment</th>
                                        <th style="text-align:center;">Risk Rating</th>
                                        <th style="text-align:center;">Risk Level</th>
                                    </tr>
                                    <g:if test="${daCalculatedCrrDetails}">
                                    <tr>
                                        <td style="text-align:center;">${daCalculatedCrrDetails.calculatedBrr ? daCalculatedCrrDetails.calculatedBrr.toInteger() : ''}</td>
                                        <td style="text-align:center;">${daCalculatedCrrDetails?.ratingAssessment}</td>  
                                        <td style="text-align:center;">${daCalculatedCrrDetails?.riskLevel}</td> 
                                    </tr>
                                    </g:if>   

                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>    
            <legend>Recommended CRR</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Recommended CRR Details</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table8"  aria-controls="table8"> Minimize/Maximize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table8" class="collapse in">
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th style="text-align:center;">Recommended CRR Value</th>
                                        <th style="text-align:center;">Risk Rating</th>
                                        <th style="text-align:center;">Risk Level </th>
                                    </tr>
                                    <g:if test="${initialCrrRatingScores}">
                                        <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                                             <tr>
                                                <td style="text-align:center;">${initialCrrRatingScores?.recommendedCrrScore.toInteger()}</td>
                                                <td style="text-align:center;">${initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment}</td>
                                                <td style="text-align:center;">${initialCrrRatingScores?.recommendedCrrRating?.riskLevel}</td>
                                            </tr>
                                        </g:if>
                                        <g:else>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            <tr>
                                        </g:else>   
                                    </g:if>    
                                    <g:else>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        <tr>
                                    </g:else>  

                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
             <legend>COMPLETENESS OF REQUIRED DOCUMENTS</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Evaluation Details</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table9"  aria-controls="table9"> Minimize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table9" class="collapse in">    
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th>Assessment Details</th>
                                        <th style="text-align:center;">Assessment Result</th>
                                        <th style="text-align:center;">Assessment Value</th>
                                    </tr>
                                    <tr>
                                        <g:if test="${initialCrrRatingScores?.scoreCompletenessOfDocument}">
                                            <g:if test="${initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 1}">
                                                 <td>A. Complete and enforceable documentation</td>
                                            </g:if>
                                            <g:elseif test="${initialCrrRatingScores?.scoreCompletenessOfDocument?.id == 1}">
                                                <td>B. Acceptable (with deficiencies but covered by Exception Rectification Sheet or ERS by CAD)</td>
                                            </g:elseif>
                                            <g:else>    
                                                <td>C. Insufficient or incomplete documentation to include :</br>
                                                    <ul>
                                                        <li>missing collateral folders  and documents including but not limited to title, mortgage instruments, and PNs</li>
                                                        <li>Unsigned PN or PN signed by unauthorized persons/officers of the borrowing entity</li>
                                                        <li>No updated Credit Investigation Report, no latest BIR-stamped Income Tax Return, or Audited Financial Statement</li>
                                                    </ul>    
                                                </td>
                                            </g:else>

                                            <td style="text-align:center;">${initialCrrRatingScores?.scoreCompletenessOfDocument?.description}</td>
                                            <td style="text-align:center;">${initialCrrRatingScores?.scoreCompletenessOfDocument?.value}</td>
                                        </g:if>
                                        <g:else>    
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </g:else>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            <legend>FINAL CRR AFTER DOCUMENTATION COMPLIANCE FACTOR</legend>
            <div class="row" style="margin:auto">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"><b>Assessment Details</b><a style="float:right" class="collapsed" data-toggle="collapse" href="#table10"  aria-controls="table10"> Minimize <span class="fa fa-sort-down fa-2x"> </span></a></legend>
                        <div id="table10" class="collapse in">
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th style="text-align:center;">FINAL CRR AFTER DOCUMENTATION COMPLIANCE FACTOR</th>
                                        <th style="text-align:center;">RATING ASSESSMENT</th>
                                        <th style="text-align:center;">RISK LEVEL</th>
                                    </tr>
                                    <g:if test="${finalResultsss}">
                                    <tr>
                                        <td style="text-align:center;">${finalResultsss?.calculatedBrr}</td>
                                        <td style="text-align:center;">${finalResultsss?.ratingAssessment}</td>  
                                        <td style="text-align:center;">${finalResultsss?.riskLevel}</td> 
                                    </tr>
                                    </g:if>   
                                    <g:else>
                                   <tr>
                                        <td style="text-align:center;"></td>
                                        <td style="text-align:center;"></td>  
                                        <td style="text-align:center;"></td> 
                                    </tr>
                                    </g:else>    
                                </tbody>
                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
            <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                <g:form name="editRommendationForm" id="editRommendationForm" url="[action:'saveUpdateRecommededCrr',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">
                <!-- Modal -->
                <div class="modal fade" id="updatechangeRecommendation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Update Recommendation CRR Form</h4>
                      </div>
                      <div class="modal-body">
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="">Recommended CRR
                            </label>
                            <g:hiddenField name="editcreditInvestigationId" id="editcreditInvestigationId" value="${creditInvestigationInstance?.id}" />
                            <g:hiddenField name="editmatrixId" id="editmatrixId" value="${initialCrrRatingScores?.recommendedCrrRating.id}" />
                            <div class="col-sm-8"><g:textField name="editrecCrr" id="editrecCrr" onblur="updategetRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrScore.toInteger()}" class="form-control"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-md-4" for="">Risk Assessment 
                            </label>
                            <div class="col-sm-8"><g:textField name="editriskAssessment" id="editriskAssessment" onblur="getRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrRating?.ratingAssessment}" class="form-control" disabled="true"/></div>
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-md-4" for="">Risk Level
                            </label>
                            <div class="col-sm-8"><g:textField name="editriskLevel" id="editriskLevel" onblur="getRiskRating(this.value);"  value="${initialCrrRatingScores?.recommendedCrrRating?.riskLevel}" class="form-control" disabled="true"/></div>
                        </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="updateSaveRecommendation();">Save changes</button>
                      </div>
                    </div>
                  </div>
                </div>
                </g:form>
            </g:if>    
            <g:form name="addRecommendation" id="addRecommendation" url="[action:'saveRecommededCrr',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">
            <!-- Modal -->
            <div class="modal fade" id="changeRecommendation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Recommendation CRR Form</h4>
                  </div>
                  <div class="modal-body">
                    <div class="fieldcontain form-group">
                        <label class="control-label col-sm-4" for="">Recommended CRR
                        </label>
                        <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />
                        <g:hiddenField name="matrixId" id="matrixId" value="" />
                        <div class="col-sm-8"><g:textField type="number" name="recCrr" id="recCrr"  onblur="getRiskRating();" values="" class="form-control"/></div>
                    </div>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-md-4" for="">Risk Assessment
                        </label>
                        <div class="col-sm-8"><g:textField type="number" name="riskAssessment" id="riskAssessment" rows="4" cols="50" values="" class="form-control" disabled="true"/></div>
                    </div>
                    <div class="fieldcontain form-group">
                        <label class="control-label col-md-4" for="">Risk Level
                        </label>
                        <div class="col-sm-8"><g:textField type="number" name="riskLevel" id="riskLevel" rows="4" cols="50" values="" class="form-control" disabled="true"/></div>
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveAddRecommendation();">Save changes</button>
                  </div>
                </div>
              </div>
            </div>
            </g:form>
            <g:form name="completenessOfDoducmentForm" url="[action:'addCompletenessRecord',controller:'creditInvestigation']" onsubmit="callLoadingDialog();" method="POST">                            
            <!-- Modal -->
            <div class="modal fade" id="complenessModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                      <h4 class="modal-title" id="myModalLabel">COMPLETENESS OF REQUIRED DOCUMENTS</h4>
                    </div>
                    <div class="modal-body">
                        <label for="">A. Complete and enforceable documentation</label>
                        <label for="">B. Acceptable (with deficiencies but covered by Exception Rectification Sheet or ERS by CAD)</label>
                        <label for="">C. Insufficient or incomplete documentation to include :</label>
                            <ul>
                                <li>Missing collateral folders  and documents including but not limited to title, mortgage instruments, and PNs</li>
                                <li>Unsigned PN or PN signed by unauthorized persons/officers of the borrowing entity</li>
                                <li>No updated Credit Investigation Report, no latest BIR-stamped Income Tax Return, or Audited Financial Statement</li>
                            </ul>
                        <g:if test="${initialCrrRatingScores}">    
                            <g:if test="${initialCrrRatingScores?.scoreCompletenessOfDocument}">
                                <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />    
                                
                                
                                <g:select noSelection="['':'-Set Score Here-']" id="completeNessRequired" name="completeNessRequired" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="${initialCrrRatingScores?.scoreCompletenessOfDocument?.id}" class="many-to-one form-control" ></g:select>
                            </g:if>
                            <g:else>
                                
                                <g:hiddenField name="creditInvestigationId" id="creditInvestigationId" value="${creditInvestigationInstance?.id}" />    
                                <g:select noSelection="['':'-Set Score Here-']" id="completeNessRequired" name="completeNessRequired" from="${icbs.lov.CreditScoringAnswers.findAllByStatusAndCode(true,'charAnswer',[sort: "id", order: "asc"])}" optionKey="id" optionValue="description" value="" class="many-to-one form-control" ></g:select>
                            </g:else>    
                        </g:if>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary" onclick="saveCompletenessOfDocuments();">Save changes</button>
                    </div>
                </div>
              </div>
            </div>
            </g:form>
            <g:javascript>
                function saveAddRecommendation(){
                    alertify.confirm(AppTitle,"Are you sure about this?",
                    function(){
                        $('#addRecommendation').submit();
                        $('#changeRecommendation').hide();
                    },
                    function(){
                      alertify.error('Cancel');
                    });
                }
                
                function updateSaveRecommendation(){
                     alertify.confirm(AppTitle,"Are you sure about this?",
                    function(){
                        $('#editRommendationForm').submit();
                        $('#updatechangeRecommendation').hide();
                    },
                    function(){
                      alertify.error('Cancel');
                    });
                }
                function getRiskRating(){
                    var recommendedCrr = $('#recCrr').val();
                    
                    var obj = { 
                        calculatedbrr: recommendedCrr,
                    }; 
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "${createLink(controller:'creditInvestigation', action:'getRiskRatingAjax')}",
                        data: JSON.stringify(obj),

                        success: function(data){
                            if(data.length >=1){
                                $.each(data, function (_key, _value) {
                                    console.log(JSON.stringify(data))
                                    
                                    $('#riskAssessment').val(_value.rating_assessment);
                                    $('#riskLevel').val(_value.risk_level);
                                    $('#matrixId').val(_value.id);
                                 
                                });

                            }else{
                               
                                notify.message('Sorry, No Risk Assessment found for Recommended CRR value |error|alert');

                            }
                            

                        },
                        error: function(data){

                        },

                    }); 
                }
                function updategetRiskRating(){
                
                    var recommendedCrr = $('#editrecCrr').val();
                    
                    var obj = { 
                        calculatedbrr: recommendedCrr,
                    }; 
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "${createLink(controller:'creditInvestigation', action:'getRiskRatingAjax')}",
                        data: JSON.stringify(obj),

                        success: function(data){
                            if(data.length >=1){
                                $.each(data, function (_key, _value) {
                                    console.log(JSON.stringify(data))
                                    
                                    $('#editriskAssessment').val(_value.rating_assessment);
                                    $('#editriskLevel').val(_value.risk_level);
                                    $('#editmatrixId').val(_value.id);
                                 
                                });

                            }else{
                               
                                notify.message('Sorry, No Risk Assessment found for Recommended CRR value |error|alert');

                            }
                            

                        },
                        error: function(data){

                        },

                    }); 
                }
                function saveCompletenessOfDocuments(){
                    var completnessEvaluation = $('#completeNessRequired').val();
                    if(completnessEvaluation == null || completnessEvaluation == ""){
                        notify.message('Sorry, Please Set an evaluation to continue |error|alert');
                    }else{
                        alertify.confirm(AppTitle,"Are you sure about this ?",
                        function(){
                          $('#completenessOfDoducmentForm').submit();
                          $('#complenessModalForm').hide();
                        },
                        function(){
                          alertify.error('Canceled...');
                        });
                    }
                    
                    
                }
            </g:javascript>    
        </content>
         <content tag="main-actions">
            <ul>
                
                <li><g:link class="list" controller="creditInvestigation" action="updateCredScorLoanAppDet" id="${creditInvestigationInstance.id}" >Update Credit Score Loan App Details</g:link></li>
                <g:if test="${preQualificationInstance}">
                    <li><g:link class="list" controller="creditInvestigation" action="updatePreQualificaion" id="${creditInvestigationInstance.id}" >Update Performed Pre Qualification Credit Score</g:link></li>
                </g:if>   
                <g:else>
                    <li><g:link class="list" controller="creditInvestigation" action="preQualification" id="${creditInvestigationInstance.id}" >Perform Pre Qualification  Credit Score</g:link></li>
                </g:else>    
                <g:if test="${Boolean.valueOf(isQualifiedForCheckList) == true}">
                    <g:if test="${Boolean.valueOf(isCheckListAlreadyDone) == true}">
                        <li><g:link class="list" controller="creditInvestigation" action="updatePerformedCreditScoring" id="${creditInvestigationInstance.id}" >Update Perform Credit Scoring</g:link></li>
                        <g:if test="${initialCrrRatingScores}">
                            <g:if test="${Boolean.valueOf(scoringProductConfigInstance?.creditScoringCodeDescription?.hasRatedItem) == true}" >
                                
                                <g:if test="${Boolean.valueOf(isRatedAlreadyEvaluated) == true}">
                                    <li><g:link class="list" controller="creditInvestigation" action="updatePerformedRated" id="${creditInvestigationInstance.id}" >Update Performed Rated Items</g:link></li>
                                </g:if> 
                                <g:else>
                                    <li><g:link class="list" controller="creditInvestigation" action="performRatedItems" id="${creditInvestigationInstance.id}" >Perform Rated Section Scoring</g:link></li>
                                </g:else>    
                            
                                <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updatechangeRecommendation">Update Recommendation CRR</button></li>
                                </g:if>
                                <g:else>
                                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#changeRecommendation">Add Recommendation CRR</button></li>
                                </g:else>
                            </g:if>    
                            <g:else>
                                <g:if test="${initialCrrRatingScores?.recommendedCrrScore}">
                                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#updatechangeRecommendation">Update Recommendation CRR</button></li>
                                </g:if>
                                <g:else>
                                    <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#changeRecommendation">Add Recommendation CRR</button></li>
                                </g:else>
                            </g:else>     
                        </g:if>
                        <li><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#complenessModalForm">Evaluate Completeness Of Required Docs</button></li>
                        
                    </g:if>
                    <g:else>
                        <li><g:link class="list" controller="creditInvestigation" action="performCreditScoring" id="${creditInvestigationInstance.id}" >Perform Credit Scoring</g:link></li>
                    </g:else>
                </g:if>    
                <g:else>
                    <li><button disabled="disable">Perform Credit Scoring</button></li>
                </g:else>     
                
                 <li><g:link class="list" controller="creditInvestigation" action="show" id="${creditInvestigationInstance.id}" >Back to Credit Investigation Form</g:link></li>   
                 
                
            </ul>
    	</content>
	</body>
</html>
