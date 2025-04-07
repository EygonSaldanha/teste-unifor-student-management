import { Component } from '@angular/core';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { HeaderComponent } from '../../components/header/header.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-private-routes',
  standalone: true,
  imports: [HeaderComponent,RouterModule],
  templateUrl: './privateRoutes.component.html',
  styleUrls: ['./privateRoutes.component.scss'],
})

export class PrivateRoutesComponent {
  sidebarVisible: boolean = false;
}