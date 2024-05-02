/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Facture } from '../../models/facture';

export interface UpdateFacture$Params {
  id: number;
      body: Facture
}

export function updateFacture(http: HttpClient, rootUrl: string, params: UpdateFacture$Params, context?: HttpContext): Observable<StrictHttpResponse<Facture>> {
  const rb = new RequestBuilder(rootUrl, updateFacture.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Facture>;
    })
  );
}

updateFacture.PATH = '/factures/{id}';
