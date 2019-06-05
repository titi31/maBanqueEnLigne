package co.simplon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.simplon.entities.Account;
import co.simplon.entities.Operation;
import co.simplon.metier.IBanqueMetier;

@Controller
public class BanqueController {
	@Autowired
	private IBanqueMetier banqueMetier;
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	@RequestMapping("/consulterCompte")
	public String consulter(Model model ,long codeAccount,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		model.addAttribute("codeAccount",codeAccount);
		try {
			Account cp=banqueMetier.consulterCompte(codeAccount);
			Page<Operation> pageOperations=banqueMetier.listOperations(codeAccount, page, size);
			model.addAttribute("listOperations",pageOperations.getContent());
			int[] pages=new int[pageOperations.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("compte",cp);
			
		}catch(Exception e) {
			model.addAttribute("exception",e);
		}
		
		
		return "comptes";
	}
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,long codeAccount,double montant,long codeAccount2) {
		
		try {
			if(typeOperation.contentEquals("VERS")) {
				
				banqueMetier.verser(codeAccount, montant);
			}
			else if (typeOperation.contentEquals("RET")) {
				
				banqueMetier.retirer(codeAccount, montant);
			}
			else if (typeOperation.contentEquals("VIR")) {
				banqueMetier.virement(codeAccount,codeAccount2, montant);
			}
		}catch(Exception e) {
			model.addAttribute("error",e);
			return "redirect:/consulterCompte?codeAccount="+codeAccount+"&error="+e.getMessage();
		}
		
		return "redirect:/consulterCompte?codeAccount="+codeAccount;
	}
	
}
