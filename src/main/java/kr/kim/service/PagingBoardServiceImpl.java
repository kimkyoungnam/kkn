package kr.kim.service;

import kr.kim.dao.PagingBoardDAOImpl;
import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PagingBoardServiceImpl implements PagingBoardService {
    private final PagingBoardDAOImpl boardDAO;
    @Inject
    public PagingBoardServiceImpl(PagingBoardDAOImpl boardDAO ){//주입
        this.boardDAO= boardDAO;//대입
    }

    @Override
    public List<BoardDTO> listAll(Page page) throws Exception {
        return boardDAO.listAll(page);
    }

    @Override
    public int listTotalCount(Page page) throws Exception {
        return boardDAO.listTotalCount(page);
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        boardDAO.listCreate(createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        boardDAO.listViewCnt(bno);
        return boardDAO.listRead(bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        boardDAO.listUpdate(listdto);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        boardDAO.listDelete(bno);
    }
}
