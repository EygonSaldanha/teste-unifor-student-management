import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderComponent } from '../../shered/components/header/header.component';

@Component({
  selector: 'app-menu',
  imports: [],
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent {
  constructor(private router: Router) {}

  navigateTo(page: string) {
    this.router.navigate([`/${page}`]);
  }
}
