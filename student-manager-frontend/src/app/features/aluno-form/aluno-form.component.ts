import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { AlunoService } from '../../service/aluno/aluno.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-aluno-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, ButtonModule],
  providers: [MessageService],
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss'],
})
export class AlunoFormComponent {
  alunoForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private alunoService: AlunoService,
    private messageService: MessageService,
    private router: Router
  ) {
    this.alunoForm = this.fb.group({
      usuario: this.fb.group({
        matricula: ['', Validators.required],
        nome: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        cpf: ['', Validators.required],
        cargo: ['ALUNO', Validators.required],
        status: [true, Validators.required],
      }),
    });
  }

  onSubmit() {
    
    if (this.alunoForm.valid) {
      this.alunoService.addAluno(this.alunoForm.value).subscribe({
        next: () => {
          this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Aluno salvo com sucesso!' });
          this.router.navigate(['/aluno']);
        },
        error: () => {
          this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao salvar o aluno.' });
        },
      });
    } else {
      this.messageService.add({ severity: 'warn', summary: 'Atenção', detail: 'Preencha todos os campos obrigatórios.' });
    }
  }
}