import { Component, OnInit } from '@angular/core';

import { Cliente } from 'src/app/clientes/cliente';
import { ClientesService } from 'src/app/clientes.service';
import { ServicoPrestado } from '../servicoPrestado';
import { ServicoPrestadoService } from 'src/app/servico-prestado.service';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[] = [];
  servico: ServicoPrestado;
  sucesso: boolean = false;
  errors?: String[];

  constructor(
    private clientesService: ClientesService,
    private service: ServicoPrestadoService
  ) {
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clientesService
      .getClientes()
      .subscribe(response => this.clientes = response);
  }

  onSubmit() {
    this.service.
    salvar(this.servico)
    .subscribe( response => {
      this.sucesso = true;
      this.errors = [];
      this.servico = new ServicoPrestado();
    }, errorResponse => {
      this.sucesso = false;
      this.errors = errorResponse.error.errors;
    }
    );

  }

}
