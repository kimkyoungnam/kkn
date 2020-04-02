package kr.kim.service;

import kr.kim.dao.BoardDAOImpl;
import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardDAOImpl boardDAO;
    @Inject
    public BoardServiceImpl(BoardDAOImpl boardDAO ){//주입
        this.boardDAO= boardDAO;//대입
    }

    @Override
    public List<BoardDTO> listAll() throws Exception {
        return boardDAO.listAll();
    }

    @Override
    public int listTotalCount() throws Exception {
        return 0;
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        boardDAO.listCreate(createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
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
