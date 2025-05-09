import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { HeaderLayoutComponent } from './components/header-layout/header-layout.component';
import { LoginComponent } from './pages/login/login.component';
import { alunoComponent } from './pages/aluno/aluno.component';
import { authGuard } from '../guards/auth.guard';
import { AlunoFormComponent } from './pages/aluno-form/aluno-form.component';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    {
      path: '',
      component: HeaderLayoutComponent,
      children: [
        { path: 'home', canActivate: [authGuard],component: HomeComponent },
        { path: 'aluno', canActivate: [authGuard], component: alunoComponent },
        { path: 'aluno-form', canActivate: [authGuard], component: AlunoFormComponent },
        { path: '', redirectTo: '/home', pathMatch: 'full' }
      ]
    }
  ]
