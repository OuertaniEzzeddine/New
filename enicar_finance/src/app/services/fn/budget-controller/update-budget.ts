/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Budget } from '../../models/budget';

export interface UpdateBudget$Params {
  id: number;
      body: Budget
}

export function updateBudget(http: HttpClient, rootUrl: string, params: UpdateBudget$Params, context?: HttpContext): Observable<StrictHttpResponse<Budget>> {
  const rb = new RequestBuilder(rootUrl, updateBudget.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Budget>;
    })
  );
}

updateBudget.PATH = '/budgets/{id}';
