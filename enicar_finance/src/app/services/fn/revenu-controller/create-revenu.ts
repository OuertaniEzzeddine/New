/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Revenu } from '../../models/revenu';

export interface CreateRevenu$Params {
      body: Revenu
}

export function createRevenu(http: HttpClient, rootUrl: string, params: CreateRevenu$Params, context?: HttpContext): Observable<StrictHttpResponse<Revenu>> {
  const rb = new RequestBuilder(rootUrl, createRevenu.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Revenu>;
    })
  );
}

createRevenu.PATH = '/revenus';
