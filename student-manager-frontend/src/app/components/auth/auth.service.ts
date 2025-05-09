import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { decodeToken } from '../../../utils/jwt.util';
import { environment } from '../../environment/environment.development';

interface LoginRequest {
    email: string;
    senha: string;
  }
  
  interface RegisterRequest {
    nome: string;
    endereco: string;
    email: string;
    senha: string;
  }
  
  interface AuthResponse {
    token: string;
  }

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = environment.api + '/auth';

  constructor(private http: HttpClient) {}

  login(payload: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.apiUrl}/login`, payload);
  }

  logout(): void {
    localStorage.removeItem('jwtToken');
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('jwtToken');
  }

  getUserRoles(): string[] {
    const decoded = decodeToken();
    return decoded?.roles || [];
  }

  getToken(): string | null {
    return localStorage.getItem('jwtToken');
  }
}
