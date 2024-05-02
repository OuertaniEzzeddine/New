/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Sponsor } from '../../models/sponsor';

export interface GetSponsorById$Params {
  id: number;
}

export function getSponsorById(http: HttpClient, rootUrl: string, params: GetSponsorById$Params, context?: HttpContext): Observable<StrictHttpResponse<Sponsor>> {
  const rb = new RequestBuilder(rootUrl, getSponsorById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
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

getSponsorById.PATH = '/sponsors/{id}';
