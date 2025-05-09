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
  colunasTable: string[] = ["id", "matricula", "Nome"];
  
  snack: MatSnackBar = inject(MatSnackBar);

  constructor(
    private router: Router,
    private http: HttpClient
  ){ }

  ngOnInit() {
  }

  onSquareButtonClick(): void {
    this.router.navigate(['/aluno-form'] )

  }

  preparaEditar(id: string){
    this.router.navigate(['/cadastro'], { queryParams: { "id": id } } )
  }

}
