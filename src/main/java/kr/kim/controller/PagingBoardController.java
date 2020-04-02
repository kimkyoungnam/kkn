package kr.kim.controller;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.Pagination;
import kr.kim.service.BoardServiceImpl;
import kr.kim.service.PageBoardService;
import kr.kim.service.PageBoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;


@Controller
public class PagingBoardController {
    private final Logger logger= LoggerFactory.getLogger(PagingBoardController.class);
    private final PageBoardServiceImpl boardSerivce;
    @Inject
    public PagingBoardController(PageBoardServiceImpl boardSerivce){
        this.boardSerivce=boardSerivce;
    }

    //list 목록
    @RequestMapping("/paging/listAll")
    public String boardList(Model model, Page page) throws Exception {
        logger.info("listAll:::::::");
        Pagination pagination= new Pagination();
        pagination.setPage(page);
        pagination.setTotalCount(boardSerivce.listTotalCount(page));
        model.addAttribute("boardlist",boardSerivce.listAll(page));
        model.addAttribute("pagination",pagination);
     return "paging/listAll";
    }
    //list
    // 작성페이지
    @RequestMapping("/paging/listCreate")
    public String boardCreate()throws Exception{
        logger.info("write GET:::::::");
        return "paging/listCreate";
    }
    //list 작성실행
    @RequestMapping("/paging/listCreateDo")
    public String boardCreateDo(BoardDTO boardDTO , RedirectAttributes redirectAttributes) throws Exception {
        logger.info("listCreateDo:::::::");
        logger.info(boardDTO.toString());
        boardSerivce.listCreate(boardDTO);
        redirectAttributes.addFlashAttribute("msg","insertSuccess");

        return "redirect:/paging/listAll";
    }
    //list 조회
    @RequestMapping("/paging/listRead")
    public String boardRead(String bno, @ModelAttribute ("page") Page page, Model model)throws Exception{
        logger.info("boardRead:::::::");
        model.addAttribute("boardlist",boardSerivce.listRead(bno));

        return "paging/listRead";
    }
    //list 수정페이지 이동
    @RequestMapping("/paging/listUpdate")
    public String boardUpdate(String bno,@ModelAttribute ("page")Page page,Model model)throws Exception{
        logger.info("boardUpdate:::::::");

        model.addAttribute("boardlist",boardSerivce.listRead(bno));

        return "paging/listUpdate";
    }
    //list 수정실행
    @RequestMapping("/paging/listUpdateDo")
    public String boardUpdateDo(BoardDTO boardDTO,Page page,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("listUpdateDo:::::::");
        boardSerivce.listUpdate(boardDTO);
        redirectAttributes.addAttribute("currentPage",page.getCurrentPage());
        redirectAttributes.addAttribute("pageSize",page.getPageSize());
        redirectAttributes.addFlashAttribute("msg","updateSuccess");

        return "redirect:/paging/listAll";
    }
    //list 삭제
    @RequestMapping("/paging/listDelete")
    public String boardDelete(String bno,Page page,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("listDelete:::::::");
        boardSerivce.listDelete(bno);
        redirectAttributes.addAttribute("currentPage",page.getCurrentPage());
        redirectAttributes.addAttribute("pageSize",page.getPageSize());
        redirectAttributes.addFlashAttribute("msg","deleteSuccess");

        return "redirect:/paging/listAll";
    }
}
