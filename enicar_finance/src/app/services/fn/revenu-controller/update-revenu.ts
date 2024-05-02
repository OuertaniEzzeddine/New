/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Revenu } from '../../models/revenu';

export interface UpdateRevenu$Params {
  id: number;
      body: Revenu
}

export function updateRevenu(http: HttpClient, rootUrl: string, params: UpdateRevenu$Params, context?: HttpContext): Observable<StrictHttpResponse<Revenu>> {
  const rb = new RequestBuilder(rootUrl, updateRevenu.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
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

updateRevenu.PATH = '/revenus/{id}';
