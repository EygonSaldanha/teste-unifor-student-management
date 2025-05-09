import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AuthService } from '../../components/auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    FlexLayoutModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  isRegisterMode = false;

  nome = '';
  endereco = '';
  email = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  toggleMode(): void {
    this.isRegisterMode = !this.isRegisterMode;
  }

  onSubmit(): void {
      const payload = {
        email: this.email,
        senha: this.password
      };

      this.authService.login(payload).subscribe({
        next: (response) => {
          localStorage.setItem('jwtToken', response.token);
          this.router.navigate(['/']);
        },
        error: (err) => {
          console.error('Erro ao fazer login:', err);
          alert('Erro ao fazer login. Verifique suas credenciais.');
        }
      });
    }
}
