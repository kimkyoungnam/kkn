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
                <small>일반적인 수정페이지</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 게시판</a></li>
                <li class="active">일반</li>
                <li class="active">수정</li>
            </ol>
        </section>

        <%-- Main content --%>
        <section class="content container-fluid">
            <div class="col-lg-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">게시글 수정</h3>
                    </div>
                    <form role="form" method="post" action="/paging/listUpdateDo">
                        <div class="box-body">

                            <div class="form-group">
                                <label for="bno">게시글 번호</label>
                                <input type="text" id="bno" name="bno" class="form-control" value="${boardlist.bno}" readonly="readonly">
                            </div>

                            <div class="form-group">
                                <label for="title">제목</label>
                                <input type="text" id="title" name="title" class="form-control" value="${boardlist.title}" >
                            </div>

                            <div class="form-group">
                                <label for="content">내용</label>
                                <textarea class="form-control" id="content" name="content" rows="10" style="resize: none;">${boardlist.content}</textarea>
                            </div>

                            <div class="form-group">
                                <label for="writer">작성자</label>
                                <input type="text" class="form-control" id="writer" name="writer" value="${boardlist.writer}" readonly="readonly">
                            </div>

                        </div>
                    </form>
                    <div class="box-footer">
                        <button type="submit" class="btn btn-warning modifyBtn">수정</button>
                        <button type="submit" class="btn btn-danger cancelBtn">취소</button>
                        <button type="submit" class="btn btn-primary listBtn pull-right">목록</button>
                    </div>
                </div>
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
        $(".modifyBtn").on("click", function () {
            formObj.submit();
        });

        // 취소버튼 클릭시
        $(".cancelBtn").on("click", function () {
            history.go(-1); // <iframe>의 내부에 들어가 있을 경우 사용 X
            //self.location = "/board/read?bno="+"${boardlist.bno}";
        });

        // 목록버튼 클릭시
        $(".listBtn").on("click", function () {
            self.location = "/paging/listAll";
        });

    })
</script>
</body>
</html>