import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CartService } from '../services/cart.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [FormsModule, NgFor, NgIf],
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css'
})
export class PaymentComponent {
  totalAmount: number = 0;
  selectedBank: string = '';
  cardDetails = {
    number: '',
    expiry: '',
    cvv: ''
  };
  selectedUPI: string = '';
  customUPIID: string = '';
  upiApps = ['Google Pay', 'PhonePe', 'Paytm'];
  banks = ['HDFC Bank', 'ICICI Bank', 'SBI Bank', 'Axis Bank'];
  activeSection: string = 'banking';

  constructor(private cart:CartService){
    this.totalAmount = this.cart.payment.price;
  }
  
  setActiveSection(section: string) {
    this.activeSection = section;
  }
  
  isBankingValid(): boolean {
    return this.selectedBank !== '';
  }
  
  isCardValid(): boolean {
    return this.cardDetails.number.length === 16 && this.cardDetails.expiry.length === 5 && this.cardDetails.cvv.length === 3;
  }
  
  isUPIValid(): boolean {
    return this.selectedUPI !== '' && (this.selectedUPI !== 'custom' || this.customUPIID.includes('@'));
  }
}
