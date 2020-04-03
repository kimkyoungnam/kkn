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
                                    <%--<td><a href="/search/listRead?bno=${boardlist.bno}">${boardlist.title}</a></td>--%>
                                    <td><a href="/paging/listRead${pagination.makeSearch(pagination.page.currentPage)}&bno=${boardlist.bno}">${boardlist.title}</a></td>
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
                                    <li><a href="${path}/search/listAll${pagination.makeSearch(pagination.startPage-1)}">이전</a></li>
                                </c:if>
                                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
                                    <li <c:out value="${pagination.page.currentPage == idx ? 'class=active':''}"/>>
                                        <a href="${path}/search/listAll${pagination.makeSearch(idx)}">${idx}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pagination.next}">
                                    <li>
                                        <a href="${path}/search/listAll${pagination.makeSearch(pagination.endPage+1)}">다음</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                        <div>
                            <div class="form-group col-sm-2">
                                <select class="form-control" name="searchType" id="searchType">
                                    <option value="n" <c:out value="${searchOption.searchType == null ? 'selected' : ''}"/>>:::::: 선택 ::::::</option>
                                    <option value="t" <c:out value="${searchOption.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
                                    <option value="c" <c:out value="${searchOption.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
                                    <option value="w" <c:out value="${searchOption.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
                                    <option value="tc" <c:out value="${searchOption.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
                                    <option value="cw" <c:out value="${searchOption.searchType eq 'cw' ? 'selected' : ''}"/>>내용+작성자</option>
                                    <option value="tcw" <c:out value="${searchOption.searchType eq 'tcw' ? 'selected' : ''}"/>>제목+내용+작성자</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" name="keyword" id="keywordInput" value="${searchOption.keyword}" placeholder="검색어">
                                    <span class="input-group-btn">
                                    <button type="button" class="btn btn-primary btn-flat" id="searchBtn">
                                        <i class="fa fa-search"></i> 검색
                                    </button>
                                </span>
                                </div>
                            </div>
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

    $(document).ready(function () {

        $("#searchBtn").on("click", function (event) {

            self.location = "listAll${pagination.makeQuery(1)}"
                + "&searchType="+$("select option:selected").val()
                + "&keyword=" + encodeURIComponent($('#keywordInput').val());

        });

        $("#writeBtn").on("click", function (event) {

            self.location = "/search/listCreate";

        })
    });

</script>
</body>
</html>