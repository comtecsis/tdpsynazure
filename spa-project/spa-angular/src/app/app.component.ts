
import { AuthenticationResult } from '@azure/msal-browser';
import { MsalService } from '@azure/msal-angular';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'My Microsoft Login- Example';
  loginIsPopUp = true;

  constructor(private authService: MsalService) {

  }

  onSucessLogin = ( response: AuthenticationResult ) => {
      this.authService.instance.setActiveAccount(response?.account);
      console.log("Token de acceso: " + response?.accessToken);
  }

  ngOnInit(): void {
    if(!this.loginIsPopUp) {
      this.authService.instance.handleRedirectPromise().then(this.onSucessLogin);
    }
  }

  isLoggedIn(): boolean {
    return this.authService.instance.getActiveAccount() != null
  }

  login() {
    if(this.loginIsPopUp) {
      this.authService.loginPopup({scopes: ["openid", "offline_access", "https://tdpsynopsis.onmicrosoft.com/ec5845d9-1d86-4da3-aecc-ed981b1d1dcb/Read"]})
        .subscribe(( response: AuthenticationResult ) => {
          if(response != null) {
            this.authService.instance.setActiveAccount(response.account);
            console.log("Token de acceso: " + response.accessToken);
          }
        });
    }else{
      this.authService.loginRedirect({scopes: ["openid", "offline_access", "https://tdpsynopsis.onmicrosoft.com/ec5845d9-1d86-4da3-aecc-ed981b1d1dcb/Read"]});
    }
  }

  logout() {
    this.authService.logout()
  }
}
