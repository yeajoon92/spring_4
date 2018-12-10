package com.cyj.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cyj.board.BoardDAO;
import com.cyj.board.BoardDTO;
import com.cyj.util.DBConnector;
import com.cyj.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="qnaMapper."; //final : 상수로 쓰겠다는 뜻
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"insert", boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"reply", qnaDTO);
	}
	
	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"replyUpdate", qnaDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", num);
	}

	@Override
	public int totalCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}
	
	
	
/*	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from qna "+pager.getKind()+" like ? order by num desc) N) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+pager.getSearch()+"%");
		st.setInt(2, pager.getStartRow());
		st.setInt(3, pager.getLastRow());
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		QnaDTO qnaDTO = new QnaDTO();
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setRef(rs.getInt("ref"));
			qnaDTO.setStep(rs.getInt("step"));
			qnaDTO.setDepth(rs.getInt("depth"));
			ar.add(qnaDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from qna where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		QnaDTO qnaDTO = null;
		if(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setRef(rs.getInt("ref"));
			qnaDTO.setStep(rs.getInt("step"));
			qnaDTO.setDepth(rs.getInt("depth"));
		}
		DBConnector.disConnect(rs, st, con);
		return qnaDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into qna values (qna_seq.nextval, ?, ?, ?, sysdate, 0, qna_seq.currval, 0, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	//reply
	public int reply(QnaDTO qnaDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into qna values (qna_seq.nextval, ?, ?, ?, sysdate, 0, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, qnaDTO.getTitle());
		st.setString(2, qnaDTO.getWriter());
		st.setString(3, qnaDTO.getContents());
		st.setInt(4, qnaDTO.getRef());
		st.setInt(5, qnaDTO.getStep());
		st.setInt(6, qnaDTO.getDepth());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update qna set title=?, contents=? where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete qna where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	@Override
	public int totalCount(Pager pager) throws Exception {
		
		return 0;
	}*/
	
}
