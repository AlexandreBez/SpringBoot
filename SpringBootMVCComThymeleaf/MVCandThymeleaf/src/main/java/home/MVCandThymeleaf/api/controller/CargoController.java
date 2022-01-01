package home.MVCandThymeleaf.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.components.Departamento;
import home.MVCandThymeleaf.api.model.service.interfaces.CargoServiceInterface;
import home.MVCandThymeleaf.api.model.service.interfaces.DepartamentoServiceInterface;
import home.MVCandThymeleaf.api.pagination.PaginacaoUtil;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoServiceInterface service;

    @Autowired
    private DepartamentoServiceInterface departamentoService;

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        
        if(service.cargoTemFuncionario(id)){
            model.addAttribute("fail", "Cargo não removido. Possui funcionario(s) vinculado(s).");
        }else{
            service.excluir(id);
            model.addAttribute("sucess", "Cargo removido com sucesso.");
        }

        return lista(model);
    }
    
    @GetMapping("/listar")
    public String lista(ModelMap model, @RequestParam("dir") Optional<String> dir, @RequestParam("page") Optional<Integer> page){

        int paginaAtual = page.orElse(1);
        String ordem = dir.orElse("asc");

        PaginacaoUtil<Cargo> pageCargo = CargoServiceInterface.buscaPagina(paginaAtual, ordem);

        model.addAttribute("pageCargo", pageCargo);
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "/cargo/cadastro";
        }

        service.salvar(cargo);
        attr.addFlashAttribute("sucess", "Cargo inserido com sucesso");
        return "redirect:/cargos/cadastrar";
    }

    @PostMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("cargo", service.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()){
            return "/cargo/cadastro";
        }

        service.editar(cargo);
        attr.addFlashAttribute("sucess", "Cargo editado com sucesso");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model, RedirectAttributes attr){
        model.addAttribute("cargo");
        attr.addFlashAttribute("sucess", "Cargo inserido com sucesso");
        return "/cargo/cadastro";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }
}