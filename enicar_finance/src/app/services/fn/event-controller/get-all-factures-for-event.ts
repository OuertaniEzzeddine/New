/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FactureDto } from '../../models/facture-dto';

export interface GetAllFacturesForEvent$Params {
  id: number;
}

export function getAllFacturesForEvent(http: HttpClient, rootUrl: string, params: GetAllFacturesForEvent$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FactureDto>>> {
  const rb = new RequestBuilder(rootUrl, getAllFacturesForEvent.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<FactureDto>>;
    })
  );
}

getAllFacturesForEvent.PATH = '/api/events/{id}/factures';
