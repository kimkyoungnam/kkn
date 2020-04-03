package kr.kim.service;

import kr.kim.dao.SearchBoardDAOImpl;
import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.SearchOption;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SearchBoardServiceImpl implements SearchBoardService {
    private final SearchBoardDAOImpl searchBoardDAO;
    @Inject
    public SearchBoardServiceImpl(SearchBoardDAOImpl searchBoardDAO ){//주입
        this.searchBoardDAO = searchBoardDAO;//대입
    }

    @Override
    public List<BoardDTO> listAll(Page page) throws Exception {
        return searchBoardDAO.listAll(page);
    }

    @Override
    public int listTotalCount(Page page) throws Exception {
        return searchBoardDAO.listTotalCount(page);
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        searchBoardDAO.listCreate(createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        searchBoardDAO.listViewCnt(bno);
        return searchBoardDAO.listRead(bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        searchBoardDAO.listUpdate(listdto);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        searchBoardDAO.listDelete(bno);
    }

    @Override
    public List<BoardDTO> listSearch(SearchOption searchOption) throws Exception {
        return searchBoardDAO.listSearch(searchOption);
    }

    @Override
    public int countSearched(SearchOption searchOption) throws Exception {
        return searchBoardDAO.countSearched(searchOption);
    }
}
