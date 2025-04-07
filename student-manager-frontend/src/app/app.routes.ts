import { Routes } from '@angular/router';
import { LoginComponent } from './features/login/login.component';
import { MenuComponent } from './features/menu/menu.component';
import { PrivateRoutesComponent } from './shered/templates/privateRoutes/privateRoutes.component';
import { AlunoComponent } from './features/aluno/aluno.component';
import { AlunoFormComponent } from './features/aluno-form/aluno-form.component';

export const routes: Routes = [
  {path: '', component: PrivateRoutesComponent, children: [ 
      { path: 'menu',  component: MenuComponent },
      { path: 'aluno',  component: AlunoComponent },
      { path: 'aluno-form', component: AlunoFormComponent },
    ]
  },
  { path: 'login',  component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },
];