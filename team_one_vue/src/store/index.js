import { createStore } from "vuex";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js"
import orderList from "./modules/orderList"
import purchaseOutList from "./modules/purchaseOutList"
import empList from "./modules/empList"
import deptList from "./modules/deptList"
import orderConfirm from "./modules/orderConfirm"
import productList from "./modules/productList"
import outBoundInsert from "./modules/outBoundInsert"

import logisics from "./modules/logisics"
import release from "./modules/release"
import warehousing from "./modules/warehousing"
import arrival from "./modules/arrival"

import finance from "./modules/finance";
import income from "./modules/income";

import commute from "./modules/commute"

import orderList2 from "./modules/orderList2"
import productList2 from "./modules/productList2"
import warehouseList from "./modules/warehouseList"
import purchase from "./modules/purchase"

const modules = {
  orderList,
  purchaseOutList,
  empList,
  orderConfirm,
  productList,
  outBoundInsert,
  logisics,
  release,
  warehousing,
  arrival,
  finance,
  income,
  commute,
  orderList2,
  productList2,
  warehouseList,
  purchase,
  deptList
}

export default createStore({
  state: {
    hideConfigButton: false,
    isPinned: true,
    showConfig: false,
    isTransparent: "",
    isRTL: false,
    color: "",
    isNavFixed: false,
    isAbsolute: false,
    showNavs: true,
    showSidenav: true,
    showNavbar: true,
    showFooter: true,
    showMain: true,
    navbarFixed:
      "position-sticky blur shadow-blur left-auto top-1 z-index-sticky px-0 mx-4",
    absolute: "position-absolute px-4 mx-0 w-100 z-index-2",
    bootstrap,
  },
  mutations: {
    toggleConfigurator(state) {
      state.showConfig = !state.showConfig;
    },
    navbarMinimize(state) {
      const sidenav_show = document.querySelector(".g-sidenav-show");
      if (sidenav_show.classList.contains("g-sidenav-hidden")) {
        sidenav_show.classList.remove("g-sidenav-hidden");
        sidenav_show.classList.add("g-sidenav-pinned");
        state.isPinned = true;
      } else {
        sidenav_show.classList.add("g-sidenav-hidden");
        sidenav_show.classList.remove("g-sidenav-pinned");
        state.isPinned = false;
      }
    },
    sidebarType(state, payload) {
      state.isTransparent = payload;
    },
    cardBackground(state, payload) {
      state.color = payload;
    },
    navbarFixed(state) {
      if (state.isNavFixed === false) {
        state.isNavFixed = true;
      } else {
        state.isNavFixed = false;
      }
    },
    toggleEveryDisplay(state) {
      state.showNavbar = !state.showNavbar;
      state.showSidenav = !state.showSidenav;
      state.showFooter = !state.showFooter;
    },
    toggleHideConfig(state) {
      state.hideConfigButton = !state.hideConfigButton;
    },
  },
  actions: {
    toggleSidebarColor({ commit }, payload) {
      commit("sidebarType", payload);
    },
    setCardBackground({ commit }, payload) {
      commit("cardBackground", payload);
    },
  },
  getters: {},
  modules
});
