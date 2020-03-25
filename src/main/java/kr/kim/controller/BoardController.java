package kr.kim.controller;

import kr.kim.dto.BoardDTO;
import kr.kim.service.BoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;


@Controller
public class BoardController {
    private final Logger logger= LoggerFactory.getLogger(BoardController.class);
    private final BoardServiceImpl boardSerivce;
    @Inject
    public BoardController(BoardServiceImpl boardSerivce){
        this.boardSerivce=boardSerivce;
    }

    //list 목록
    @RequestMapping("/board/listAll")
    public String boardList(Model model) throws Exception {
        logger.info("listAll:::::::");
     model.addAttribute("boardlist",boardSerivce.listAll());
     return "board/listAll";
    }
    //list 작성페이지
    @RequestMapping("/board/listCreate")
    public String boardCreate()throws Exception{
        logger.info("write GET:::::::");
        return "board/listCreate";
    }
    //list 작성실행
    @RequestMapping("/board/listCreateDo")
    public String boardCreateDo(BoardDTO boardDTO , RedirectAttributes redirectAttributes) throws Exception {
        logger.info("listCreateDo:::::::",boardDTO.getContent());
        logger.info(boardDTO.toString());
        boardSerivce.listCreate(boardDTO);
        redirectAttributes.addFlashAttribute("msg","insertSuccess");

        return "redirect:/board/listAll";
    }
    //list 조회
    @RequestMapping("/board/listRead")
    public String boardRead(String bno,Model model)throws Exception{
        logger.info("boardRead:::::::");
        model.addAttribute("boardlist",boardSerivce.listRead(bno));

        return "board/listRead";
    }
    //list 수정페이지 이동
    @RequestMapping("/board/listUpdate")
    public String boardUpdate(String bno,Model model)throws Exception{
        logger.info("boardUpdate:::::::");
        model.addAttribute("boardlist",boardSerivce.listRead(bno));

        return "board/listUpdate";
    }
    //list 수정실행
    @RequestMapping("/board/listUpdateDo")
    public String boardUpdateDo(BoardDTO boardDTO,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("listUpdateDo:::::::");
        boardSerivce.listUpdate(boardDTO);
        redirectAttributes.addFlashAttribute("msg","updateSuccess");

        return "redirect:/board/listAll";
    }
    //list 삭제
    @RequestMapping("/board/listDelete")
    public String boardDelete(String bno,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("listDelete:::::::");
        boardSerivce.listDelete(bno);
        redirectAttributes.addFlashAttribute("msg","deleteSuccess");

        return "redirect:/board/listAll";
    }
}
