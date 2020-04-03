package kr.kim.controller;

import kr.kim.dto.BoardDTO;
import kr.kim.dto.Page;
import kr.kim.dto.Pagination;
import kr.kim.dto.SearchOption;
import kr.kim.service.SearchBoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;


@Controller
public class SearchBoardController {
    private final Logger logger= LoggerFactory.getLogger(SearchBoardController.class);
    private final SearchBoardServiceImpl searchBoardService;
    @Inject
    public SearchBoardController(SearchBoardServiceImpl searchBoardService){
        this.searchBoardService = searchBoardService;
    }

    //list 목록
    @RequestMapping("/search/listAll")
    public String boardList(Model model, @ModelAttribute("searchOption")SearchOption searchOption) throws Exception {
        logger.info("SearchBoardController listAll:::::::");
        Pagination pagination= new Pagination();
        pagination.setPage(searchOption);
        pagination.setTotalCount(searchBoardService.countSearched(searchOption));
        model.addAttribute("boardlist", searchBoardService.listSearch(searchOption));
        model.addAttribute("pagination",pagination);
     return "search/listAll";
    }
    //list
    // 작성페이지
    @RequestMapping("/search/listCreate")
    public String boardCreate()throws Exception{
        logger.info("SearchBoardController write GET:::::::");
        return "search/listCreate";
    }
    //list 작성실행
    @RequestMapping("/search/listCreateDo")
    public String boardCreateDo(BoardDTO boardDTO , RedirectAttributes redirectAttributes) throws Exception {
        logger.info("SearchBoardController listCreateDo:::::::");
        logger.info(boardDTO.toString());
        searchBoardService.listCreate(boardDTO);
        redirectAttributes.addFlashAttribute("msg","insertSuccess");

        return "redirect:/search/listAll";
    }
    //list 조회
    @RequestMapping("/search/listRead")
    public String boardRead(String bno, @ModelAttribute ("searchOption") SearchOption searchOption, Model model)throws Exception{
        logger.info("SearchBoardController boardRead:::::::");
        model.addAttribute("boardlist", searchBoardService.listRead(bno));

        return "search/listRead";
    }
    //list 수정페이지 이동
    @RequestMapping("/search/listUpdate")
    public String boardUpdate(String bno,@ModelAttribute ("searchOption")SearchOption searchOption,Model model)throws Exception{
        logger.info("SearchBoardController boardUpdate:::::::");
        logger.info(searchOption.toString());
        model.addAttribute("boardlist", searchBoardService.listRead(bno));

        return "search/listUpdate";
    }
    //list 수정실행
    @RequestMapping("/search/listUpdateDo")
    public String boardUpdateDo(BoardDTO boardDTO,SearchOption searchOption,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("SearchBoardController listUpdateDo:::::::");
        searchBoardService.listUpdate(boardDTO);
        redirectAttributes.addAttribute("currentPage",searchOption.getCurrentPage());
        redirectAttributes.addAttribute("pageSize",searchOption.getPageSize());
        redirectAttributes.addAttribute("searchType",searchOption.getSearchType());
        redirectAttributes.addAttribute("keyword",searchOption.getKeyword());
        redirectAttributes.addFlashAttribute("msg","updateSuccess");

        return "redirect:/search/listAll";
    }
    //list 삭제
    @RequestMapping("/search/listDelete")
    public String boardDelete(String bno,SearchOption searchOption,RedirectAttributes redirectAttributes)throws Exception{
        logger.info("SearchBoardController listDelete:::::::");
        searchBoardService.listDelete(bno);
        redirectAttributes.addAttribute("currentPage",searchOption.getCurrentPage());
        redirectAttributes.addAttribute("pageSize",searchOption.getPageSize());
        redirectAttributes.addAttribute("searchType",searchOption.getSearchType());
        redirectAttributes.addAttribute("keyword",searchOption.getKeyword());
        redirectAttributes.addFlashAttribute("msg","deleteSuccess");

        return "redirect:/search/listAll";
    }
}
