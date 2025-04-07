// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { DashboardComponent } from './features/dashboard/dashboard.component';
import { AuthGuard } from './core/auth/guard/auth.guard';
import { LoginComponent } from './features/login/login.component';
import { MenuComponent } from './features/menu/menu.component';
import { PrivateRoutesComponent } from './shered/templates/privateRoutes/privateRoutes.component';
import { AlunoComponent } from './features/aluno/aluno.component';

export const routes: Routes = [
  {path: '', component: PrivateRoutesComponent, children: [ 
      { path: 'menu',  component: MenuComponent },
      { path: 'aluno',  component: AlunoComponent }
    ]
  },
  { path: 'login',  component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },
];