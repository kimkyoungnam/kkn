package kr.kim.dao;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.SearchOption;

import java.util.List;

public interface PagingBoardDAO {
    public List<BoardDTO> listAll(Page page)throws Exception;
    public int listTotalCount(Page page)throws Exception;
    public void listCreate(BoardDTO createdto)throws Exception;
    public BoardDTO listRead(String bno)throws Exception;
    public void listUpdate(BoardDTO listdto)throws Exception;
    public void listViewCnt(String bno)throws Exception;
    public void listDelete(String bno)throws Exception;
}
