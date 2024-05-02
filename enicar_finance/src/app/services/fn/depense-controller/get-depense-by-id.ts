/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Depense } from '../../models/depense';

export interface GetDepenseById$Params {
  id: number;
}

export function getDepenseById(http: HttpClient, rootUrl: string, params: GetDepenseById$Params, context?: HttpContext): Observable<StrictHttpResponse<Depense>> {
  const rb = new RequestBuilder(rootUrl, getDepenseById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Depense>;
    })
  );
}

getDepenseById.PATH = '/depenses/{id}';
