package kr.kim.dao;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.SearchOption;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SearchBoardDAOImpl implements SearchBoardDAO {
    private final SqlSessionTemplate sqlSession;
    @Inject
    public SearchBoardDAOImpl(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public List<BoardDTO> listAll(Page page) throws Exception {
        return sqlSession.selectList("searchboard.listAll",page);
    }

    @Override
    public int listTotalCount(Page page) throws Exception {
        return sqlSession.selectOne("searchboard.listCount",page);
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        sqlSession.insert("searchboard.listCreate",createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        return sqlSession.selectOne("searchboard.listRead",bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        sqlSession.update("searchboard.listUpdate",listdto);
    }

    @Override

    public void listViewCnt(String bno) throws Exception {
        sqlSession.update("searchboard.listViewCnt",bno);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        sqlSession.delete("searchboard.listDelete",bno);
    }

    @Override
    public List<BoardDTO> listSearch(SearchOption searchOption) throws Exception {
        return sqlSession.selectList("searchboard.listSearch",searchOption);
    }

    @Override
    public int countSearched(SearchOption searchOption) throws Exception {
        return sqlSession.selectOne("searchboard.countSearch",searchOption);
    }

}
