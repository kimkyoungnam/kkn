package kr.kim.dto;

public class Page {
    private int currentPage;//현재 페이지 번호
    private int pageSize;// 페이지 당 보여지는 게시글의 갯수
    // 기본 생성자 : 1페이지, 페이지당 10개의 게시글로 초기화
    public Page() {
        this.currentPage = 1;
        this.pageSize = 10;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {

        // 0 이하 일 경우 1로 강제
        if (currentPage <= 0) {
            this.currentPage = 1;
            return;
        }

        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {

        // 0 이하, 100보다 클 경우 10으로 강제
        if (pageSize <=0 || pageSize > 1000) {
            this.pageSize = 10;
            return;
        }

        this.pageSize = pageSize;
    }
    public int getPageStart() {

        // 예를 들어 페이지당 10개의 게시물을 출력하는 경우, 3페이지의 첫번째 게시물을 출력한다면 ?
        // 전체 게시글 중에서 정렬한 데이터의 index의 21번째 데이터, 즉 20
        // LIMIT 20, 10
        return (this.currentPage - 1) * pageSize;

    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
