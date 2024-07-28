import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  let user = undefined;
  let userObj = sessionStorage.getItem("user");
  if(userObj!=null){
    user = JSON.parse(userObj);
  }
  if(state.url.indexOf("admin")>-1 && user.role!="ADMIN"){
    let router = inject(Router);
    router.navigate(['/unauthorized']);
    return false;
  }
  return true;
};
