// aluno.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment.development';
import { UsuarioAlunoInterface } from '../../models/UsuarioAlunoInterface';

export interface Usuario {
  nome: string;
  email: string;
  cpf: string;
}

export interface AlunoComUsuario {
  id: number;
  matricula: string;
  usuario: Usuario;
}

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  private readonly API_URL = environment.api + '/alunos';

  constructor(private http: HttpClient) {}

  buscarAlunoComUsuarioPorId(id: number): Observable<AlunoComUsuario> {
    return this.http.get<AlunoComUsuario>(`${this.API_URL + "/usuario"}/${id}`);
  }
  criarAluno(dto: UsuarioAlunoInterface): Observable<UsuarioAlunoInterface> {
    return this.http.post<UsuarioAlunoInterface>('/api/usuario', dto);
  }
}
