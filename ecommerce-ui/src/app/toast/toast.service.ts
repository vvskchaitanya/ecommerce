import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export interface Toast {
  type: 'success' | 'error' | 'warning';
  title: string;
  message: string;
  id: number;
}

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  private toastSubject = new Subject<Toast>();
  private toastId = 0;
  
  // Expose the observable to be subscribed by the component
  toast$ = this.toastSubject.asObservable();

  showSuccess(title: string, message: string) {
    this.showToast('success', title, message);
  }

  showError(title: string, message: string) {
    this.showToast('error', title, message);
  }

  showWarning(title: string, message: string) {
    this.showToast('warning', title, message);
  }

  private showToast(type: 'success' | 'warning' | 'error', title: string, message: string) {
    const toast: Toast = {
      type,
      title,
      message,
      id: this.toastId++
    };
    this.toastSubject.next(toast);
  }
}
