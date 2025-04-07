import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment.development';
import { Aluno } from '../../shered/models/usuario';


@Injectable({
  providedIn: 'root',
})
export class AlunoService {
  private baseUrl = environment.api + '/alunos';

  constructor(private http: HttpClient) {}

  getAlunos(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(this.baseUrl + '/usuario');
  }

  addAluno(aluno: Aluno): Observable<Aluno> {
    console.log(aluno);
    
    return this.http.post<Aluno>(this.baseUrl, aluno.usuario);
  }

  updateAluno(aluno: Aluno): Observable<Aluno> {
    return this.http.put<Aluno>(`${this.baseUrl}/${aluno.id}`, aluno);
  }

  deleteAluno(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}