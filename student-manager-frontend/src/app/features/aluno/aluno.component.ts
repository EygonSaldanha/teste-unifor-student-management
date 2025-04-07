import { Component, inject, Inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { AlunoService } from '../../service/aluno/aluno.service';
import { Aluno } from '../../shered/models/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aluno',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule, ToastModule, ConfirmDialogModule],
  providers: [MessageService, ConfirmationService],
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss'],
})
export class AlunoComponent {
  protected alunos = signal<Aluno[]>([]); 
 
  private alunoService = inject(AlunoService);
  private messageService = inject(MessageService);
  private confirmationService = inject(ConfirmationService);

  constructor(private router: Router ) {}

  ngOnInit() {
    this.loadAlunos();
  }

  loadAlunos() {
    this.alunoService.getAlunos().subscribe({
      next: (data) => {
        this.alunos.set(data);
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Alunos carregados com sucesso' });
      },
      error: (err) => this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao carregar alunos' }),
    });
  }
  
  onAddAluno() {
    this.router.navigate(['/aluno-form']);   
  }

  confirmDelete(aluno: any) {
    this.confirmationService.confirm({
      message: `Tem certeza que deseja excluir o aluno ${aluno.name}?`,
      header: 'Confirmação',
      accept: () => {
        this.deleteAlunoMensage(aluno);
      },
      reject: () => {
        this.messageService.add({ severity: 'info', summary: 'Cancelado', detail: 'Ação de exclusão cancelada' });
      },
    });
  }

  deleteAlunoMensage(aluno: any) {
    this.alunoService.deleteAluno(aluno.id).subscribe({
      next: (data) => {
        this.alunos.set(this.alunos().filter(s => s.id !== aluno.id));
        this.messageService.add({ severity: 'success', summary: 'Excluído', detail: `Aluno ${aluno.name} foi excluído` });
      },
      error: (err) => this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Erro ao deletar alunos' }),
    });
  }
}