<template>
  <div
    class="w-auto h-auto collapse navbar-collapse max-height-vh-100 h-100"
    id="sidenav-collapse-main"
  >
    <ul class="navbar-nav">
      <li class="nav-item">
        <sidenav-collapse navText="Dashboard" :to="{ name: 'Dashboard' }">
          <template #icon>
            <shop />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="판매 - 주문서" :to="{ name: 'temp' }">
          <template #icon>
            <office />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="구매 - 주문서" :to="{ name: 'OrderTable' }">
          <template #icon>
            <office />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="영업" :to="{ name: 'Sales' }">
          <template #icon>
            <office />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="구매" :to="{ name: 'Purchase' }">
          <template #icon>
            <office />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="회계 - 재무상태표" :to="{ name: 'Finance' }">
          <template #icon>
            <credit-card />
            <box3d />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="회계 - 손익계산서" :to="{ name: 'Income' }">
          <template #icon>
            <credit-card />
            <box3d />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="인사" :to="{ name: 'Hr' }">
          <template #icon>
            <customer-support />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="부서목록" :to="{ name: 'Dept' }">
          <template #icon>
            <customer-support />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="출/퇴근" :to="{ name: 'Commute' }">
          <template #icon>
            <customer-support />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="물류 - 창고목록" :to="{ name: 'Logisics' }">
          <template #icon>
            <settings />
          </template>
        </sidenav-collapse>
      </li>
      <li class="nav-item">
        <sidenav-collapse navText="물류 - 입하내역" :to="{ name: 'arrival' }">
          <template #icon>
            <settings />
          </template>
        </sidenav-collapse>
      </li>
       <li class="nav-item">
        <sidenav-collapse navText="물류 - 출고내역" :to="{ name: 'Release' }">
          <template #icon>
            <settings />
          </template>
        </sidenav-collapse>
      </li>
        <li class="nav-item">
        <sidenav-collapse navText="물류 - 입고내역" :to="{ name: 'Warehousing' }">
          <template #icon>
            <settings />
          </template>
        </sidenav-collapse>
      </li>
    </ul>
  </div>
 
</template>
<script>
import SidenavCollapse from "./SidenavCollapse.vue";
import Shop from "../../components/Icon/Shop.vue";
import Office from "../../components/Icon/Office.vue";
import Box3d from "../../components/Icon/Box3d.vue";
import CustomerSupport from "../../components/Icon/CustomerSupport.vue";
import Settings from "../../components/Icon/Settings.vue";

export default {

  data() {
    return {
      title: "Soft UI Dashboard PRO",
      controls: "dashboardsExamples",
      isActive: "active",
    };
  },
  components: {
    SidenavCollapse,
    Shop,
    Office,
    Box3d,
    CustomerSupport,
    Settings,
  },
  methods: {
    getRoute() {
      const routeArr = this.$route.path.split("/");
      return routeArr[1];
    },
  },
};
</script>
