package kr.kim.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Pagination {
    //게시물  전체 갯수
    private int totalCount;
    // 페이지 시작번호
    private int startPage;
    // 페이지 끝번호
    private int endPage;
    //이전
    private boolean prev;
    //다음
    private boolean next;
    //페이지 블럭 번호 갯수
    private int displayNum=10;
    //기준 클래스 참조 변수
    private Page page;

    private void calcData(){
        //페이지 끝번호 연산
        endPage = (int) (Math.ceil(page.getCurrentPage()/(double)displayNum)*displayNum);

        //페이지 시작번호 연산
        startPage= (endPage-displayNum)+1;

        //끝페이지 검증
        int tempEndPage = (int) (Math.ceil(totalCount/(double)page.getPageSize()));
        if(endPage>tempEndPage){
            endPage=tempEndPage;
        }
        //이전 페이지 활성화
        prev = startPage == 1 ? false : true;
        next = endPage*page.getPageSize() >= totalCount ? false:true;
    }
    public String makeQuery(int currentPage){
        UriComponents  uriComponents= UriComponentsBuilder.newInstance()
                .queryParam("currentPage",currentPage)
                .queryParam("pageSize", page.getPageSize())
                .build();
        return uriComponents.toUriString();
    }
    public String makeSearch(int currentPage){
        UriComponents uriComponents= UriComponentsBuilder.newInstance()
                .queryParam("currentPage",currentPage)
                .queryParam("pageSize",page.getPageSize())
                .queryParam("searchType",((SearchOption)page).getSearchType())
                .queryParam("keyword",encoding(((SearchOption)page).getKeyword()))
                .build();
        return uriComponents.toUriString();
    }
    private String encoding(String keyword){
        if (keyword==null||keyword.trim().length()==0){
            return "";
        }
        try {
            return URLEncoder.encode(keyword,"UTF-8");
        }catch (UnsupportedEncodingException e){
            return "";
        }
    }
    public int getTotalCount() {
        return totalCount;
    }
    //게시물 전체 갯수가 입력되면 페이징 처리 연산 처리
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(int displayNum) {
        this.displayNum = displayNum;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}