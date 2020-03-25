package kr.kim.dao;

import kr.kim.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO {
    private final SqlSessionTemplate sqlSession;
    @Inject
    public BoardDAOImpl(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public List<BoardDTO> listAll() throws Exception {
        return sqlSession.selectList("board.listAll");
    }

    @Override
    public int listTotalCount() throws Exception {
        return 0;
    }

    @Override
    public void listCreate(BoardDTO createdto) throws Exception {
        sqlSession.insert("board.listCreate",createdto);
    }

    @Override
    public BoardDTO listRead(String bno) throws Exception {
        return sqlSession.selectOne("board.listRead",bno);
    }

    @Override
    public void listUpdate(BoardDTO listdto) throws Exception {
        sqlSession.update("board.listUpdate",listdto);
    }

    @Override
    public void listDelete(String bno) throws Exception {
        sqlSession.delete("board.listDelete",bno);
    }
}
