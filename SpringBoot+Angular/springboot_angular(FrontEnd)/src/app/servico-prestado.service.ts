import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ServicoPrestado } from './servico-prestado/servicoPrestado';

@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {

  apiUrl: string = environment.apiURL + "/api/servicos-prestados";

  constructor(
    private http: HttpClient
  ) {

  }

  salvar(servicoPrestado: ServicoPrestado) : Observable<ServicoPrestado>{
    return this.http.post<ServicoPrestado>(this.apiUrl, servicoPrestado);
  }
}
