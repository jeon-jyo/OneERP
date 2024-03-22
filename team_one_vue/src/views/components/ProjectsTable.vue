<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>주문서 목록</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
              >
                주문서 번호
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                판매처
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                대표자
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                판매처 연락처
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                담당자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                구매일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                입고일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                승인상태
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                입고상태
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="order in orderList" v-bind:key="order.request_id">
              <td> {{ order.request_id }} </td>
              <td> {{ order.cl_name }} </td>
              <td> {{ order.ceo_name }} </td>
              <td> {{ order.cl_phone }} </td>
              <td> {{ order.em_name }} </td>
              <td> {{ order.begin_date }} </td>
              <td> {{ order.end_date }} </td>
              <td> {{ order.state }} </td>
              <td> {{ order.re_status }} </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed } from 'vue'
import { useStore } from 'vuex'

export default {
  name: "projects-table",
  setup() {
    const store = useStore()

    const orderList = computed(() => {
            return store.state.orderList.orderList
        }) 

    onMounted(async () => {
        await store.dispatch('orderList/fetchList')
    })

    return{
      orderList
    }
  }
};
</script>
