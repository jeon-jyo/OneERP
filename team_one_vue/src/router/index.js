import { createRouter, createWebHistory } from "vue-router";
import Dashboard from "@/views/Dashboard.vue";
import Tables from "@/views/Tables.vue";
import Billing from "@/views/FinanceTables.vue";
import VirtualReality from "@/views/HRTables.vue";
import Depts from "@/views/DeptTables.vue";
import Profile from "@/views/LogisicsTables.vue";
import Rtl from "@/views/SalesTables.vue";
import Purchase from "@/views/PurchaseTables.vue";
import Order from "@/views/OrderTables.vue";
import SignIn from "@/views/SignIn.vue";
import SignUp from "@/views/SignUp.vue";

import Release from "@/views/Release.vue";
import Warehousing from "@/views/Warehousing.vue";
import Arrival from "@/views/Arrival.vue";

import Income from "@/views/IncomeTables.vue";

import Commute from "@/views/Commute.vue";

const routes = [
  {
    path: "/",
    name: "/",
    redirect: "/dashboard",
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: Dashboard,
  },
  {
    path: "/tables",
    name: "temp",
    component: Tables,
  },
  {
    path: "/billing",
    name: "Finance",
    component: Billing,
  },
  {
    path: "/virtual-reality",
    name: "Hr",
    component: VirtualReality,
  },
  {
     path: "/deptlist",
     name: "Dept",
     component: Depts,
   }, 
  {
    path: "/profile",
    name: "Logisics",
    component: Profile,
  },
  {
    path: "/rtl-page",
    name: "Sales",
    component: Rtl,
  },
  {
    path: "/sign-in",
    name: "Sign In",
    component: SignIn,
  },
  {
    path: "/purchase",
    name: "Purchase",
    component: Purchase,
  },
  {
    path: "/orders",
    name: "OrderTable",
    component: Order,
  }, 
  {
    path: "/sign-up",
    name: "Sign Up",
    component: SignUp,
  },
  {
    path: "/release",
    name: "Release",
    component: Release,
  },
  {
    path: "/warehousing",
    name: "Warehousing",
    component: Warehousing,
  },
  {
    path: "/arrival",
    name: "arrival",
    component: Arrival,
  },
  {
    path: "/income",
    name: "Income",
    component: Income,
  },
  {
    path: "/commute",
    name: "Commute",
    component: Commute,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
