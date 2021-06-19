package br.com.covid19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class CovidController {

    @GetMapping("/")
    public String welcome(){
        String welcome = "API de estatísticas da covid-19.\n\n" +
                "Essa API tem como finalidade mapear os casos de covid-19 na cidade através de pesquisas.\n" +
                "Dessa forma é possível que a gestão da cidade tome as devidas providências para melhorar o quadro " +
                "de acordo com nossas estatísticas.\n\n" +
                "Caminhos da aplicação:\n\n" +
                "/occupation   -  referente a uma lista de profissões utilizadas na pesquisa.\n" +
                "/occupation/     -  lista todas as profissões cadastradas. GET\n" +
                "/occupation/{id}     -  mostra a profissão com id especificado. GET\n" +
                "/occupation/register     -  registra uma nova profissão.POST\n" +
                "/occupation/edit     -  edita uma profissão já cadastrada.PUT\n " +
                "/occupation/delete/{id}     -  deleta uma profissão já cadastrada. DELETE\n\n" +
                "/district   -  referente a uma lista de bairros utilizados na pesquisa.\n" +
                "/district/     -  lista todos os bairros cadastrados. GET\n" +
                "/district/{id}     -  mostra o bairro com id especificado. GET\n" +
                "/district/register     -  registra um novo bairro. POST\n " +
                "/district/edit     -  edita um bairro já cadastrado. PUT\n" +
                "/district/delete/{id}     -  deleta um bairro já cadastrado. DELETE\n\n" +
                "Objetos da pesquisa:\n\n" +
                "Bairro = {\n" +
                "   \"id\" = inteiro\n" +
                "   \"name\" = \"string\"\n" +
                "}\n" +
                "Profissão = {\n" +
                "   \"id\" = inteiro\n" +
                "   \"name\" = \"string\"\n" +
                "}";

        return welcome;
    }

}
