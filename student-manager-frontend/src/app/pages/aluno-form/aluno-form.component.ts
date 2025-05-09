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

@Component({
  selector: 'app-aluno-form',
  imports: [
    FlexLayoutModule, 
    MatCardModule, 
    FormsModule, 
    MatFormFieldModule, 
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    CommonModule,
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

  salvar() {
    
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
