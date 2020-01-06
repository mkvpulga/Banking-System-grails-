<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.deposit.Signatory" %>

<html>
    <head>
        <title>AMLA Risk Rating</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">

        <g:javascript>

        </g:javascript>
    </head>
    <body>
    <content tag="main-content">
        <div id="customerInquiryFormDiv">
            <!--
      To change this license header, choose License Headers in Project Properties.
      To change this template file, choose Tools | Templates
      and open the template in the editor.
    -->

            <%@ page contentType="text/html;charset=UTF-8" %>


            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <div class="section-container">
                        <fieldset>

<g:hiddenField name="customerId" id="customerId" value="${params.id}" />
                            <legend class="section-header">AMLA Risk Assessment</legend>   

                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <th width="40%">Factors </th>   
                                        <th width="10%">Type</th>
                                        <th width="10%">Score</th>
                                        <th width="40%">Description</th>
                                    </tr>
                                    <tr>
                                        <td width="40%">Risk Classification of Person Note: if risk rating is 3(High Risk), CRR shall be automatically tagged as High</td>   
                                        <g:if test="${amlaRiskInstance?.score1 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score1 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score1 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score1}</td>
                                        <g:if test="${amlaRiskInstance?.score1 == 1}">
                                            <td width="40%">Individuals / Other than those Listed as designated professionals</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score1 == 2}">
                                            <td width="40%">Professionals (lawyers and accountants acting as independent professionals</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score1 == 3}">
                                            <td width="40%">PEP, its immediate family members and close associates;  Precious metals, stone dealers, gun/ammunition/military equipment dealers, remittance agent, money changer, junket operator/agent, custom broker</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>
                                    </tr>   
                                    <tr>
                                        <td width="40%">Citizenship</td>   
                                        <g:if test="${amlaRiskInstance?.score2 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score2 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score2 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score2}</td>
                                        <g:if test="${amlaRiskInstance?.score2 == 1}">
                                            <td width="40%">Filipino Citizen</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score2 == 2}">
                                            <td width="40%">Resident Alien</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score2 == 3}">
                                            <td width="40%">Non-Resident Alien</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Geographical Address</td>   
                                        <g:if test="${amlaRiskInstance?.score3 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score3 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score3 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score3}</td>
                                        <g:if test="${amlaRiskInstance?.score3 == 1}">
                                            <td width="40%">Present or Permanent address is within the branch vicinity, known to branch personnel and properly identified thru KYC documents.</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score3 == 2}">
                                            <td width="40%">Address declared is not permanent but within the branch operating unit vicinity</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score3 == 3}">
                                            <td width="40%">Present or Permanent address is outside the branch/operating unit vicinity or non-Philippine address.</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Individual Identification</td>   
                                        <g:if test="${amlaRiskInstance?.score4 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score4 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score4 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score4}</td>
                                        <g:if test="${amlaRiskInstance?.score4 == 1}">
                                            <td width="40%">Use of primary or secondary photo bearing Philippine government issued IDs.</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score4 == 2}">
                                            <td width="40%">Use of IDs issued by a private entities / company IDs</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score4 == 3}">
                                            <td width="40%">Use of foreign government photo bearing issued IDs.</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Occupation/Nature of work or Self-employment</td>   
                                        <g:if test="${amlaRiskInstance?.score5 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score5 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score5 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score5}</td>
                                        <g:if test="${amlaRiskInstance?.score5 == 1}">
                                            <td width="40%">Employed Locally, Retired Employee, Pensioner, OFW, Beneficiary of an OFW.</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score5 == 2}">
                                            <td width="40%">Student, Self-Employed, or Unemployed but with spouse income.</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score5 == 3}">
                                            <td width="40%">Expatriates, Consular, Unemployed but income is not derived from spouse or immediate family member (Father, Mother, Son, Daughter, Brother or Sister)</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Source of Fund</td>   
                                        <g:if test="${amlaRiskInstance?.score6 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score6 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score6 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score6}</td>
                                        <g:if test="${amlaRiskInstance?.score6 == 1}">
                                            <td width="40%">Salary, Property, Pension, Financial Products</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score6 == 2}">
                                            <td width="40%">Business, Commission, Allotment</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score6 == 3}">
                                            <td width="40%">Donations, Contributions, Gaming</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Account Opening Method; Loan Application</td>   
                                        <g:if test="${amlaRiskInstance?.score7 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score7 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score7 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score7}</td>
                                        <g:if test="${amlaRiskInstance?.score7 == 1}">
                                            <td width="40%">Face to Face with all account owners/signatories, loan borrowers/signayoties but authenticated.</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score7 == 2}">
                                            <td width="40%">Face to Face with some account owner, signatories/loan borrowers/signatories but authenticated.</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score7 == 3}">
                                            <td width="40%">Account owners/signatories/loan borrowers/signatories authenticated by the loan evaluator or new accounts officer</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Declared Gross Monthly Income/Salary</td>   
                                        <g:if test="${amlaRiskInstance?.score8 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score8 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score8 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score8}</td>
                                        <g:if test="${amlaRiskInstance?.score8 == 1}">
                                            <td width="40%">499,000.00 and below</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score8 == 2}">
                                            <td width="40%">More than 500,000.00</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score8 == 3}">
                                            <td width="40%">More than 1M.</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Length of Relationship</td>   
                                        <g:if test="${amlaRiskInstance?.score9 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score9 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score9 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score9}</td>
                                        <g:if test="${amlaRiskInstance?.score9 == 1}">
                                            <td width="40%">Existing customer with relationship of equal to or more than 1 year.</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score9 == 2}">
                                            <td width="40%">Existing customer with relationship of less than one (1) year.</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score9 == 3}">
                                            <td width="40%">No prior relationship</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td width="40%">Number of Existing Loans</td>   
                                        <g:if test="${amlaRiskInstance?.score10 == 1}">
                                            <td width="10%">Low</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score10 == 2}">
                                            <td width="10%">Medium</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score10 == 3}">
                                            <td width="10%">High</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="10%"></td>
                                        </g:else>

                                        <td width="10%">${amlaRiskInstance?.score10}</td>
                                        <g:if test="${amlaRiskInstance?.score10 == 1}">
                                            <td width="40%">0 to 1 loan</td>
                                        </g:if>
                                        <g:elseif test="${amlaRiskInstance?.score10 == 2}">
                                            <td width="40%">2 to 3 loans</td>
                                        </g:elseif>
                                        <g:elseif test="${amlaRiskInstance?.score10 == 3}">
                                            <td width="40%">More than 5 loans</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="40%"></td>
                                        </g:else>
                                    </tr>
                                </tbody>
                            </table>    
                        </fieldset>
                    </div><!-- end section-container-->


                    <div class="section-container">
                       


                            
                          
                            <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                       <th width="70%">CUSTOMER RISK CLASSIFICATION</th>   
                                        <th width="30%">TOTAL RISK SCORE</th>
                                       
                                            </tr>
                                    <tr>
                                        <g:if test="${totalScore >= 1 && totalScore <= 15}">
                                            <td width="70%">LOW RISK CLIENTS</td>
                                        </g:if>
                                        <g:elseif test="${totalScore >= 16 && totalScore <= 25}">
                                            <td width="70%">MEDIUM RISK CLIENTS</td>
                                        </g:elseif>
                                        <g:elseif test="${totalScore >= 26 && totalScore <= 30}">
                                            <td width="70%">HIGH RISK CLIENTS</td>
                                        </g:elseif>
                                        <g:else>
                                            <td width="70%"></td>
                                        </g:else>
                                            <td width="30%">${totalScore}</td>
                                        </tr>   
                                        
                                </tbody>
                            </table>    
                        
                    </div><!-- end section-container-->
                        </div>
                        </div>

        </div>

                    </content>
                <content tag="main-actions">
        <ul>
             <li><g:link  action="createAmlaRisk" id="${params.id}">AMLA Risk Assessment</g:link><li>
                        <li><g:link  action="customerInquiry" id="${params.id}">Back to Customer Inquiry</g:link><li>
                                </ul>
                                </content>
                                </body>
                                </html>
