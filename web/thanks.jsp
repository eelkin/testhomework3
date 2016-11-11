<!--
Copyright (c) 2016 Christy Smith
Campus Box 7915, Elon University, Elon, NC 27244

Copyright (c) 2016 Evan Elkin
Campus Box 7947, Elon University, Elon, NC 27244

Copyright (c) 2016 Breslin Wiley
Campus Box 7947, Elon University, Elon, NC 27244
-->
<%@ include file="/includes/header.html" %>
<%@ taglib prefix="elon" uri="/WEB-INF/tlds/elon.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="wrapper"> <!--Wrapper for border-->
    <!-- Displays collected info and calculation after going through Homework
    Servlet-->
    <h1 id="thanks-title">Future Value <span id="breaker"><br></span> Calculator</h1>
    <div class="input-field">
      <label class="result-label">Investment Amount:</label>
      <span class="result-value"><elon:currencyFormat value="${calculator.investmentAmount}"/></span><br>
    </div>
    <div class="input-field">
      <label class="result-label">Yearly Interest Rate:</label>
      <span class="result-value">${calculator.yearlyInterestRate}</span><br>
    </div>
    <div class="input-field">
      <label class="result-label">Number of Years:</label>
      <span class="result-value">${calculator.numberOfYears}</span><br>
    </div>
    <div class="input-field">
      <table>
        <tr>
          <td><strong>Year</strong></td>
          <td><strong>Value</strong></td>
        <tr> 
      
        <c:forEach var="value" items="${calculators}" varStatus="status">
          <tr>
            <td>${status.count}</td>
            <td><elon:currencyFormat value="${value.futureValue}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
    
    <a id="return" href="index.jsp">Return to Calculator</a>
    </div>
<%@ include file="/includes/footer.html" %>