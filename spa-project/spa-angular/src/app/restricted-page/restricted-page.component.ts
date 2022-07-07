import { MsalService } from '@azure/msal-angular';
import { Component, OnInit } from '@angular/core';
import { InteractionRequiredAuthError } from 'msal';

@Component({
  selector: 'app-restricted-page',
  templateUrl: './restricted-page.component.html',
  styleUrls: ['./restricted-page.component.css']
})
export class RestrictedPageComponent implements OnInit {

  constructor(private authService: MsalService) { }

  getName () : string {
    if (this.authService.instance.getActiveAccount() == null) {
      return 'unknown'
    }

    return this.authService.instance.getActiveAccount().name
  }

  callApi = (accessToken) => {
    console.log(accessToken);
  }

  ngOnInit(): void {
  }

}

