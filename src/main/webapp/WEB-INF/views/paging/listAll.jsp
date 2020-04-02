<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%@include file="../include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
<!-- begin:: Page -->
<div class="wrapper">

    <!-- begin:: Header  -->
    <%@include file="../include/main_header.jsp"%>
    <!-- End:: Header  -->

    <!-- begin:: Menu  -->
    <%@include file="../include/menu.jsp"%>
    <!-- End:: Menu  -->

    <!-- begin:: content -->

    <div class="content-wrapper">
        <%-- Content Header (Page header) --%>
        <section class="content-header">
            <h1>
                게시판 예제
                <small>Paging 목록페이지</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 게시판</a></li>
                <li class="active">paging</li>
                <li class="active">전체목록</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">

            <div class="col-lg-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">게시글 목록</h3>
                    </div>
                    <div class="box-body">
                        <%--게시글 목록 영역--%>
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th style="width: 10px;">NO</th>
                                <th>제목</th>
                                <th style="width: 100px">작성자</th>
                                <th style="width: 150px">작성시간</th>
                                <th style="width: 60px">조회</th>
                            </tr>
                            <c:forEach var="boardlist" varStatus="i" items="${boardlist}">
                                <tr>
                                    <td>${boardlist.bno}</td>
                                    <td><a href="/paging/listRead?bno=${boardlist.bno}">${boardlist.title}</a></td>
                                    <td>${boardlist.writer}</td>
                                    <td><fmt:formatDate value="${boardlist.regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
                                    <td><span class="badge bg-aqua">${boardlist.viewcnt}</span></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!--페이징영역-->
                    <div class="box-footer">
                       <div class="text-center">
                            <ul class="pagination">
                                <c:if test="${pagination.prev}">
                                    <li><a href="${path}/paging/listAll?currentPage=${pagination.startPage-1}">이전</a></li>
                                </c:if>
                                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
                                    <li <c:out value="${pagination.page.currentPage == idx ? 'class=active':''}"/>>
                                        <a href="${path}/paging/listAll?currentPage=${idx}">${idx}</a>
                                    </li>
                                </c:forEach>

                                <c:if test="${pagination.next}">
                                    <li><a href="${path}/paging/listAll?currentPage=${pagination.endPage+1}">다음</a></li>
                                </c:if>
                            </ul>
                        </div>
                        <div class="pull-right">
                            <button type="button" class="btn btn-success btn-flat" id="writeBtn">
                                <i class="fa fa-pencil"></i>글쓰기
                            </button>
                        </div>
                    </div>
                </div>
                    <!-- 페이징 끝 -->
            </div>
        </section>
        <%-- /.content --%>
    </div>

    <!-- End:: content -->

    <!-- begin:: main_footer -->
    <%@include file="../include/main_footer.jsp"%>
    <!-- End:: main_footer -->

    <!-- End:: Page -->
</div>

<!-- begin::  plugin-->
<%@include file="../include/plugin_js.jsp"%>
<!-- End::  plugin-->
<script>
    var result ="${msg}";
    if (result == "insertSuccess"){
        alert("게시글 등록 완료!!!!");
    }else if(result =="updateSuccess"){
        alert("게시글 수정 완료!!!!");
    }else if(result =="deleteSuccess"){
        alert("게시글 삭제 완료!!!!");
    }

    $(function () {
        $("#writeBtn").click(function () {
            location.href="/paging/listCreate";
        })
    })
</script>
</body>
</html>