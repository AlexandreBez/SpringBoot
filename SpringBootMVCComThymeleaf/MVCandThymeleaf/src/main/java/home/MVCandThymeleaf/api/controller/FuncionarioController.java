package home.MVCandThymeleaf.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.components.Funcionario;
import home.MVCandThymeleaf.api.model.components.UFEnum;
import home.MVCandThymeleaf.api.model.service.interfaces.CargoServiceInterface;
import home.MVCandThymeleaf.api.model.service.interfaces.FuncionarioServiceInterface;
import home.MVCandThymeleaf.api.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceInterface service;

    @Autowired
    private CargoServiceInterface cargoService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new FuncionarioValidator());
    }
    
    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario){
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String lista(){
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr){
        service.salvar(funcionario);
        attr.addFlashAttribute("sucess", "Funcionario inserido com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("funcionario", service.buscarPorId(id));
        System.out.println(id);
        return "/funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr){
        service.editar(funcionario);
        attr.addFlashAttribute("sucess", "Funcionario editado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        service.excluir(id);
        attr.addFlashAttribute("sucess", "Funcionario removido com sucesso.");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("funcionario", service.buscarPorNome(nome));
        return "/funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model){
        model.addAttribute("funcionario", service.buscarPorCargo(id));
        return "/funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }

    @GetMapping("/buscar/data")
    public String getPorDatas(  @RequestParam(name = "Entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada, 
                                @RequestParam(name = "Saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                                ModelMap model)
    {
        model.addAttribute("funcionarios", FuncionarioServiceInterface.buscarPorDatas(entrada, saida));                            
        return "/funcionario/lista";
    }

    @ModelAttribute("ufs")
    public UFEnum[] getUFs(){
        return UFEnum.values();
    }

}