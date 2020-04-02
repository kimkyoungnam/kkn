package kr.kim.dao;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PageBoardDAOImpl implements PageBoardDAO {
    private final SqlSessionTemplate sqlSession;
    @Inject
    public PageBoardDAOImpl(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public List<BoardDTO> listAll(Page page) throws Exception {
        return sqlSession.selectList("boardPaging.listAll",page);
    }

    @Override
    public int listTotalCount(Page page) throws Exception {
        return sqlSession.selectOne("boardPaging.listCount",page);
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        sqlSession.insert("boardPaging.listCreate",createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        return sqlSession.selectOne("boardPaging.listRead",bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        sqlSession.update("boardPaging.listUpdate",listdto);
    }

    @Override
    public void listViewCnt(String bno) throws Exception {
        sqlSession.update("boardPaging.listViewCnt",bno);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        sqlSession.delete("boardPaging.listDelete",bno);
    }
}
