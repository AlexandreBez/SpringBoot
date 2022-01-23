var variavel: number = 10;
var variavel2: string = "afsad";
var variavel3: boolean = true;
var variavel4: String[] = ['A', 'B'];

class Pessoa {

    constructor(public nome: string, public idade: string){}

    imprimirNome(){
        console.log(this.nome);
    }
}

let pessoa: Pessoa = new Pessoa("Joao", "20");

pessoa.imprimirNome();