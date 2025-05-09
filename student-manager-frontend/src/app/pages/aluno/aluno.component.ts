import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input'
import { MatCardModule } from '@angular/material/card'
import { FlexLayoutModule } from '@angular/flex-layout'
import { MatIconModule } from '@angular/material/icon'
import { FormsModule } from '@angular/forms'
import { MatTableModule } from '@angular/material/table'
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AlunoInterface } from '../../models/AlunoInterface';

@Component({
  selector: 'app-financeiro',
  imports: [
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatTableModule,
    MatButtonModule,
    FlexLayoutModule,
    FormsModule,
    CommonModule
  ],
  templateUrl: './aluno.component.html',
  styleUrl: './aluno.component.scss'
})
export class alunoComponent implements OnInit {

  nomeBusca: string = '';
  listaAlunos: AlunoInterface[] = [];
  colunasTable: string[] = ["id", "matricula", "nome", "acoes"];
  
  snack: MatSnackBar = inject(MatSnackBar);

  constructor(
    private router: Router,
    private http: HttpClient
  ){ }

  ngOnInit() {
    this.http.get<AlunoInterface[]>('http://localhost:8089/unifor/alunos')
      .subscribe({
        next: (res) => this.listaAlunos = res,
        error: (err) => this.snack.open('Erro ao carregar alunos', '', { duration: 3000 })
      });
  }

  onSquareButtonClick(): void {
    this.router.navigate(['/aluno-form'] )
  }

  excluirAluno(id: number): void {
    if (confirm("Tem certeza que deseja excluir este aluno?")) {
      this.http.delete(`http://localhost:8089/unifor/alunos/${id}`)
        .subscribe({
          next: () => {
            this.snack.open("Aluno excluído com sucesso!", "", { duration: 3000 });
            this.listaAlunos = this.listaAlunos.filter(aluno => aluno.id !== id);
          },
          error: () => {
            this.snack.open("Erro ao excluir aluno.", "", { duration: 3000 });
          }
        });
    }
  }

}
