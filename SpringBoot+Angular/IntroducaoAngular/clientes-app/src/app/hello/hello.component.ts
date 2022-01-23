import { Component } from '@angular/core'

@Component({
    selector: 'hello',
    template: './hello.component.html'
})
export class HelloComponent {

    nome: string;
    clientes: Cliente[];

    constructor(){
        this.nome = 'Lucas';

        let fulano = new Cliente('Fulano', 20);
        let cicrano = new Cliente('Cicrano', 20);
        
        this.clientes = [fulano, cicrano];
    }
}

class Cliente {

    constructor(
        public nome: string,
        public idade: number
    ){}
}