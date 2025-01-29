import { NgIf } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'product-filter',
  standalone: true,
  imports: [NgIf],
  templateUrl: './product-filter.component.html',
  styleUrl: './product-filter.component.css'
})
export class ProductFilterComponent {

  @Output() filterChanged = new EventEmitter<any>();
  showFilters: boolean = false;
  searchQuery: string = '';
  minPrice: number | null = null;
  maxPrice: number | null = null;
  selectedSort: string = '';

  toggleFilters() {
    this.showFilters = !this.showFilters;
  }

  onSearch(event: Event) {
    this.searchQuery = (event.target as HTMLInputElement).value;
  }

  onMinPriceChange(event: Event) {
    this.minPrice = +(event.target as HTMLInputElement).value;
  }

  onMaxPriceChange(event: Event) {
    this.maxPrice = +(event.target as HTMLInputElement).value;
  }

  onSortChange(event: Event) {
    this.selectedSort = (event.target as HTMLSelectElement).value;
  }

  applyFilters() {
    this.filterChanged.emit({
      searchQuery: this.searchQuery,
      minPrice: this.minPrice,
      maxPrice: this.maxPrice,
      sort: this.selectedSort
    });
  }

}
