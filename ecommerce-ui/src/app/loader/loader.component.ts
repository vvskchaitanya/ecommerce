import { Component } from '@angular/core';
import { LoaderService } from './loader.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-loader',
  standalone: true,
  imports: [NgIf],
  templateUrl: './loader.component.html',
  styleUrl: './loader.component.css'
})
export class LoaderComponent {

  loading: boolean = false;

  constructor(private loaderService: LoaderService) {}

  ngOnInit(): void {
    this.loaderService.loading$.subscribe((isLoading) => {
      this.loading = isLoading;
    });
  }

}
