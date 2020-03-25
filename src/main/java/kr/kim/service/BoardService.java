package kr.kim.service;

import kr.kim.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> listAll()throws Exception;
    public int listTotalCount()throws Exception;
    public void listCreate(BoardDTO createdto)throws Exception;
    public BoardDTO listRead(String bno)throws Exception;
    public void listUpdate(BoardDTO listdto)throws Exception;
    public void listDelete(String bno)throws Exception;
}
