/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Rapport } from '../../models/rapport';

export interface CreateRapport$Params {
      body: Rapport
}

export function createRapport(http: HttpClient, rootUrl: string, params: CreateRapport$Params, context?: HttpContext): Observable<StrictHttpResponse<Rapport>> {
  const rb = new RequestBuilder(rootUrl, createRapport.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Rapport>;
    })
  );
}

createRapport.PATH = '/rapports';
