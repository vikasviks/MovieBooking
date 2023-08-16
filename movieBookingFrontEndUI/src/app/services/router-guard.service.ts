import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RouterGuardService implements CanActivate {

  constructor(private routObj: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean  {

    alert("you cannot access this component without login!");
    this.routObj.navigate(['/login']);
    return false;
  }
}
