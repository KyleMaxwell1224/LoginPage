// @ts-ignore
import {Flow} from '@vaadin/flow-frontend/Flow';
import {Router} from '@vaadin/router';

const {serverSideRoutes} = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports')
});

const routes = [
  // fallback to server-side Flow routes if no client-side routes match
  ...serverSideRoutes
];

const router = new Router(document.querySelector('#outlet'));
router.setRoutes(routes);
