// src/app/app.component.ts
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule], // Importa RouterModule para usar <router-outlet>
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'], // Corrigido de styleUrl para styleUrls
})
export class AppComponent {
  title = 'student-manager-frontend'; // Mantido, mas não será usado diretamente no template
}