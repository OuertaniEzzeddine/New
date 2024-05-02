/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Sponsor } from '../../models/sponsor';

export interface UpdateSponsor$Params {
  id: number;
      body: Sponsor
}

export function updateSponsor(http: HttpClient, rootUrl: string, params: UpdateSponsor$Params, context?: HttpContext): Observable<StrictHttpResponse<Sponsor>> {
  const rb = new RequestBuilder(rootUrl, updateSponsor.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Sponsor>;
    })
  );
}

updateSponsor.PATH = '/sponsors/{id}';
