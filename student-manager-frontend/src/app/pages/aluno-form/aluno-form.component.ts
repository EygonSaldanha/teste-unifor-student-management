import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { UsuarioAlunoInterface } from '../../models/UsuarioAlunoInterface';
import { AlunoService } from '../../components/aluno/aluno.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aluno-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    FlexLayoutModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
  ],
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss']
})
export class AlunoFormComponent {
  aluno = {
    nome: '',
    email: '',
    cpf: '',
    matricula: ''
  };

  constructor(private router: Router,private alunoService: AlunoService) {}

  salvar() {
    if (this.aluno.nome && this.aluno.email && this.aluno.cpf && this.aluno.matricula) {
      const dto: UsuarioAlunoInterface = {
        nome: this.aluno.nome,
        email: this.aluno.email,
        cpf: this.aluno.cpf,
        matricula: this.aluno.matricula
      };

      this.alunoService.criarAluno(dto).subscribe({
        next: () => {
          this.router.navigate(['/aluno'] )
        },
        error: (err: any) => {
          console.error('Erro ao criar aluno:', err);
        }
      });
    }
  }

  limpar() {
    this.aluno = {
      nome: '',
      email: '',
      cpf: '',
      matricula: ''
    };
  }
}
