<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div style="font-size: ${fontSize}" class="content">
    <p>Font size = ${fontSize}</p>
    <p>Questions(${numberOfQuestionsToShow}): </p>

    <%--@elvariable id="productWithQuestions" type="com.expertsoft.data.ProductData"--%>
    <c:if test="${empty productWithQuestions.questions}">
        <p>No questions left for this product!</p>
    </c:if>
    <c:if test="${not empty productWithQuestions.questions}">
        <c:forEach var="i" begin="1" end="${numberOfQuestionsToShow}">
            <c:set var="questionItem" value="${productWithQuestions.questions[i - 1]}"/>
            <div>
                <p>Q: ${questionItem.questionCustomer} - ${questionItem.question}</p>
                <c:if test="${not empty questionItem.answer}">
                    <p>A: ${questionItem.answerCustomer} - ${questionItem.answer}</p>
                </c:if>
            </div>
            <br>
        </c:forEach>
    </c:if>

</div>