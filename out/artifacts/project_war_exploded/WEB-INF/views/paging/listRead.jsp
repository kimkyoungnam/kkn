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
                <small>Paging 조회페이지</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 게시판</a></li>
                <li class="active">paging</li>
                <li class="active">조회</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">

            <div class="col-lg-12">
                <%--게시글 영역--%>
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">글제목 : ${boardlist.title}</h3>
                    </div>
                    <div class="box-body" style="height: 700px">
                       ${boardlist.content}
                    </div>
                    <div class="box-footer">
                        <div class="user-block">
                            <img class="img-circle img-bordered-sm" src="../../../resources/dist/img/default-user-image.jpg" alt="user image">
                            <span class="username">
                                <a href="#">${boardlist.writer}</a>
                            </span>
                            <span class="description"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardlist.regdate}"/></span>
                        </div>
                    </div>
                </div>

                <%--버튼 영역--%>
                <div>
                    <form role="form" method="post">
                        <input type="hidden" name="bno" value="${boardlist.bno}">
                        <input type="hidden" name="currentPage" value="${page.currentPage}">
                        <input type="hidden" name="pageSize" value="${page.pageSize}">
                    </form>

                    <button type="submit" class="btn btn-warning modBtn"><i class="fa fa-edit"></i> 수정</button>
                    <button type="submit" class="btn btn-danger delBtn"><i class="fa fa-trash"></i> 삭제</button>
                    <button type="submit" class="btn btn-primary listBtn pull-right"><i class="fa fa-list"></i> 목록</button>
                </div>
                <br/>
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
    $(document).ready(function () {

        var formObj = $("form[role='form']");
        console.log(formObj);

        // 수정버튼 클릭시
        $(".modBtn").on("click", function () {
            formObj.attr("action", "/paging/listUpdate");
            formObj.submit();
        });

        // 삭제 버튼 클릭시
        $(".delBtn").on("click", function () {
            formObj.attr("action", "/paging/listDelete");
            formObj.submit();
        });

        // 목록 버튼 클릭시
        $(".listBtn").on("click", function () {
            self.location = "/paging/listAll";
        });

        // 수정완료시
        var result = "${msg}";
        if (result == "MODIFY") {
            alert("게시글이 수정되었습니다.");
        }

    })
</script>
</body>
</html>