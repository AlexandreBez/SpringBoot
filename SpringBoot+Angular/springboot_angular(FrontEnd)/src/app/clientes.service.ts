import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiURL: string = environment.apiURL;

  constructor(private http: HttpClient ) {

  }

  salvar( cliente: Cliente ) : Observable<Cliente>{
    return this.http.post<Cliente>(`${this.apiURL}/api/clientes`, cliente);
  }

  atualizar( cliente: Cliente ) : Observable<Cliente>{
    return this.http.put<Cliente>(`${this.apiURL}/api/clientes/${cliente.id}`, cliente);
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.apiURL);
  }

  getClienteById(id: number) : Observable<Cliente>{
    return this.http.get<any>(`${this.apiURL}/api/clientes/${id}`);
  }

  deletar(cliente: Cliente) : Observable<any>{
    return this.http.delete<any>(`${this.apiURL}/api/clientes/${cliente.id}`);
  }
}
