/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Facture } from '../../models/facture';

export interface GetAllFactures$Params {
}

export function getAllFactures(http: HttpClient, rootUrl: string, params?: GetAllFactures$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Facture>>> {
  const rb = new RequestBuilder(rootUrl, getAllFactures.PATH, 'get');
  if (params) {
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<Facture>>;
    })
  );
}

getAllFactures.PATH = '/factures';
