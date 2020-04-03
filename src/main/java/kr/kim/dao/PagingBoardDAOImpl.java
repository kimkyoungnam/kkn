package kr.kim.dao;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.SearchOption;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PagingBoardDAOImpl implements PagingBoardDAO {
    private final SqlSessionTemplate sqlSession;
    @Inject
    public PagingBoardDAOImpl(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public List<BoardDTO> listAll(Page page) throws Exception {
        return sqlSession.selectList("pagingboard.listAll",page);
    }

    @Override
    public int listTotalCount(Page page) throws Exception {
        return sqlSession.selectOne("pagingboard.listCount",page);
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        sqlSession.insert("pagingboard.listCreate",createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        return sqlSession.selectOne("pagingboard.listRead",bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        sqlSession.update("pagingboard.listUpdate",listdto);
    }

    @Override
    public void listViewCnt(String bno) throws Exception {
        sqlSession.update("pagingboard.listViewCnt",bno);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        sqlSession.delete("pagingboard.listDelete",bno);
    }

}
