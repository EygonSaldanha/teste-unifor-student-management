import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-aluno',
  standalone: true,
  imports: [CommonModule, TableModule, ButtonModule],
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.scss'],
})
export class AlunoComponent {
  students = [
    { id: 1, name: 'João Silva', email: 'joao.silva@example.com' },
    { id: 2, name: 'Maria Oliveira', email: 'maria.oliveira@example.com' },
    { id: 3, name: 'Carlos Santos', email: 'carlos.santos@example.com' },
  ];

  onEdit(studentId: number) {
    console.log('Edit student with ID:', studentId);
    // Adicione a lógica para editar o aluno
  }

  onDelete(studentId: number) {
    console.log('Delete student with ID:', studentId);
    // Adicione a lógica para deletar o aluno
  }

  onAddStudent() {
    console.log('Add new student');
    // Adicione a lógica para adicionar um novo aluno
  }
}