/* tslint:disable */
/* eslint-disable */
import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationParams } from './api-configuration';

import { SponsorControllerService } from './services/sponsor-controller.service';
import { RevenuControllerService } from './services/revenu-controller.service';
import { RapportControllerService } from './services/rapport-controller.service';
import { FactureControllerService } from './services/facture-controller.service';
import { DepenseControllerService } from './services/depense-controller.service';
import { BudgetControllerService } from './services/budget-controller.service';
import { AuthenticationService } from './services/authentication.service';
import { EventControllerService } from './services/event-controller.service';

/**
 * Module that provides all services and configuration.
 */
@NgModule({
  imports: [],
  exports: [],
  declarations: [],
  providers: [
    SponsorControllerService,
    RevenuControllerService,
    RapportControllerService,
    FactureControllerService,
    DepenseControllerService,
    BudgetControllerService,
    AuthenticationService,
    EventControllerService,
    ApiConfiguration
  ],
})
export class ApiModule {
  static forRoot(params: ApiConfigurationParams): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: params
        }
      ]
    }
  }

  constructor( 
    @Optional() @SkipSelf() parentModule: ApiModule,
    @Optional() http: HttpClient
  ) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
    }
    if (!http) {
      throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
      'See also https://github.com/angular/angular/issues/20575');
    }
  }
}
